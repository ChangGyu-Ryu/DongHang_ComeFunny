package com.DongHang_ComeFunny.www.controller.admin;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.DongHang_ComeFunny.www.model.service.admin.AdminLoginService;
import com.DongHang_ComeFunny.www.model.vo.Admin;

@Controller
@RequestMapping("/admin")
public class AdminLoginController {
	
	@Autowired
	AdminLoginService adminLoginService;
	
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/admin/login");
		return mav;
	}
	
	@RequestMapping(value="/loginimple", method=RequestMethod.POST)
	public String loginImpl(
			@RequestParam Admin loginInfo
			, HttpSession session
			, Model model
			) {

		Admin res = adminLoginService.loginAdmin(loginInfo);
		//로그인에 성공한다면
		if(res != null) {
			session.setAttribute("loginInfo", res);
		} else {
			model.addAttribute("alertMsg", "해당 담당자에게 문의해주세요");
			model.addAttribute("url", "login");
		}

		return "/admin/main";

	}

}
