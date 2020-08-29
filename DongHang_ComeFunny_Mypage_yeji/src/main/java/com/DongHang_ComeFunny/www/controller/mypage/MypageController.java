package com.DongHang_ComeFunny.www.controller.mypage;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.DongHang_ComeFunny.www.model.service.mypage.MypageService;
import com.DongHang_ComeFunny.www.model.vo.GoLike;
import com.DongHang_ComeFunny.www.model.vo.User;

import common.exception.FileException;

@Controller
@RequestMapping("/mypage")
public class MypageController {
	
	@Autowired
	public MypageService mypageService;
	
	//내정보(프로필 수정) JSP 띄위기
	@RequestMapping(value = "/profile",  method = RequestMethod.GET)
	public void profile(User user, Model model, HttpSession session) {
		
		//로그인 구현 전 
		//임의로 객체에 회원정보 담기
		User sessionUser = new User();
		sessionUser.setuNo(2);
		sessionUser.setUserId("길동id");

		//회원정보를 세선에 담기
		session.setAttribute("login", sessionUser);
				
		//세션에 있는 회원번호를 가져와서 uno에 대입한다
		int uNo = ((User)(session.getAttribute("login"))).getuNo();
		
		//회원번호를 통해서 회원정보 조회
//		user = mypageService.getUserInfo(uNo);		
		
		//회원정보, 프로필 사진 회원정보 조회
		Map<String, Object> userInfo = mypageService.selectUserInfo(uNo);
		
		
		//조회된 결과를 loginInfo에 담아서 JSP에 보내준다
		model.addAttribute("loginInfo", userInfo);

	}
	
	//프로필이미지 등록
	@RequestMapping(value = "/insertProfile", method = RequestMethod.POST)
	public String insertProfile(@RequestParam List<MultipartFile> files,User user, Model model, HttpSession session) throws FileException {

		//session안에 있는 userId를 가져와서 User에 넣어주기
		int uNo = ((User)(session.getAttribute("login"))).getuNo();

		String root = session.getServletContext().getRealPath("/");


		int res = mypageService.insertUserImg(uNo, files, root);

		if(res > 0) {
			model.addAttribute("alertMsg", "프로필 등록에 성공했습니다.");
			model.addAttribute("url", "/mypage/profile");
		} else {
			model.addAttribute("alertMsg", "프로필 등록에 실패했습니다.");
			model.addAttribute("url", "/mypage/profile");
		}

		return "common/result";

	}
	
	
	//프로필이미지 수정 
	@RequestMapping(value = "/changeProfile", method = RequestMethod.POST)
	public String changeProfileImpl(@RequestParam List<MultipartFile> files,User user, Model model, HttpSession session) throws FileException {
		
		//session안에 있는 userId를 가져와서 User에 넣어주기
		int uNo = ((User)(session.getAttribute("login"))).getuNo();

		String root = session.getServletContext().getRealPath("/");
		
		
		int res = mypageService.updateUserImg(uNo, files, root);
		
		if(res > 0) {
			model.addAttribute("alertMsg", "프로필 수정에 성공했습니다.");
			model.addAttribute("url", "/mypage/profile");
		} else {
			model.addAttribute("alertMsg", "프로필 수정에 실패했습니다.");
			model.addAttribute("url", "/mypage/profile");
		}
		
		return "common/result";
		
	}
	
	//원본 이미지로 변경(프로필 삭제) 
	@RequestMapping(value = "/changeDeafultImg", method = RequestMethod.POST)
	public String changeDeafultImg(User user, Model model, HttpSession session) throws FileException {

		//session안에 있는 userId를 가져와서 User에 넣어주기
		int uNo = ((User)(session.getAttribute("login"))).getuNo();

		int res = mypageService.deleteProfileImg(uNo);

		if(res > 0) {
			model.addAttribute("alertMsg", "기본 프로필 이미지로 변경했습니다.");
			model.addAttribute("url", "/mypage/profile");
		} else {
			model.addAttribute("alertMsg", "기본 프로필 이미지로 변경 실패했습니다.");
			model.addAttribute("url", "/mypage/profile");
		}

		return "common/result";

	}
	
	
	
	
	//내정보(프로필 수정) 수정 폼
	@RequestMapping(value = "/profile",  method = RequestMethod.POST)
	public String profileImpl(User user, Model model, HttpSession session) {
		
		//session안에 있는 userId를 가져와서 User에 넣어주기
		User sessionUser = (User)session.getAttribute("login");
		user.setUserId(sessionUser.getUserId());
		
		//DB안에 있는 User(회원)정보 수정
		int res = mypageService.updateUser(user);
		System.out.println("result modify = " + res);
		
		if(res > 0) {
			model.addAttribute("alertMsg", "개인정보수정에 성공했습니다.");
			model.addAttribute("url", "/mypage/profile");
			
			sessionUser.setuNick(user.getuNick());
			sessionUser.setuMail(user.getuMail());
			sessionUser.setuPw(user.getuPw());
			sessionUser.setuPhone(user.getuPhone());
		} else {
			model.addAttribute("alertMsg", "개인정보수정에 실패했습니다.");
			model.addAttribute("url", "/mypage/profile");
		}
		
		return "common/result";

	}
	
	//비밀번호 확인 체크
	@RequestMapping(value = "/pwcheck",  method = RequestMethod.POST)
	@ResponseBody
	public int pwCheck(String uPw, HttpSession session) {
		
		String userId = ((User)(session.getAttribute("login"))).getUserId();
		
		int res = mypageService.selectPwCheck(userId, uPw);
		
		if(res > 0) { //비밀번호 일치
			return 1;
		} else { //비밀번호 불일치
			return 0;
		}
		
	}
	

