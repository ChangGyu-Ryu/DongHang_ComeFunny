package com.DongHang_ComeFunny.www.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BoardController {
	
	@RequestMapping(value = "/board/freelist", method=RequestMethod.GET)
	public void freeList() {}
	
	@RequestMapping(value = "/board/freewrite", method=RequestMethod.GET)
	public void freeWrite() {}
	
	@RequestMapping(value = "/board/freeview", method=RequestMethod.GET)
	public void freeView() {}
	
	@RequestMapping(value = "/board/reviewlist", method=RequestMethod.GET)
	public void reviewList() {}
	
	@RequestMapping(value = "/board/reviewwrite", method=RequestMethod.GET)
	public void reviewWrite() {}
	
	@RequestMapping(value = "/board/reviewview", method=RequestMethod.GET)
	public void reviewView() {}
	
}
