package com.DongHang_ComeFunny.www.controller.mypage;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.naming.spi.DirStateFactory.Result;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.DongHang_ComeFunny.www.model.service.mypage.FboardListService;
import com.DongHang_ComeFunny.www.model.vo.DoApply;
import com.DongHang_ComeFunny.www.model.vo.FreeBoard;
import com.DongHang_ComeFunny.www.model.vo.FreeComment;
import com.DongHang_ComeFunny.www.model.vo.GoApply;
import com.DongHang_ComeFunny.www.model.vo.GoBoard;
import com.DongHang_ComeFunny.www.model.vo.Order;
import com.DongHang_ComeFunny.www.model.vo.ReviewBoard;
import com.DongHang_ComeFunny.www.model.vo.User;

@Controller
@RequestMapping("/mypage")
public class MypageController {
	private final static Logger logger = Logger.getGlobal();
	
	@Autowired
	FboardListService fboardlistservice;
	
	//내정보(프로필 수정) JSP 띄위기
	@RequestMapping(value = "/profile",  method = RequestMethod.GET)
	public void profile(User user, Model model, HttpSession session) {
		
		
		//session안에 임의값 넣어주기
		User sessionUser = new User();
		sessionUser.setuNo(5);
		
		
	}
	
	
	//찜목록 JSP 띄위기
	@RequestMapping(value = "/likelist",  method = RequestMethod.GET)
	public void likeList() {
		
	}
	
	//신청한 동행(함께가요) JSP 띄위기
	@RequestMapping(value = "/applydonghang",  method = RequestMethod.GET)
	public ModelAndView applydonghang(@RequestParam(required = false, defaultValue = "1")int cPage, HttpSession session) {
		User sessionUser = new User();
		sessionUser.setuNo(5);
	    //회원정보를 세선에 담기
	    session.setAttribute("loginInfo", sessionUser);
		
	    //세션 부르기
		sessionUser= (User) session.getAttribute("loginInfo");
		
		int uno = sessionUser.getuNo();
		
		ModelAndView mav = new ModelAndView();
		//페이징 
		int cntPerPage = 5;
		Map<String, Object> commandMap = fboardlistservice.selectApDhList(cPage, cntPerPage, uno);		
		mav.addObject("paging", commandMap.get("paging"));
		mav.addObject("AplyDhData", commandMap);
		mav.setViewName("mypage/applydonghang");	
		
		return mav;	
	}
	//신청한 동행(함께가요)삭제
	@ResponseBody
	@RequestMapping(value = "/applydonghang/delete",  method = RequestMethod.POST)
	public int deleteapplydonghang(HttpSession session, @RequestParam(value="deleteChk")List<String> chArr, GoApply goapply) {
		System.out.println("ajax 통신 성공");
		System.out.println("chArr : " + chArr);
		
		User sessionUser = new User();
		sessionUser.setuNo(5);
	    //회원정보를 세선에 담기
	    session.setAttribute("loginInfo", sessionUser);
		
	    //세션 부르기
		sessionUser= (User) session.getAttribute("loginInfo");
		
		String uno = Integer.toString(sessionUser.getuNo());
		
		int result = 0;
		int gano = 0;
		
		if(uno != null || uno!="") {
			for(String i : chArr) {
				gano = Integer.parseInt(i);
				goapply.setGaNo(gano);;
				fboardlistservice.deleteAplyDhList(goapply);
			}
			result=1;
		}
		
		return result;
	}
	
	
	
