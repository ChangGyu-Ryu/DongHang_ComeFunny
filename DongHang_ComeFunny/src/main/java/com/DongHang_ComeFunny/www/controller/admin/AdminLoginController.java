package com.DongHang_ComeFunny.www.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.DongHang_ComeFunny.www.model.service.admin.AdminLoginService;

@Controller
@RequestMapping("/admin/login")
public class AdminLoginController {
	
	@Autowired
	AdminLoginService adminLoginServce;

}
