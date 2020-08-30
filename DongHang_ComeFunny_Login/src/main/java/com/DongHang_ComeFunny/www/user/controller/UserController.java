package com.DongHang_ComeFunny.www.user.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.DongHang_ComeFunny.www.user.model.dao.UserDao;
import com.DongHang_ComeFunny.www.user.model.service.UserService;
import com.DongHang_ComeFunny.www.user.model.vo.User;
import com.fasterxml.jackson.databind.JsonNode;

import common.exception.MailException;

@Controller
@RequestMapping("/user")
public class UserController {

   @Autowired
   public UserService userService;
   private KakaoController kakaoController = new KakaoController();
   private UserDao userDao;

   @RequestMapping(value="/login", method=RequestMethod.GET)
   public ModelAndView login() {
      ModelAndView mav = new ModelAndView();
      mav.setViewName("/user/login");
      return mav;
   }

   @RequestMapping(value = "/oauth", produces = "application/json")
   public String kakaoLogin(@RequestParam("code") String code, Model model, HttpSession session) {
       System.out.println("로그인 할때 임시 코드값");
       //카카오 홈페이지에서 받은 결과 코드
       System.out.println(code);
       System.out.println("로그인 후 결과값");
       
       //카카오 rest api 객체 선언
       KakaoController kr = new KakaoController();
       //결과값을 node에 담아줌
       JsonNode node = kr.getKakaoUserInfo(code);
       //결과값 출력
       System.out.println(node);
       //노드 안에 있는 access_token값을 꺼내 문자열로 변환
       String token = node.get("access_token").toString();
       //세션에 담아준다.
       session.setAttribute("token", token);
       
       return "/board/freelist";
   }

  @RequestMapping(value="/loginimple", method=RequestMethod.POST)
  public String loginImpl(
        @RequestParam Map<String, Object> commandMap
        , HttpSession session
        , Model model
        ) {
     
//     String kakaoUrl = kakaoController.getAuthorizationUrl(session);
//
//       /* 생성한 인증 URL을 View로 전달 */
//       model.addAttribute("kakao_url", kakaoUrl);

     User res = userService.selectMember(commandMap);
     //로그인에 성공한다면
     if(res != null) {
        session.setAttribute("logInInfo", res);
        model.addAttribute("alertMsg", "로그인 성공~!");
        model.addAttribute("url", "login");
     } else {
        model.addAttribute("alertMsg", "로그인 실패~!");
        model.addAttribute("url", "join");
     }

     return "/board/freelist";

  }

   @RequestMapping(value="/join", method=RequestMethod.GET)
   public ModelAndView join() {
      ModelAndView mav = new ModelAndView();
      mav.setViewName("/user/join");
      return mav;
   } 

   @RequestMapping(value="/joinimple", method=RequestMethod.POST)
   public String joinimpl(@ModelAttribute User user, Model model, HttpServletRequest request) {
      String root = request.getContextPath();
      String birthYear = request.getParameter("ubirthyy");
      String birthMonth = request.getParameter("ubirthmm");
      String birthDay = request.getParameter("ubirthdd");
      user.setUbirth(birthYear+birthMonth+birthDay);

      int res = userService.insertUser(user);
      if(res > 0) {
         //addAttribute : ModelAndView의 addObject와 같다
         model.addAttribute("alertMsg", "회원가입에 성공했습니다.");
         model.addAttribute("url", root+"/user/login");

      } else {
         model.addAttribute("alertMsg", "회원가입에 실패했습니다.");
         model.addAttribute("url", root+"/user/join");

      }

      return "common/result";

   }
   
   //아이디 중복 체크
   @ResponseBody
   @RequestMapping(value="/idChk", method = RequestMethod.POST)
   public void idChk(@RequestParam("userid")String user, HttpServletResponse response) throws Exception {
      userService.idChk(user, response);
   }
   
 //아이디 찾기 페이지
 	@RequestMapping(value="/fId", method=RequestMethod.GET)
 	public String fId() {
 		return "/user/fId";
 	}
 	
 	//아이디 찾기 액션
// 	@RequestMapping(value="/fId", method=RequestMethod.POST)
// 	@ResponseBody
// 	public String fId(@RequestParam(value="uname", required=true) String uname
// 			, @RequestParam(value="umail", required=true) String umail) {
// 		
// 		String result = userService.fId(uname, umail);
// 		
// 		return result;
// 	}
 
