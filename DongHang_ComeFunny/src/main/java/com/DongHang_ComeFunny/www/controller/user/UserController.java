package com.DongHang_ComeFunny.www.controller.user;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.DongHang_ComeFunny.www.model.service.user.UserService;
import com.DongHang_ComeFunny.www.model.vo.User;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	public UserService userService;
	
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/user/login");
		return mav;
	}
	
	@RequestMapping(value="/loginimple", method=RequestMethod.POST)
	public String loginImpl(
			@RequestParam Map<String, Object> commandMap
			, HttpSession session
			, Model model
			) {
		
		User res = userService.selectMember(commandMap);
		//로그인에 성공한다면
		if(res != null) {
			session.setAttribute("logInInfo", res);
			model.addAttribute("alertMsg", "로그인 성공~!");
			model.addAttribute("url", "login");
		} else {
			model.addAttribute("alertMsg", "로그인 실패~!");
			model.addAttribute("url", "join");
		}
		
		return "common/result";
		
	}
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public ModelAndView join() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/user/join");
		return mav;
	} 
	
	@RequestMapping(value="/joinimple", method=RequestMethod.POST)
	public String joinimpl(@ModelAttribute User user, Model model, HttpServletRequest request) {
		String root = request.getContextPath();
		String birthYear = request.getParameter("ubirthyy");
		String birthMonth = request.getParameter("ubirthmm");
		String birthDay = request.getParameter("ubirthdd");
		user.setuBirth(birthYear+birthMonth+birthDay);
		
		int res = userService.insertUser(user);
		if(res > 0) {
			//addAttribute : ModelAndView의 addObject와 같다
			model.addAttribute("alertMsg", "회원가입에 성공했습니다.");
			model.addAttribute("url", root+"/user/login");
		
		} else {
			model.addAttribute("alertMsg", "회원가입에 실패했습니다.");
			model.addAttribute("url", root+"/user/join");
			
		}
		
		return "common/result";
		
		
	}
	
	
	
}