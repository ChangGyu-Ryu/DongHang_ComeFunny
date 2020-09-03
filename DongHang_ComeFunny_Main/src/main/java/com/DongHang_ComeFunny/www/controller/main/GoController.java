package com.DongHang_ComeFunny.www.controller.main;

import java.util.ArrayList;
import java.util.HashMap;
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
import org.springframework.web.servlet.ModelAndView;

import com.DongHang_ComeFunny.www.model.service.main.GoService;
import com.DongHang_ComeFunny.www.model.vo.GoBoard;
import com.DongHang_ComeFunny.www.model.vo.GoCheck;
import com.DongHang_ComeFunny.www.model.vo.User;

@Controller
public class GoController {
	
	@Autowired GoService goService;
	
	//기본 화면 띄우기 GET
//	@RequestMapping(value="/go", method=RequestMethod.GET)
//	public String goboard() {
//		System.out.println("[GET] /go");
//		return "/go/go";
//	}
	
	@RequestMapping(value="/go/goform", method=RequestMethod.GET)
	public String gowrite() {
		return "/go/goForm";
	}
	
	@RequestMapping(value="/go/goFilter", method=RequestMethod.GET)
	public void gofilter() {
	}
	
	//-------------------------상세보기 ----------------------------------
	
	//함께가요 상세
	   @RequestMapping(value="/go/goDetail", method=RequestMethod.GET)
	   public void goDetail(int gbNo, Model model, HttpSession session) {
	      
	      //로그인 구현 전 
	      //임의로 객체에 회원정보 담기
	      User sessionUser = new User();
	      sessionUser.setuNo(2);

	      //회원정보를 세선에 담기
	      session.setAttribute("login", sessionUser);

	      int uNo = ((User)(session.getAttribute("login"))).getuNo();
	      
	      //함께가요 상세정보들
	      Map<String, Object> goDetailInfo = goService.selectGoDetail(gbNo);
	      
	      //함께가요 찜목록 클릭 여부
	      int goLikeStatus = goService.selectGoLikeStatus(gbNo, uNo);
	      
	      model.addAttribute("goDetailInfo", goDetailInfo);
	      model.addAttribute("goLikeStatus", goLikeStatus);
	      
	   }
	   
	   //함께가요 동행 신청
	   @RequestMapping(value="/go/goApply", method=RequestMethod.POST)
	   @ResponseBody
	   public Map<String, Object> goApply(int gbNo, Model model, HttpSession session) {
	      
	      //로그인 구현 전 
	      //임의로 객체에 회원정보 담기
	      User sessionUser = new User();
	      sessionUser.setuNo(24);

	      //회원정보를 세선에 담기
	      session.setAttribute("login", sessionUser);
	      
	      int uNo = ((User)(session.getAttribute("login"))).getuNo();
	      

	      //함께가요 신청
	      int res = goService.insertGoDhApply(gbNo, uNo);
	      
	      Map<String, Object> newGoApply = goService.selectGoNewApply(gbNo, uNo);
	      
	      if(res > 0) {
	         return newGoApply;
	      } else {
	         return null;
	      }

	      
	   }
	   
	   //동행 요청 수락
	   @RequestMapping(value="/go/goDhOk", method=RequestMethod.POST)
	   @ResponseBody
	   public String goDhOk(int gbNo, int gaUNo, HttpSession session) {
	      
	      System.out.println("gbNo = " + gbNo);
	      System.out.println("gaUNo = " + gaUNo);

	      //동행 요청 수락
	      int res = goService.updateGoApplyOkStatus(gbNo, gaUNo);

	      if(res > 0) {
	         return ".goDhApplyResult";
	      } else {
	         return "fail";
	      }
	      
	   }
	   
	   //동행 요청 거절
	   @RequestMapping(value="/go/goDhNo", method=RequestMethod.POST)
	   @ResponseBody
	   public String goDhNo(int gbNo, int gaUNo, HttpSession session) {
	      

	      //동행 요청 거절
	      int res = goService.updateGoApplyNoStatus(gbNo, gaUNo);

	      if(res > 0) {
	         return ".goDhApplyResult";
	      } else {
	         return "fail";
	      }
	      
	   }
	   
	   //함께가요 찜목록 추가
	   @RequestMapping(value="/go/goInsertLike", method=RequestMethod.POST)
	   @ResponseBody
	   public int goInsertLike(int gbNo, int uNo, HttpSession session) {
	      

	      //함께가요 찜목록 추가
	      int res = goService.insertGoLike(gbNo, uNo);

	      if(res > 0) {
	    	//찜 수 증가
	          goService.GBlikeUpCnt(gbNo);
	         return 1;
	      } else {
	         return 0;
	      }
	      
	   }
	   
	   //함께가요 찜목록 삭제
	   @RequestMapping(value="/go/goDeleteLike", method=RequestMethod.POST)
	   @ResponseBody
	   public int goDeleteLike(int gbNo, int uNo, HttpSession session) {
	      

	      //함께가요 찜목록 삭제
	      int res = goService.DeleteGoLike(gbNo, uNo);

	      if(res > 0) {
	    	//함께가요 찜 수 감소 
	          goService.GBlikeDownCnt(gbNo); 
	         return 1;
	      } else {
	         return 0;
	      }
	      
	   }
	   
	   
	   //함께가요 삭제
	   @RequestMapping(value = "/go/goDelete", method = RequestMethod.GET)
	   public String goDelete(int gbNo, Model model, HttpSession session) {

	      //함께가요 삭제 -> gbisdel = 1 로 update
	      int res = goService.deleteGoboard(gbNo);

	      if(res > 0) {
	         model.addAttribute("alertMsg", "해당 게시글이 삭제되었습니다.");
	         model.addAttribute("url", "/go");
	      } else {
	         model.addAttribute("alertMsg", "해당 게시글이 삭제 되지 않았습니다.");
	         model.addAttribute("url", "/go");
	      }

	      return "common/result";

	   }
	