	//신청한 동행(함께 해요) JSP 띄위기
	@RequestMapping(value = "/doapplydonghang",  method = RequestMethod.GET)
	public ModelAndView doapplydonghang(@RequestParam(required = false, defaultValue = "1")int cPage, HttpSession session) {
		User sessionUser = new User();
		sessionUser.setuNo(5);
	    //회원정보를 세선에 담기
	    session.setAttribute("loginInfo", sessionUser);
		
	    //세션 부르기
		sessionUser= (User) session.getAttribute("loginInfo");
		
		int uno = sessionUser.getuNo();
		
		ModelAndView mav = new ModelAndView();
		//페이징 
		int cntPerPage = 5;
		Map<String, Object> commandMap = fboardlistservice.selectDoApDhList(cPage, cntPerPage, uno);		
		mav.addObject("paging", commandMap.get("paging"));
		mav.addObject("DoAplyDhData", commandMap);
		mav.setViewName("mypage/doapplydonghang");	
		
		return mav;	
	}
	//신청한 동행(함께가요)삭제
	@ResponseBody
	@RequestMapping(value = "/doapplydonghang/delete",  method = RequestMethod.POST)
	public int deletedoapplydonghang(HttpSession session, @RequestParam(value="deleteChk")List<String> chArr, DoApply doapply) {
		System.out.println("ajax 통신 성공");
		System.out.println("chArr : " + chArr);
		
		User sessionUser = new User();
		sessionUser.setuNo(5);
	    //회원정보를 세선에 담기
	    session.setAttribute("loginInfo", sessionUser);
		
	    //세션 부르기
		sessionUser= (User) session.getAttribute("loginInfo");
		
		String uno = Integer.toString(sessionUser.getuNo());
		
		int result = 0;
		int dano = 0;
		
		if(uno != null || uno!="") {
			for(String i : chArr) {
				dano = Integer.parseInt(i);
				doapply.setDaNo(dano);
				fboardlistservice.deleteDoAplyDhList(doapply);
			}
			result=1;
		}
		
		return result;
	}
	
