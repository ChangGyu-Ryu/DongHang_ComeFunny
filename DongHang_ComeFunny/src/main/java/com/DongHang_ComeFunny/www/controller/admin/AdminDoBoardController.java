package com.DongHang_ComeFunny.www.controller.admin;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.DongHang_ComeFunny.www.model.service.admin.AdminDoBoardService;

@Controller
@RequestMapping("/admin/boards/doBoard")
public class AdminDoBoardController {
	
	@Autowired
	AdminDoBoardService adminDoBoardService;
	
	@RequestMapping("/list")
	public ModelAndView viewDoBoardList (	String searchKinds,
											String searchText,
											@RequestParam(required = false, defaultValue = "1")int cPage) {
		
		ModelAndView mav = new ModelAndView();
		int cntPerPage = 10;
		
		Map<String,Object> searchDoBoard = new HashMap<>();
		
		searchDoBoard.put("searchKinds", searchKinds);
		searchDoBoard.put("searchText", searchText);
		Map<String,Object> doBoardList = adminDoBoardService.viewDoBoardList(cPage, cntPerPage, searchDoBoard);

		mav.addObject("paging",doBoardList.get("paging"));
		mav.addObject("doBoardData", doBoardList);
		mav.addObject("searchKinds", searchKinds);
		mav.addObject("searchText", searchText);
		mav.setViewName("admin/boards/doBoard/list");
		return mav;
	}
	
		@RequestMapping("/delete")
		public ModelAndView deleteDoBoard(String[] dbNo) {
			
			ModelAndView mav = new ModelAndView();
					
					if(dbNo != null) {
						adminDoBoardService.deleteDoBoard(dbNo);
						mav.setViewName("redirect:/admin/boards/doBoard/list");
						return mav; 
					}else {
						mav.setViewName("redirect:/admin/boards/doBoard/list");
						return mav;
					}
		}
		
		
		
	
	
	
	
}