	   //------------------- 폼입력 -------------------------
	   
	   
	//폼 입력하기 (파일첨부 제외)
		@RequestMapping(value="/go/gowrite", method=RequestMethod.POST)
		public ModelAndView insertGo(GoBoard goBoard, GoCheck goCheck, HttpSession session) {
			
			//임의로 세션값 넣기
			User sessionUser = new User(); //임의로 세션값 생성
//			sessionUser.setuNo(4);
//			sessionUser.setUserId("test2");
			
//			session.setAttribute("login", sessionUser); //세션에 세션값 넣기
			
			ModelAndView mav = new ModelAndView();
			sessionUser = (User)session.getAttribute("login"); //세션 부르기
			
			if(sessionUser != null) {
				goBoard.setGbUNo(sessionUser.getuNo());
			} else {
				mav.addObject("alertMsg", "로그인 후에 사용해주시길 바랍니다.");
				mav.addObject("url", "/login"); //로그인화면으로
				mav.setViewName("common/result");
			}
			
			goService.insertGoForm(goBoard, goCheck);
			
			mav.addObject("alertMsg", "등록 완료!");
			mav.addObject("url","/go");
			mav.setViewName("common/result");
			
			
			return mav;
			
		}
	//기본 최신순 정렬된 리스트 전체 띄우기
		@RequestMapping(value="/go", method=RequestMethod.GET)
		public ModelAndView goList(String searchText, Map<String, Object> commandMap) {
			
			ModelAndView mav = new ModelAndView();
			
			Map<String,Object> search = new HashMap<>();
			search.put("searchText", searchText);
			
			//검색 전 리스트 출력
//			List<Map<String,Object>> list = goService.selectGoList(commandMap);
			Map<String, Object> list = goService.selectSearchList(search, commandMap);
			
			System.out.println(list);
			mav.addObject("list", list);
			mav.addObject("searchText", searchText );
			mav.setViewName("go/go");
			
			return mav;
			
		}
	
		
	//페이지내에서 검색하기 (기본 리다이렉트)
		@RequestMapping(value="/go/search", method=RequestMethod.POST)
		public ModelAndView goListSearch(String searchText, Map<String, Object> commandMap) {
			
			ModelAndView mav = new ModelAndView();

			Map<String,Object> search = new HashMap<>();
			search.put("searchText", searchText); //검색키워드 저장

			Map<String,Object> list = goService.selectSearchList(search, commandMap);

			mav.addObject("list", list);
			mav.addObject("searchText", searchText );
			mav.setViewName("redirect:/go"); 

			return mav;
		}

		
		//ajax로 필터링하기
		@RequestMapping(value="/go/filter", method=RequestMethod.GET)
		@ResponseBody
		public ModelAndView goFilter(
				@RequestParam String age, 
				@RequestParam String gender, 
				@RequestParam String theme,
				@RequestParam String area, 
				@RequestParam String state
//	            , String searchText, Map<String, Object> commandMap
				) {
			//필요한 로직 처리
			System.out.println("[controller]");
			System.out.println("[age] " + age.length() + " [gender] " + gender.length() + " [theme] " + theme.length()
			+ " [area] " + area.length() + " [state] " + state.length() );
//	         System.out.println("[searchText] " + searchText);

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

			
			Map<String,Object> list = goService.selectFilterList(filter);
//	         System.out.println(list);

			mav.addObject("list", list);
//	         mav.addObject("searchText", searchText);
			mav.addObject("filter", filter);

			mav.setViewName("/go/goFilter"); 

			System.out.println("****************ajax보자*************");
			System.out.println(mav);
			return mav;
		}

		
		//수정 기본 값 가지고오기
		@RequestMapping(value="/go/modify", method=RequestMethod.GET)
		public ModelAndView noticeModify(int gbNo) {
			System.out.println("[Controller] modify");
			System.out.println(gbNo);
			
			ModelAndView mav = new ModelAndView();
			Map<String,Object> goboard = goService.selectGoDetail(gbNo);

			
			mav.addObject("goboard", goboard);
			mav.setViewName("go/goModify");
			return mav;
		}

		//글 수정하기
		@RequestMapping(value="/go/updatemodify", method=RequestMethod.POST)
		public ModelAndView noticeModifyImpl(
				GoBoard goBoard, HttpSession session) {
			System.out.println("[Controller] /updatemodify");
			ModelAndView mav = new ModelAndView();

//			User sessionUser = new User(); //임의로 세션값 생성
//			sessionUser.setuNo(4);
//			sessionUser.setUserId("test2");
//
//			session.setAttribute("login", sessionUser); //세션에 세션값 넣기
//			User sessionUser = (User)session.getAttribute("login"); //세션 부르기
//			sessionUser = (User)session.getAttribute("login"); //세션 부르기

//			int res = 0;
//			게시글 작성자가 수정요청을 한 것이 맞는 지 확인
//			if(sessionUser.getuNo() == goBoard.getGbUNo()) {
//				res = goService.updateGoboard(goBoard);
//			}
			
			int goboard = goService.updateGoboard(goBoard);

			mav.addObject("goBoard", goBoard);
			mav.addObject("alertMsg", "수정완료!");
			mav.addObject("url","/go"); 
			mav.setViewName("common/result");

			return mav;
		}



}