	//(함께 가요)나의 동행  JSP 띄위기
	@RequestMapping(value = "/mydonghang",  method = RequestMethod.GET)
	public ModelAndView mydonghang(@RequestParam(required = false, defaultValue = "1")int cPage, HttpSession session) {
		User sessionUser = new User();
		sessionUser.setuNo(2);
	    //회원정보를 세선에 담기
	    session.setAttribute("loginInfo", sessionUser);
		
	    //세션 부르기
		sessionUser= (User) session.getAttribute("loginInfo");
		
		int uno = sessionUser.getuNo();
		int gbno = 0;
		String gbcategory = "";
		ModelAndView mav = new ModelAndView();
		//페이징 
		int cntPerPage = 5;
		Map<String, Object> commandMap = fboardlistservice.selectMyGoDhList(cPage, cntPerPage, uno);	
		
//		Map<String, Object> commandMap2 = fboardlistservice.selectrecruitList(gbno,gbcategory);		
		mav.addObject("recruitnum", commandMap.get("recruitnum"));
		mav.addObject("recruit", commandMap.get("recruit"));
		
		mav.addObject("paging", commandMap.get("paging"));
		mav.addObject("GoMyDhData", commandMap.get("mygodhList"));
		mav.setViewName("mypage/mydonghang");	
//		System.out.println("풀러줘ㅠ : " + commandMap.get("recruit"));
		
//		System.out.println("맵으로 묶어서 부르기 : " + commandMap.get("recruitList"+i));
//		List<Map> temp = (List<Map>) commandMap.get("recruit");
//		System.out.println("temp.get(0) : " + temp.get(0));
//		List<List> ttemp = (List<List>) temp.get(0);
//		System.out.println("UNO : " + ttemp.get(0));
		System.out.println("mav : " + mav);
//		
		
		
		
		
		return mav;
	
	}

//	//(함께 가요)나의 동행 관리 JSP 띄위기
//		@RequestMapping(value = "/mydonghang",  method = RequestMethod.GET)
//		public ModelAndView mydonghang(@RequestParam(required = false, defaultValue = "1")int cPage, HttpSession session, HttpServletRequest req) {
//			User sessionUser = new User();
//			sessionUser.setuNo(5);
//		    //회원정보를 세선에 담기
//		    session.setAttribute("loginInfo", sessionUser);
//			
//		    //세션 부르기
//			sessionUser= (User) session.getAttribute("loginInfo");
//						
//			int uno = sessionUser.getuNo();
//			int gbno = 0;
//			
//			if(req.getParameter("gbno") != null) {
//				gbno = Integer.parseInt(req.getParameter("gbno"));
//				System.out.println("gbno 입니다" + gbno);
//				
//			}
//			
//			
//			
//			ModelAndView mav = new ModelAndView();
//			//페이징 
//			int cntPerPage = 5;
////			Map<String, Object> commandMap = fboardlistservice.selectMyGoDhList(cPage, cntPerPage, uno, gbno );		
//			
//			mav.addObject("paging", commandMap.get("paging"));
//			mav.addObject("GoMyDhData", commandMap);
//			mav.setViewName("mypage/mydonghang");	
//			System.out.println("mav : " + mav);
//			return mav;
//		
//		}
	//나의 동행삭제
	@ResponseBody
	@RequestMapping(value = "/mydonghang/delete",  method = RequestMethod.POST)
	public int deletemydonghang(HttpSession session, @RequestParam(value="deleteChk")List<String> chArr, GoBoard goboard) {
		System.out.println("ajax 통신 성공");
		System.out.println("chArr : " + chArr);
		
		User sessionUser = new User();
		sessionUser.setuNo(2);
	    //회원정보를 세선에 담기
	    session.setAttribute("loginInfo", sessionUser);
		
	    //세션 부르기
		sessionUser= (User) session.getAttribute("loginInfo");
		
		String uno = Integer.toString(sessionUser.getuNo());
		
		int result = 0;
		int gbno = 0;
		
		if(uno != null || uno!="") {
//			for(String i : chArr) {
//				gbno = Integer.parseInt(i);
//				goboard.setGbNo(gbno);
//				fboardlistservice.deleteGoMyDhList(goboard);
//			}
			
			String param = "";
			System.out.println("size : "+chArr.size());
			if(chArr.size() == 2) {
				param = chArr.get(0)+","+chArr.get(1);
				fboardlistservice.deleteMyDhList(param);
				System.out.println("param : " + param);
			}else {
				for(int i=0; i<chArr.size(); i++) {
					System.out.println(chArr.get(i));
					param = chArr.get(i);		
					fboardlistservice.deleteMyDhList(param);
				}
			}
			result=1;
		}
		
		return result;
	}
	
//	//나의 동행(함께가요) 모달
//	@ResponseBody
//	@RequestMapping(value = "/mydonghang/admin",  method = RequestMethod.POST)
//	public Map<String, Object> adminmydonghang( HttpSession session,@RequestParam(required = false, defaultValue = "1")int cPage, @RequestParam(value="gbarr")List<String> gbarr, GoBoard goboard) {
//		System.out.println("/mydonghang/admin ajax 통신 성공");
//		System.out.println("gbno : " + gbarr);
//		System.out.println(gbarr.get(0));
//		
//		
//		int gbno = Integer.parseInt(gbarr.get(0));
//		String gbcategory = gbarr.get(1);
//		
//		
//		User sessionUser = new User();
//		sessionUser.setuNo(5);
//	    //회원정보를 세선에 담기
//	    session.setAttribute("loginInfo", sessionUser);
//		
//	    //세션 부르기
//		sessionUser= (User) session.getAttribute("loginInfo");
//		
//		int uno = sessionUser.getuNo();
//		
//		
//		
//		
//		return null;
//	}
	
	
	//나의 동행(함께가요) 모달
	@ResponseBody
	@RequestMapping(value = "/mydonghang/admin",  method = RequestMethod.POST)
	public Map<String, Object> adminmydonghang( HttpSession session,@RequestParam(required = false, defaultValue = "1")int cPage, @RequestParam(value="gbarr")List<String> gbarr, GoBoard goboard) {
		System.out.println("/mydonghang/admin ajax 통신 성공");
		System.out.println("gbno : " + gbarr);
		System.out.println(gbarr.get(0));
		int gbno = Integer.parseInt(gbarr.get(0));
		String gbcategory = gbarr.get(1);
		
		
		User sessionUser = new User();
		sessionUser.setuNo(2);
	    //회원정보를 세선에 담기
	    session.setAttribute("loginInfo", sessionUser);
		
	    //세션 부르기
		sessionUser= (User) session.getAttribute("loginInfo");
		
		int uno = sessionUser.getuNo();
		
		int cntPerPage = 5;
			
		Map<String, Object> map = fboardlistservice.selectrecruitList(gbcategory, gbno, cPage, cntPerPage);
		System.out.println("ajax로 전송할 : " + map);		
		return map;
	}
		
	
	
