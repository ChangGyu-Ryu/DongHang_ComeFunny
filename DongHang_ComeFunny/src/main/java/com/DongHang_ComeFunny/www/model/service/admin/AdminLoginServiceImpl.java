package com.DongHang_ComeFunny.www.model.service.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DongHang_ComeFunny.www.model.dao.admin.AdminLoginDao;
import com.DongHang_ComeFunny.www.model.vo.Admin;
import com.DongHang_ComeFunny.www.model.vo.User;

@Service
public class AdminLoginServiceImpl implements AdminLoginService {

	@Autowired
	AdminLoginDao adminLoginDao;

	@Override
	public Admin loginAdmin(Admin loginInfo) {
		
		Admin admin = adminLoginDao.selectAdmin(loginInfo);
		
		return admin;
	}
}
