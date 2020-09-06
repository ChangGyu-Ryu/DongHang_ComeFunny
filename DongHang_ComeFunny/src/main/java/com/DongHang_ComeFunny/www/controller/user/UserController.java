package com.DongHang_ComeFunny.www.controller.user;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.Random;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.DongHang_ComeFunny.www.model.service.user.UserService;
import com.DongHang_ComeFunny.www.model.vo.User;
import com.fasterxml.jackson.databind.JsonNode;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	public UserService userService;
	@Autowired
	private KakaoController kakaoController = new KakaoController();
	
	@RequestMapping(value="/message", method=RequestMethod.GET)
	public void message() {
		
	}
	@RequestMapping(value="/messageImpl", method=RequestMethod.POST)
	public String messageImpl() throws NoSuchAlgorithmException, UnsupportedEncodingException, InvalidKeyException {
		String space = " ";					// one space
		String newLine = "\n";					// new line
		String method = "GET";					// method
		String url = "/photos/puppy.jpg?query1=&query2";	// url (include query string)
		String timestamp = "{timestamp}";			// current timestamp (epoch)
		String accessKey = "{accessKey}";			// access key id (from portal or Sub Account)
		String secretKey = "{secretKey}";

		String message = new StringBuilder()
			.append(method)
			.append(space)
			.append(url)
			.append(newLine)
			.append(timestamp)
			.append(newLine)
			.append(accessKey)
			.toString();

		SecretKeySpec signingKey = new SecretKeySpec(secretKey.getBytes("UTF-8"), "HmacSHA256");
		Mac mac = Mac.getInstance("HmacSHA256");
		mac.init(signingKey);

		byte[] rawHmac = mac.doFinal(message.getBytes("UTF-8"));
		String encodeBase64String = Base64.encodeBase64String(rawHmac);

	  return encodeBase64String;
	}
	
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
		User res = userService.selectMember(commandMap);
		
		//로그인에 성공한다면
		if(res != null) {
			session.setAttribute("logInInfo", res);
			model.addAttribute("alertMsg", "로그인 성공~!");
			model.addAttribute("url", "/");
		} else {
			model.addAttribute("alertMsg", "로그인 실패~!");
			model.addAttribute("url", "login");
		}

		return "/common/result";

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
		user.setuBirth(birthYear+birthMonth+birthDay);

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
	@RequestMapping(value="/idChk", method = RequestMethod.POST)
	@ResponseBody
	public void idChk(@RequestParam("userid")String user, HttpServletResponse response) throws Exception {
		userService.idChk(user, response);
	}
	
	//아이디 찾기 페이지
	@RequestMapping(value="/fId", method=RequestMethod.GET)
	public String fId() {
		return "/user/fId";
	}
	
	//아이디 찾기 액션
	@RequestMapping(value="/fId", method=RequestMethod.POST)
	@ResponseBody
	public String fId(@RequestParam Map<String, Object> commandMap) {
		
		//requestparm uname umail을 담을 빈 User 객체 생성
		User user = new User();
		user.setuName(commandMap.get("uName").toString());
		user.setuMail(commandMap.get("uMail").toString());
		String result = userService.fId(user);
		System.out.println("[controller] fid result : " + result);
		
		return result;
	}
		

	//비밀번호 찾기 페이지
	@RequestMapping(value="/fPw", method=RequestMethod.GET)
	public ModelAndView fPw(HttpSession session) {
			ModelAndView mav = new ModelAndView();
			int ran = new Random().nextInt(900000) + 100000;
			String random = String.valueOf(ran);
			session.setAttribute("random", random);
			mav.setViewName("/user/fPw");
			mav.addObject("random",random);
		return mav;
	}
	
	@RequestMapping(value="/createEmailCheck", method=RequestMethod.GET)
	@ResponseBody
	public boolean createEmailCheck(@RequestParam String uEmail, HttpServletRequest req){
	//이메일 인증 - 인증번호 발송
		HttpSession session = req.getSession(true);
		String sendEmailId = "donghangcome@gmail.com";
		String authCode = (String) session.getAttribute("random");
		session.setAttribute("authCode", authCode);
		String subject = "회원가입 인증 코드 발급 안내 입니다.";
		StringBuilder sb = new StringBuilder();
		sb.append("귀하의 인증 코드는 " + authCode + "입니다.");
		return userService.send(subject, sb.toString(), sendEmailId, uEmail);
	}

	//이메일 인증 - 인증번호 확인
	@RequestMapping(value="/emailAuth", method=RequestMethod.GET)
	@ResponseBody
		public ResponseEntity<String> emailAuth(HttpSession session){
		String originalJoinCode = (String) session.getAttribute("authCode");
		String originalRandom = (String) session.getAttribute("random");
		if(originalJoinCode.equals(originalRandom))
		return new ResponseEntity<String>("complete", HttpStatus.OK);
		else return new ResponseEntity<String>("false", HttpStatus.OK);
	}

	//인증메일 보내기위한 조회
	@RequestMapping(value="userChk", method = RequestMethod.GET)
	@ResponseBody
	public String userChk(String uName, String userId, String uEmail) {
		
		//uName, userId, uMail을 담을 객체 생성
		User user = new User();
		user.setuName(uName);
		user.setUserId(userId);
		user.setuMail(uEmail);

		String result = userService.userChk(user);
		if(result == null || result == "") {

			return "0";
		}
		else {
			return "1";
		}
	}
	
	//비밀번호 변경 페이지
	@RequestMapping(value="/fPwChange", method=RequestMethod.GET)
	public String fPwChange() {
		return "/user/fPwChange";
	}

	//비밀번호 변경
	@RequestMapping(value="/changePassword", method = RequestMethod.POST)
	public String changePassword(@RequestParam String userId
			, String uPw, Model model) {

		User user = new User();
		user.setUserId(userId);
		user.setuPw(uPw);
		System.out.println(user);
		
		int res = userService.updateUser(user);
		System.out.println("result = " + res);
		
		if(res > 0) {
			model.addAttribute("alertMsg", "비밀번호 변경에 성공했습니다.");
			model.addAttribute("url", "/user/login");
			
//			sessionUser.setuPw(user.getuPw());
		} else {
			model.addAttribute("alertMsg", "비밀번호 변경에 실패했습니다.");
			model.addAttribute("url", "/user/fPwChange");
		}
		
//		userService.changePassword(user);
		
		return "common/result";

	}
	
	
	
}