	//나의동행관리 수락 처리
	@ResponseBody
	@RequestMapping(value = "/mydonghang/adminrecruit",  method = RequestMethod.POST)
	public int adminRecruit(HttpSession session, @RequestParam(value="agreeChk")List<String> agreeChk) {
		User sessionUser = new User();
		sessionUser.setuNo(2);
	    //회원정보를 세선에 담기
	    session.setAttribute("loginInfo", sessionUser);
		
	    //세션 부르기
		sessionUser= (User) session.getAttribute("loginInfo");
		
		String uno = Integer.toString(sessionUser.getuNo());
		
		
		System.out.println("/mydonghang/admin ajax 통신 성공");
		System.out.println("agreeChk : " + agreeChk);
		
		int result = 0;
		
		int aplyuno = Integer.parseInt(agreeChk.get(0)); // 신청자 uno
		int bano =  Integer.parseInt(agreeChk.get(1)); // apply table 번호
		int cate = Integer.parseInt(agreeChk.get(2)); //0 : 함께 가요  | 1 : 함께 해요
		
		if(uno != null || uno!="") {
			fboardlistservice.acceptApply(aplyuno, bano, cate);				
			result = 1;
		}
		
		return result;
	}
	
	//나의동행관리 거절 처리
	@ResponseBody
	@RequestMapping(value = "/mydonghang/refuserecruit",  method = RequestMethod.POST)
	public int refuseRecruit(HttpSession session, @RequestParam(value="refuseChk")List<String> refuseChk) {
		User sessionUser = new User();
		sessionUser.setuNo(2);
	    //회원정보를 세선에 담기
	    session.setAttribute("loginInfo", sessionUser);
		
	    //세션 부르기
		sessionUser= (User) session.getAttribute("loginInfo");
		
		String uno = Integer.toString(sessionUser.getuNo());
		
		
		System.out.println("/mydonghang/admin ajax 통신 성공");
		System.out.println("agreeChk : " + refuseChk);
		
		int result = 0;
		
		int aplyuno = Integer.parseInt(refuseChk.get(0)); // 신청자 uno
		int bano =  Integer.parseInt(refuseChk.get(1)); // apply table 번호
		int cate = Integer.parseInt(refuseChk.get(2)); //0 : 함께 가요  | 1 : 함께 해요
		
		if(uno != null || uno!="") {
			fboardlistservice.acceptRefuse(aplyuno, bano, cate);				
			result = 1;
		}
		
		return result;
	}

	
	