	//함께가요(do) 찜목록 JSP 띄위기
	@RequestMapping(value = "/likelist",  method = RequestMethod.GET)
	public void likeListImpl(User user, Model model, HttpSession session) {

		//로그인 구현 전 
		//임의로 객체에 회원정보 담기
		User sessionUser = new User();
		sessionUser.setuNo(2);
		sessionUser.setUserId("길동id");

		//회원정보를 세선에 담기
		session.setAttribute("login", sessionUser);
		
		//session안에 있는 userId를 가져와서 User에 넣어주기
		int uNo = ((User)(session.getAttribute("login"))).getuNo();
		
		//함께해요 찜목록 조회
		List<Object> likeList = mypageService.selectLikelist(uNo);
		
		
		model.addAttribute("likeList", likeList);

	}
	
	
	//함께가요(do) 찜목록 삭제
	@RequestMapping(value = "/deleteLike",  method = RequestMethod.POST)
	@ResponseBody
	public String deleteLikeImpl(String dbNo, HttpSession session) {
		
		//로그인 구현 전 
		//임의로 객체에 회원정보 담기
		User sessionUser = new User();
		sessionUser.setuNo(2);
		sessionUser.setUserId("길동id");

		//회원정보를 세선에 담기
		session.setAttribute("login", sessionUser);
		
		int uNo = ((User)(session.getAttribute("login"))).getuNo();
		
		int res = mypageService.deleteDoLike(Integer.toString(uNo), dbNo);
		
		if(res > 0) { //찜목록 삭제 성공
			return "#likeboxdelete" + dbNo;
		} else { //찜목록 삭제 실패
			return "fail";
		}
		

	}
	
	//함께가요(go) 찜목록 JSP띄위기
	@RequestMapping(value = "/golike", method = RequestMethod.GET )
	public ModelAndView golike(
			//현재 페이지(반드시 있지 않아도 되고 없을 경우에 1페이지로)	
			@RequestParam(required = false, defaultValue = "1") int cPage, HttpSession session) {
		
		//로그인 구현 전 
		//임의로 객체에 회원정보 담기
		User sessionUser = new User();
		sessionUser.setuNo(2);
		sessionUser.setUserId("길동id");

		//회원정보를 세선에 담기
		session.setAttribute("login", sessionUser);
		
		//세션에 있는 uno값 가져오기		
		int uNo = ((User)(session.getAttribute("login"))).getuNo();
		
		//ModelAndView 객체 생성
		ModelAndView mav = new ModelAndView();
		
		//페이지당 보여줄 게시글 수
		int cntPerPage = 10;


		//golikelist, paging를 담은 Map 객체 생성
		Map<String, Object> commandMap = mypageService.selectGoLikeList(cPage, cntPerPage, uNo);
		
		mav.addObject("paging", commandMap.get("paging"));
		mav.addObject("golikeList", commandMap);
		
		System.out.println("commandmAP" + commandMap);
		
		mav.setViewName("mypage/golike");

		return mav;
		
	}
	
	//함께가요(go) 찜목록 삭제
	@RequestMapping(value = "/deletegolike", method = RequestMethod.POST )
	@ResponseBody
	public int deletegolike(@RequestParam(value="deleteChk")List<String> chArr 
				, GoLike golike, HttpSession session) {

		//로그인 구현 전 
		//임의로 객체에 회원정보 담기
		User sessionUser = new User();
		sessionUser.setuNo(2);
		sessionUser.setUserId("길동id");

		//회원정보를 세선에 담기
		session.setAttribute("login", sessionUser);

		//세션에 있는 uno값 가져오기		
		int uNo = ((User)(session.getAttribute("login"))).getuNo();
	
		//게시글번호
	    int glGbNo = 0;
	    
	    int res = 0;
	    
	    //GoLike에 삭제버튼을 클릭한 게시글 번호, 회원번호를 담아준다
	    for(String i : chArr) {
	    	glGbNo = Integer.parseInt(i);
	    	golike.setGlGbNo(glGbNo);
	    	golike.setGlUNo(uNo);

	    	//함께가요 찜목록 삭제 메소드
	    	res = mypageService.deleteGoLike(golike);	      
	    }
	    
	    
	    
	    if(res > 0) { //삭제가 되면
	    	return 1;
	    } else { //삭제가 안되면
	    	return 0;
	    }
	    		

	}
	
	
	
	//신청한 동행 JSP 띄위기
	@RequestMapping(value = "/applydonghang",  method = RequestMethod.GET)
	public void applydonghang() {
			
	}
	
	//나의 동행 관리 JSP 띄위기
	@RequestMapping(value = "/mydonghang",  method = RequestMethod.GET)
	public void mydonghang() {
					
	}

		
	//후기 게시판 JSP 띄우기
	@RequestMapping(value = "/commentlist",  method = RequestMethod.GET)
	public void commentlist() {
			
	}

	//자유게시판 JSP 띄위기
	@RequestMapping(value = "/fboardlist",  method = RequestMethod.GET)
	public void fboardlist() {
			
	}
	

	//리뷰게시판 JSP 띄우기
	@RequestMapping(value = "/rboardlist",  method = RequestMethod.GET)
	public void rboardlist() {
					
	}
	
	//동행복권 결제내역 JSP 띄우기
	@RequestMapping(value = "/paymentlist",  method = RequestMethod.GET)
	public void paymentlist() {
				
	}

	//동행복권 사용내역 JSP 띄우기
	@RequestMapping(value = "/usingList",  method = RequestMethod.GET)
	public void usingList() {
						
	}	
	
	
	
	
	
}
