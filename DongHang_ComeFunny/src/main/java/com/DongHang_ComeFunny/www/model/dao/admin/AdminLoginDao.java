package com.DongHang_ComeFunny.www.model.dao.admin;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.DongHang_ComeFunny.www.model.vo.Admin;

@Repository
public class AdminLoginDao {
	
	@Autowired
	SqlSessionTemplate sqlSession;

	public Admin selectAdmin(Admin loginInfo) {
		return sqlSession.selectOne("AdminLogin.selectAdmin", loginInfo);
	}
	

}
