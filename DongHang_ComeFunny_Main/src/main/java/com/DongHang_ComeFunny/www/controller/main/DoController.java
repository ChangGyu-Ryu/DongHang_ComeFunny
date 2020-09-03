package com.DongHang_ComeFunny.www.controller.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.DongHang_ComeFunny.www.model.service.main.DoService;
import com.DongHang_ComeFunny.www.model.vo.DoBoard;
import com.DongHang_ComeFunny.www.model.vo.DoCheck;
import com.DongHang_ComeFunny.www.model.vo.GoBoard;
import com.DongHang_ComeFunny.www.model.vo.User;

@Controller
public class DoController {
	
	@Autowired DoService doService;
	
	//필터화면띄우기
	@RequestMapping(value="/do/doFilter", method=RequestMethod.GET)
	public void doFilter() {
	}
	
	//기본메인리스트
	@RequestMapping(value="/do", method=RequestMethod.GET)
	public ModelAndView doList(Map<String, Object> commandMap, String searchText) {
		System.out.println("[Controller] /do");
		
		ModelAndView mav = new ModelAndView();
		
		Map<String,Object> search = new HashMap<>();
		search.put("searchText", searchText);
		
		//검색전 리스트 출력
		Map<String, Object> list = doService.selectsearchList(search, commandMap);
		
		mav.addObject("list", list);
		mav.addObject("searchText", searchText);
		mav.setViewName("/do/do");
		
		System.out.println("[list]" + mav);
		return mav;
	}
	
	//기본 검색 리스트
	@RequestMapping(value="/do/search", method=RequestMethod.POST)
	public ModelAndView doSearch(Map<String, Object> commandMap, String searchText) {
		System.out.println("[Controller] /do/search");
		
		ModelAndView mav = new ModelAndView();
		
		Map<String,Object> search = new HashMap<>();
		search.put("searchText", searchText);
		
		//검색전 리스트 출력
		Map<String, Object> list = doService.selectsearchList(search, commandMap);
		
		mav.addObject("list", list);
		mav.addObject("searchText", searchText);
		mav.setViewName("redirect:/do");
		
		return mav;
	}
	
	//ajax 리스트
		@RequestMapping(value="/do/filter", method=RequestMethod.GET)
		public ModelAndView doFilterList(
				@RequestParam String age, 
				@RequestParam String gender, 
				@RequestParam String theme,
				@RequestParam String area, 
				@RequestParam String state
//				,Map<String, Object> commandMap, String searchText
				) {
			System.out.println("[Controller] /do/filter");
			
			//ajax매개변수 확인
			System.out.println("[age] " + age.length() + " [gender] " + gender.length() + " [theme] " + theme.length()
			+ " [area] " + area.length() + " [state] " + state.length() );
			
			ModelAndView mav = new ModelAndView();
			
			List<String> agelist = new ArrayList<String>();
			List<String> genderlist = new ArrayList<String>();
			List<String> themelist = new ArrayList<String>();
			List<String> arealist = new ArrayList<String>();
			List<String> statelist = new ArrayList<String>();
			
			Map<String, Object> filter = new HashMap<>(); //필터 Map 생성
			
			String[] ageArray = {};
			String[] genderArray = {};
			String[] themeArray = {};
			String[] areaArray = {};
			String[] stateArray = {};
			
			//받아온 값 쪼개서 각각 넣어주기
			if(age.length() > 0) { //넘어온 값이 공백이 아니면 
				ageArray = age.split("-");  //split 쪼개서 리스트에 넣고 
				for(String str : ageArray) { //반복 돌면서 넣어주기
					System.out.println("[str]"+str);
					agelist.add(str); 
				}
			}
			
			filter.put("age", agelist); //filter맵에 입력
			
			if(gender.length() > 0) {
				genderArray = gender.split("-");
				for(String str : genderArray) {
					genderlist.add(str);
				}
			}

			filter.put("gender", genderlist);

			if(theme.length() > 0) {
				themeArray = theme.split("-");
				for(String str : themeArray) {
					themelist.add(str);
				}
			}

			filter.put("theme", themelist);

			if(area.length() > 0) {
				areaArray = area.split("-");
				for(String str : areaArray) {
					arealist.add(str);
				}
			}

			filter.put("area", arealist);

			if(state.length() > 0) {
				stateArray = state.split("-");
				for(String str : stateArray) {
					statelist.add(str);
				}
			}

			filter.put("state", statelist);
			
//			Map<String,Object> search = new HashMap<>();
//			search.put("searchText", searchText);
			
			//검색전 리스트 출력
			Map<String, Object> list = doService.selectFilterList(filter);
			
			mav.addObject("list", list);
//			mav.addObject("searchText", searchText);
			mav.addObject("filter", filter);
			
			mav.setViewName("/do/doFilter");
			
			System.out.println("[list]" + mav);
			return mav;
		}

		
	//------------------------------작성하기
	//폼화면 띄우기 (합치면 아래꺼로 바꾸기)
	@RequestMapping(value="/do/doform", method=RequestMethod.GET)
	public String dowrite() {
		return "/do/doForm";
	}
	