	//댓글 게시판 JSP 띄우기
	@RequestMapping(value = "/commentlist",  method = RequestMethod.GET)
	public ModelAndView commentlist(@RequestParam(required = false, defaultValue = "1")int cPage, HttpSession session) {
		User sessionUser = new User();
		sessionUser.setuNo(5);
	    //회원정보를 세선에 담기
	    session.setAttribute("loginInfo", sessionUser);
		
	    //세션 부르기
		sessionUser= (User) session.getAttribute("loginInfo");
		
		int uno = sessionUser.getuNo();
		
		ModelAndView mav = new ModelAndView();
		//페이징 
		int cntPerPage = 5;
		Map<String, Object> commandMap = fboardlistservice.selectFcmtList(cPage, cntPerPage, uno);		
		mav.addObject("paging", commandMap.get("paging"));
		mav.addObject("cboardData", commandMap);
		mav.setViewName("mypage/commentlist");	
		
		return mav;
	}
	
	
	//댓글(자유게시판)삭제
	@ResponseBody
	@RequestMapping(value = "/cboardlist/delete",  method = RequestMethod.POST)
	public int deleteCboardlist(HttpSession session, @RequestParam(value="deleteChk")List<String> chArr, FreeComment fcmt) {
//			System.out.println("ajax 통신 성공");
//			System.out.println("chArr : " + chArr);
		
		User sessionUser = new User();
		sessionUser.setuNo(5);
	    //회원정보를 세선에 담기
	    session.setAttribute("loginInfo", sessionUser);
		
	    //세션 부르기
		sessionUser= (User) session.getAttribute("loginInfo");
		
		String uno = Integer.toString(sessionUser.getuNo());
		
		int result = 0;
		int fcno = 0;
		
		if(uno != null || uno!="") {
			for(String i : chArr) {
				fcno = Integer.parseInt(i);
				fcmt.setFcNo(fcno);
				fboardlistservice.deleteFcmtList(fcmt);
			}
			result=1;
		}
		
		return result;
	}
	
	
	//댓글 게시판(후기) JSP 띄우기
	@RequestMapping(value = "/rcommentlist",  method = RequestMethod.GET)
	public ModelAndView rcommentlist(@RequestParam(required = false, defaultValue = "1")int cPage, HttpSession session) {
		User sessionUser = new User();
		sessionUser.setuNo(5);
	    //회원정보를 세선에 담기
	    session.setAttribute("loginInfo", sessionUser);
		
	    //세션 부르기
		sessionUser= (User) session.getAttribute("loginInfo");
		
		int uno = sessionUser.getuNo();
		
		ModelAndView mav = new ModelAndView();
		//페이징 
		int cntPerPage = 5;
		Map<String, Object> commandMap = fboardlistservice.selectRcmtList(cPage, cntPerPage, uno);		
		mav.addObject("paging", commandMap.get("paging"));
		mav.addObject("rcboardData", commandMap);
		mav.setViewName("mypage/rcommentlist");	
		
		return mav;			
	}


	//자유게시판 JSP 띄위기
	@RequestMapping(value = "/fboardlist",  method = RequestMethod.GET)
	public ModelAndView fboardlist(@RequestParam(required = false, defaultValue = "1")int cPage, HttpSession session) {
		
		User sessionUser = new User();
		sessionUser.setuNo(5);
	    //회원정보를 세선에 담기
	    session.setAttribute("loginInfo", sessionUser);
		
	    //세션 부르기
		sessionUser= (User) session.getAttribute("loginInfo");
		
		int uno = sessionUser.getuNo();
		
		ModelAndView mav = new ModelAndView();
		//페이징 
		int cntPerPage = 5;
		Map<String, Object> commandMap = fboardlistservice.selectFboardList(cPage, cntPerPage, uno);		
		mav.addObject("paging", commandMap.get("paging"));
		mav.addObject("fboardData", commandMap);
		mav.setViewName("mypage/fboardlist");	
		
		return mav;
	}

	//자유게시판삭제
	@ResponseBody
	@RequestMapping(value = "/fboardlist/delete",  method = RequestMethod.POST)
	public int deleteFboardlist(HttpSession session, @RequestParam(value="deleteChk")List<String> chArr, FreeBoard fboard) {
//		System.out.println("ajax 통신 성공");
//		System.out.println("chArr : " + chArr);
		
		User sessionUser = new User();
		sessionUser.setuNo(5);
	    //회원정보를 세선에 담기
	    session.setAttribute("loginInfo", sessionUser);
		
	    //세션 부르기
		sessionUser= (User) session.getAttribute("loginInfo");
		
		String uno = Integer.toString(sessionUser.getuNo());
		
		int result = 0;
		int fbno = 0;
		
		if(uno != null || uno!="") {
			for(String i : chArr) {
				fbno = Integer.parseInt(i);
				fboard.setFbNo(fbno);
				fboardlistservice.deleteFboardList(fboard);
			}
			result=1;
		}
		
		return result;
	}
	
	

