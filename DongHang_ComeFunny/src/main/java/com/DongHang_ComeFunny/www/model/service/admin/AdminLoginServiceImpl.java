package com.DongHang_ComeFunny.www.model.service.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DongHang_ComeFunny.www.model.dao.admin.AdminLoginDao;

@Service
public class AdminLoginServiceImpl implements AdminLoginService {

	@Autowired
	AdminLoginDao adminLoginDao;
}