 	//아이디 찾기 액션
 	@RequestMapping(value="/fIdResult", method=RequestMethod.POST)
    //fIdResult함수 선언 후 매개변수는 fId.jsp에서 POST되어 보내진 uname, umail과 윈도우창에서 출력할 서블릿 객체(HttpServletResponse) 선언
    public void fIdResult(String uname, String umail, HttpServletResponse response) throws IOException{
       response.setCharacterEncoding("UTF-8"); // 출력시 한글 깨짐 방지를 위해 새로 인코딩
       
       PrintWriter out = response.getWriter(); // 자바 출력객체 printwriter에 서블릿객체의 값을 저장해 생성
       
       //userDao에 있는 FindId함수의 결과값이 true이면
       if(userDao.FindId(uname, umail) == true) {
          //User라는 value 객체 user에(VO부분에 생성한 User.java
          //userDao에 있는 getId함수의 결과값을 저장(uname과 umail값을 담는다)
          User user = userDao.getId(uname, umail);
          String userid = user.getUserid(); // 문자열 변수 userid에 user에 있는 Userid를 가져와 저장
          
          //츨력객체 out변수를 이용해 결과값 전송
          //result에 아이디 값을 담아 view단에 출력
          out.write("({'result':'입력하신 정보와 일치하는 아이디는 " + userid + "입니다.'})");
          
          //userDao에 있는 FindId함수의 결과값이 false일때
       } else {
          
          //result에 메세지를 담아 view단에서 출력함
          out.write("({'result': '입력하신 정보로 찾을 수 없습니다.'})");
       }
       
    }
 	
/*

   //아이디 찾기
   @RequestMapping(value="fIdimple", method=RequestMethod.POST)
   public String fIdimple(@ModelAttribute User user, Model model
         , @RequestParam String email) {

      User res = userService.findId(email);
      if(res != null) {
         model.addAttribute("alertMsg", "귀하의 이메일 주소로 해당 이메일로 가입된 아이디를 발송 하였습니다.");
         model.addAttribute("url", root + "/user/login");
      } else {
         model.addAttribute("alertMsg", "귀하의 이메일로 가입된 아이디가 존재하지 않습니다.");
         model.addAttribute("url", root + "/user/fId");
      }

      return "common/result";
   }
*/
   
   //비밀번호 찾기 페이지
   @RequestMapping(value="/fPw", method=RequestMethod.GET)
   public ModelAndView fPw() {
      ModelAndView mav = new ModelAndView();
      mav.setViewName("/user/fPw");
      return mav;
   }
   

   //비밀번호 찾기 인증번호 메일 발송
   @RequestMapping(value = "fPwEmailCheck", method=RequestMethod.POST)
   public ModelAndView fPwEmailCheck(
         User user
         , HttpServletRequest request) throws MailException {
      
      ModelAndView mav = new ModelAndView();
      
      String urlPath = request.getServerName()
            +":"+request.getServerPort()
            +request.getContextPath();
      
      int dice = userService.mailSending(user, urlPath);
      mav.addObject("url", "fPw");
      mav.addObject("dice", "dice");
      mav.setViewName("/user/fPw");
      return mav;
   }

   /*
   //비밀번호 찾기
   @RequestMapping(value = "/fPwimple", method=RequestMethod.POST)
    public @ResponseBody Map<String, Boolean> fPwImpl(String umail, String userid){
        Map<String,Boolean> json = new HashMap<>();
        boolean pwFindCheck = userService.userEmailCheck(userid, umail);

        System.out.println(pwFindCheck);
        json.put("check", pwFindCheck);
        return json;
    }
   */
   
