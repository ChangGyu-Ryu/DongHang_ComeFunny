package com.DongHang_ComeFunny.www.controller.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {
	
	@RequestMapping("/board/freelist")
	public void freeList() {}
	
	@RequestMapping("/board/freewrite")
	public void freeWrite() {}
	
	@RequestMapping("/board/freeview")
	public void freeView() {}
	
	@RequestMapping("/board/reviewlist")
	public void reviewList() {}
	
	@RequestMapping("/board/reviewwrite")
	public void reviewWrite() {}
	
	@RequestMapping("/board/reviewview")
	public void reviewView() {}
	
	

}
