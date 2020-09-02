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

		
	//폼화면 띄우기
	@RequestMapping(value="/do/doform", method=RequestMethod.GET)
	public String dowrite() {
		return "/do/doForm";
	}
	
	//폼 입력하기 (파일첨부까지)
	@RequestMapping(value="/do/dowrite", method=RequestMethod.POST)
	public ModelAndView insertGo(
			DoBoard doBoard
			, DoCheck doCheck
			, @RequestParam List<MultipartFile> files
			, HttpSession session
			) {
		
		ModelAndView mav = new ModelAndView();
		//임의로 세션값 넣기
		// 2. 세션에 저장된 로그인 정보를 'User' VO에 저장
		User sessionUser = (User)session.getAttribute("logInInfo");
		String root = session.getServletContext().getRealPath("/");
		
		if(sessionUser != null) { //존재하면
			doBoard.setDbUNo(sessionUser.getuNo());
			
		} else { //존재하지않으면
			mav.addObject("alertMsg", "로그인을 해주세요.");
			mav.addObject("url", "/login"); //로그인 화면으로
			mav.setViewName("common/result");
		}
		
		doService.insertDoForm(doBoard, doCheck, files, root);
		
		mav.addObject("alertMsg", "등록 완료!");
		mav.addObject("url","/do");
		mav.setViewName("common/result");
		
		return mav;
		
	}
	
	//상세보기 화면 띄우기
	@RequestMapping(value="/do/dodetail", method=RequestMethod.GET)
	public String dodetail() {
		return "/do/doDetail";
	}
	

}
