package com.DongHang_ComeFunny.www.controller.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DoController {
	
	//화면띄우기
	@RequestMapping(value="/do", method=RequestMethod.GET)
	public String doboard() {
		System.out.println("[GET] /do");
		return "/do/do";
	}
	
	@RequestMapping(value="/do/doform", method=RequestMethod.GET)
	public String dowrite() {
		return "/do/doForm";
	}
	
	@RequestMapping(value="/do/dodetail", method=RequestMethod.GET)
	public String dodetail() {
		return "/do/doDetail";
	}
	

}
