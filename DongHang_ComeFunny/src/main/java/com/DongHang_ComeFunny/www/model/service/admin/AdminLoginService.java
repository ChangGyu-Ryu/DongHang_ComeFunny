package com.DongHang_ComeFunny.www.model.service.admin;

import org.springframework.stereotype.Service;

import com.DongHang_ComeFunny.www.model.vo.Admin;

@Service
public interface AdminLoginService {

	Admin loginAdmin(Admin loginInfo);

}
