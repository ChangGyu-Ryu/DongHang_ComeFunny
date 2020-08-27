package com.DongHang_ComeFunny.www.controller.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String main() {
		System.out.println("[GET] /");
		return "/main/main";
	}
	
}