	//세션처리되는 폼화면 띄우기
//	@RequestMapping(value="/do/doform", method=RequestMethod.GET)
//	public ModelAndView dowrite(DoBoard doBoard, HttpSession session) {
//		
//		ModelAndView mav = new ModelAndView();
//		User sessionUser = (User)session.getAttribute("logInInfo");
//		
//		if(sessionUser != null) {
//            doBoard.setDbUNo(sessionUser.getuNo());
//            mav.setViewName("/do/doForm");
//		} else {
//   		 mav.addObject("alertMsg", "로그인 후에 사용해주시길 바랍니다.");
//            mav.addObject("url", "/user/login"); //로그인화면으로
//            mav.setViewName("common/result");
//   	 	}
//		
//		return mav;
//	}
	
	//폼 입력하기 (파일첨부까지)
	@RequestMapping(value="/do/dowrite", method=RequestMethod.POST)
	public ModelAndView insert(
			DoBoard doBoard
			, DoCheck doCheck
			, @RequestParam List<MultipartFile> files
			, HttpSession session
			) {
		
		
		//임의로 세션값 넣기 (로그인 합치면 --주석처리 or 지우기) ----------
		User sessionUser = new User(); //임의로 세션값 생성
		sessionUser.setuNo(26);
		
		session.setAttribute("login", sessionUser); //세션에 세션값 넣기
		
		sessionUser = (User)session.getAttribute("login");  //세셔ㄴ부르기
		//----------------------------------------------
		
		ModelAndView mav = new ModelAndView();
		
		//로그인 합치면 이거 주석풀기
//		User sessionUser = (User)session.getAttribute("loginInfo"); 
		String root = session.getServletContext().getRealPath("/");
		
		doBoard.setDbUNo(sessionUser.getuNo());
		doService.insertDoForm(doBoard, doCheck, files, root);
		
		mav.addObject("alertMsg", "등록 완료!");
		mav.addObject("url","/do");
		mav.setViewName("common/result");
		
		return mav;
		
	}
	
	
	//---------------------------수정하기
	
	//수정 전 정보 가지고오기
	@RequestMapping(value="/do/modify", method=RequestMethod.GET)
	public ModelAndView domodify(int dbNo, HttpSession session) {
		System.out.println("[Controller : modify]");
		
		ModelAndView mav = new ModelAndView();
		Map<String, Object> doboard = doService.selectdolist(dbNo);
		
		mav.addObject("doboard", doboard);
		mav.setViewName("do/doModify");
		
		System.out.println("[mav]" + mav);
		return mav;
	}
	
	//글 수정하기
	@RequestMapping(value="/do/modify", method=RequestMethod.POST)
	public ModelAndView domodifyimpl(
			DoBoard doboard, HttpSession session,
			@RequestParam List<MultipartFile> files) {

		String root = session.getServletContext().getRealPath("/");
		
		//임의로 세션값 넣기 합치면 주석 처리 혹은 삭제 ---------------------------
		User sessionUser = new User(); //임의로 세션값 생성
		sessionUser.setuNo(26);
				
		session.setAttribute("logIn", sessionUser); //세션에 세션값 넣기
		
		ModelAndView mav = new ModelAndView();
		sessionUser = (User)session.getAttribute("logIn"); //세션 부르기
		
		doService.updateDoboard(doboard, files, root); //합치면 처리되면 주석
		//-------------------------------------------------------
		
		//합치면 주석 해제
//		User sessionUser = (User)session.getAttribute("logInInfo");
//		doboard.setDbUNo(sessionUser.getuNo());
//		
//		doService.updateDoboard(doboard, files, root);

		mav.addObject("doBoard", doboard);
		mav.addObject("alertMsg", "수정완료!");
		mav.addObject("url","/do");
		mav.setViewName("common/result");

		return mav;
	}

	//이미지삭제하기
	@RequestMapping(value="/deleteimg", method=RequestMethod.POST)
	public String deletedoimg(int diNo) {
		System.out.println("[Controller : delete]");

		int res = doService.deletedoimg(diNo);
		if(res > 0) {
			return "";
		} else {
			return "fail";
		}
	}
	
	
	//---------------------------상세보기
	@RequestMapping(value="/do/dodetail", method=RequestMethod.GET)
	public String dodetail() {
		return "/do/doDetail";
	}
	


}
