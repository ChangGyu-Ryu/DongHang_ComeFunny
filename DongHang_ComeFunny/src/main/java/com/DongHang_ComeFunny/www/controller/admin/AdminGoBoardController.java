package com.DongHang_ComeFunny.www.controller.admin;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.DongHang_ComeFunny.www.model.service.admin.AdminGoBoardService;

@Controller
@RequestMapping("/admin/boards/goBoard")
public class AdminGoBoardController {
	
	@Autowired
	AdminGoBoardService adminGoBoardService;
	
	@RequestMapping("/list")
	public ModelAndView viewDoBoardList (	String searchKinds,
											String searchText,
											@RequestParam(required = false, defaultValue = "1")int cPage) {
		
		ModelAndView mav = new ModelAndView();
		int cntPerPage = 10;
		
		Map<String,Object> searchGoBoard = new HashMap<>();
		
		searchGoBoard.put("searchKinds", searchKinds);
		searchGoBoard.put("searchText", searchText);
		Map<String,Object> goBoardList = adminGoBoardService.viewGoBoardList(cPage, cntPerPage, searchGoBoard);

		mav.addObject("paging",goBoardList.get("paging"));
		mav.addObject("goBoardData", goBoardList);
		mav.addObject("searchKinds", searchKinds);
		mav.addObject("searchText", searchText);
		mav.setViewName("admin/boards/goBoard/list");
		return mav;
	}
	
	// delete 버튼 추가 예정
		@RequestMapping("/delete")
		public ModelAndView deleteGoBoard(String[] gbNo) {
			
			ModelAndView mav = new ModelAndView();
					
					if(gbNo != null) {
						adminGoBoardService.deleteGoBoard(gbNo);
						mav.setViewName("redirect:/admin/boards/goBoard/list");
						return mav; 
					}else {
						mav.setViewName("redirect:/admin/boards/goBoard/list");
						return mav;
					}
		}

}
