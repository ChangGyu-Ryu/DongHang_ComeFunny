package com.DongHang_ComeFunny.www.controller.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	@RequestMapping(value = "/login/login", method=RequestMethod.GET)
	public void login() {}
	
	@RequestMapping(value = "/login/join", method=RequestMethod.GET)
	public void join() {}
	
}
