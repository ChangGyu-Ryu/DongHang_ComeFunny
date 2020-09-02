package com.DongHang_ComeFunny.www.board.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.DongHang_ComeFunny.www.board.model.service.FreeBoardService;
import com.DongHang_ComeFunny.www.board.model.vo.FreeBoard;
import com.DongHang_ComeFunny.www.user.model.vo.User;

import common.exception.FileException;

@Controller
@RequestMapping("/board")
public class FreeBoardController {
	
	@Autowired
	private FreeBoardService freeBoardService;
	
	@RequestMapping(value = "/freewrite", method = RequestMethod.GET)
	public ModelAndView freeWrite() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/board/freewrite");
		
		return mav;
	}
	
	@SuppressWarnings("unused")
	@RequestMapping(value="freeUploadImpl", method = RequestMethod.POST)
	public ModelAndView freeUpload(
			FreeBoard free
			, @RequestParam List<MultipartFile> files
			, HttpSession session
			, HttpServletRequest req
			) throws FileException {
		System.out.println("에디터 내용 : " + req.getParameter("fbcontent"));
		
		ModelAndView mav = new ModelAndView();
		String root = session.getServletContext().getRealPath("/");
		
		User sessionUser = (User)session.getAttribute("logInInfo");
		System.out.println("[세션정보]" + sessionUser);
		if(sessionUser != null) {
			free.setFbuno(sessionUser.getUno());
			freeBoardService.insertFree(free, files, root);
			mav.setViewName("redirect: /board/freelist");
		} else {
			mav.addObject("alertMsg", "로그인 후에 이용해주시기 바랍니다.");
			mav.addObject("url", "../user/login");
			mav.setViewName("/common/result");
		}
		
		
		System.out.println(free);
		
		return mav;
	}
	
	@RequestMapping(value = "/freelist", method = RequestMethod.GET)
	public ModelAndView freeList(
			@RequestParam(required=false, defaultValue="1")int cPage) {
		ModelAndView mav = new ModelAndView();
		int cntPerPage = 10;
		
		Map<String, Object> commandMap = freeBoardService.selectFreeList(cPage, cntPerPage);
		System.out.println("[controller] flist : " + commandMap);
		
		mav.addObject("paging", commandMap.get("paging"));
		mav.addObject("freeData", commandMap);
		mav.setViewName("/board/freelist");
		
		return mav;
	}
	
	
	@RequestMapping(value = "/freeview", method = RequestMethod.GET)
	public ModelAndView freeView(int fbno) {
		ModelAndView mav = new ModelAndView();
		Map<String, Object> free = freeBoardService.selectFreeView(fbno);
		System.out.println("[ controller ] fview Map : " + free);
		if(free != null) {
			mav.addObject("fview", free);
			mav.setViewName("/board/freeview");
		} else {
			mav.addObject("alertMsg", "해당 게시물이 존재하지 않습니다.");
			mav.addObject("url", "freelist");
			mav.setViewName("common/result");
		}
		
		return mav;
	}
	
	@RequestMapping(value = "/reviewlist", method = RequestMethod.GET)
	public void reviewList() {}
	
	@RequestMapping(value = "/reviewwrite", method = RequestMethod.GET)
	public void reviewWrite() {}
	
	@RequestMapping(value = "/reviewview", method = RequestMethod.GET)
	public void reviewView() {}
	
	

}