	//후기게시판 JSP 띄우기
	@RequestMapping(value = "/rboardlist",  method = RequestMethod.GET)
	public ModelAndView rboardlist(@RequestParam(required = false, defaultValue = "1")int cPage, HttpSession session) {
		User sessionUser = new User();
		sessionUser.setuNo(5);
	    //회원정보를 세선에 담기
	    session.setAttribute("loginInfo", sessionUser);
		
	    //세션 부르기
		sessionUser= (User) session.getAttribute("loginInfo");
		
		int uno = sessionUser.getuNo();
		
		ModelAndView mav = new ModelAndView();
		//페이징 
		int cntPerPage = 5;
		
		Map<String, Object> commandMap = fboardlistservice.selectRboardList(cPage, cntPerPage, uno);		
		mav.addObject("paging", commandMap.get("paging"));
		mav.addObject("rboardData", commandMap);
		mav.setViewName("mypage/rboardlist");	
		
		return mav;
					
	}
	
	//후기게시판삭제
	@ResponseBody
	@RequestMapping(value = "/rboardlist/delete",  method = RequestMethod.POST)
	public int deleteRboardlist(HttpSession session, @RequestParam(value="deleteChk")List<String> chArr, ReviewBoard rboard) {
		System.out.println("ajax 통신 성공");
		System.out.println("chArr : " + chArr);
		
		User sessionUser = new User();
		sessionUser.setuNo(5);
	    //회원정보를 세선에 담기
	    session.setAttribute("loginInfo", sessionUser);
		
	    //세션 부르기
		sessionUser= (User) session.getAttribute("loginInfo");
		
		String uno = Integer.toString(sessionUser.getuNo());
		
		int result = 0;
		int rbno = 0;
		
		if(uno != null || uno!="") {
			for(String i : chArr) {
				rbno = Integer.parseInt(i);
				rboard.setRbNo(rbno);
				fboardlistservice.deleteRboardList(rboard);
			}
			result=1;
		}
		
		return result;
	}
	
	
	
	//동행복권 결제내역 JSP 띄우기
	@RequestMapping(value = "/paymentlist",  method = RequestMethod.GET)
	public ModelAndView paymentlist(@RequestParam(required = false, defaultValue = "1")int cPage, HttpSession session) {
		User sessionUser = new User();
		sessionUser.setuNo(5);
	    //회원정보를 세선에 담기
	    session.setAttribute("loginInfo", sessionUser);
		
	    //세션 부르기
		sessionUser= (User) session.getAttribute("loginInfo");
		
		int uno = sessionUser.getuNo();
		
		ModelAndView mav = new ModelAndView();
		//페이징 
		int cntPerPage = 5;
		
		Map<String, Object> commandMap = fboardlistservice.paymentList(cPage, cntPerPage, uno);		
		mav.addObject("paging", commandMap.get("paging"));
		mav.addObject("paymentData", commandMap);
		mav.setViewName("mypage/paymentlist");	

		return mav;		
	}
	//결제내역 삭제
	@ResponseBody
	@RequestMapping(value = "/paymentlist/delete",  method = RequestMethod.POST)
	public int deletepaymentlist(HttpSession session, @RequestParam(value="deleteChk")List<String> chArr, Order order) {
//		System.out.println("ajax 통신 성공");
//		System.out.println("chArr : " + chArr);
		
		User sessionUser = new User();
		sessionUser.setuNo(5);
	    //회원정보를 세선에 담기
	    session.setAttribute("loginInfo", sessionUser);
		
	    //세션 부르기
		sessionUser= (User) session.getAttribute("loginInfo");
		
		String uno = Integer.toString(sessionUser.getuNo());
		
		int result = 0;
		int pono = 0;
		
		if(uno != null || uno!="") {
			for(String i : chArr) {
				pono = Integer.parseInt(i);
				order.setpONo(pono);
				fboardlistservice.deletePmList(order);
			}
			result=1;
//			System.out.println("order : "+ order);
		}
		
		return result;
	}

	//동행복권 사용내역 JSP 띄우기
	@RequestMapping(value = "/usingList",  method = RequestMethod.GET)
	public void usingList() {
						
	}	
	
	
	
	
	
}