   /*
   //비밀번호 찾기
   @RequestMapping(value="fPwimple", method=RequestMethod.POST)
   public ModelAndView fPwimpl(String userid, String umail
         , HttpServletRequest request
         , HttpServletResponse response_umail) throws IOException {

      //랜덤 인증번호 생성, 인증번호 입력후 비밀번호 변경 페이지로 이동
      Random r = new Random();
      int dice = r.nextInt(157211)+48271;

      String setfrom = "rlagurwkd11@naver.com"; //보내는사람
      String tomail = request.getParameter("umail"); //받는사람 이메일
      String title = "비밀번호 찾기 인증 이메일 입니다.";   //제목
      String content = 
      
         System.getProperty("line.separator")+
         System.getProperty("line.separator")+
         "안녕하세요 회원님 저희 홈페이지를 찾아주셔서 감사합니다"
         +System.getProperty("line.separator")+
         System.getProperty("line.separator")+
         "비밀번호 찾기 인증번호는 " + dice + "입니다."
         +System.getProperty("line.separator")+
         System.getProperty("line.separator")+
         "받으신 인증번호를 홈페이지에 입력해 주세요!";   //메일 내용
         
      try {
          
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");

            messageHelper.setFrom(setfrom); // 보내는사람 생략하면 정상작동을 안함
            messageHelper.setTo(tomail); // 받는사람 이메일
            messageHelper.setSubject(title); // 메일제목은 생략이 가능하다
            messageHelper.setText(content); // 메일 내용
            
            mailSender.send(message);
    
        } catch (Exception e) {
            System.out.println(e);
        }
      
      ModelAndView mav = new ModelAndView();    //ModelAndView로 보낼 페이지를 지정하고, 보낼 값을 지정한다.
        mav.setViewName("/user/fPwEmail");     //뷰의이름
        mav.addObject("dice", dice);
        mav.addObject("umail", umail);
        
        System.out.println("mav : " + mav);
        
        response_umail.setContentType("text/html; charset=UTF-8");
        PrintWriter out_email = response_umail.getWriter();
        out_email.println("<script>alert('이메일이 발송되었습니다. 인증번호를 입력해주세요.');</script>");
        out_email.flush();
        
        return mav;
   }
   
   //인증번호를 입력한 후에 확인 버튼을 누르면 자료가 넘어오는 컨트롤러
   @RequestMapping(value = "fPwCheck", method = RequestMethod.POST)
   public ModelAndView fPwCheck(String fPwCheck, @PathVariable String dice
         , @PathVariable String umail
         , HttpServletResponse response_equals) throws IOException {
      System.out.println("마지막 : fPwCheck : " + fPwCheck);
      
      System.out.println("마지막 : dice : " + dice);
      
      ModelAndView mav = new ModelAndView();
      mav.setViewName("/user/fPwChange");
      mav.addObject("umail", umail);
      
      if(fPwCheck.equals(dice)) {
         
         //인증번호가 일치할경우 확인창 출력후 비밀번호 변경창으로 이동
         
         mav.setViewName("/user/fPwChange");
         mav.addObject("umail", umail);
         
         response_equals.setContentType("text/html; charset=UTF-8");
         PrintWriter out_equals = response_equals.getWriter();
            out_equals.println("<script>alert('인증번호가 일치하였습니다. 비밀번호 변경창으로 이동합니다.');</script>");
            out_equals.flush();
    
            return mav;
      } else if (fPwCheck != dice) {
         ModelAndView mav2 = new ModelAndView();
         
         mav2.setViewName("/user/fPwChangeFail");
         
         response_equals.setContentType("text/html; charset=UTF-8");
            PrintWriter out_equals = response_equals.getWriter();
            out_equals.println("<script>alert('인증번호가 일치하지않습니다. 인증번호를 다시 입력해주세요.'); history.go(-1);</script>");
            out_equals.flush();
            
    
            return mav2;
            
        }    
    
        return mav;
   }
   
   //변경할 비밀번홀르 입력한 후에 확인 버튼을 누르면 넘어오는 컨트롤러
   @RequestMapping(value = "/user/fPwChange", method = RequestMethod.POST)
    public ModelAndView pass_change(@PathVariable String umail, HttpServletRequest request, MemberDTO dto, HttpServletResponse pass) throws Exception{
                
    String member_pass = request.getParameter("member_pass");
                
    String umail1 = umail;
                
    dto.setE_mail(umail1);
    dto.setMember_pass(member_pass);
    
    //값을 여러개 담아야 하므로 해쉬맵을 사용해서 값을 저장함
    
    Map<String, Object> map = new HashMap<>();
    
    map.put("e_mail", dto.getE_mail());
    map.put("member_pass", dto.getMember_pass());
    
    userService.pass_change(map,dto);
    
    ModelAndView mav = new ModelAndView();
    
    mav.setViewName("/user/fId");
    
    return mav;
                
    }
    */
}