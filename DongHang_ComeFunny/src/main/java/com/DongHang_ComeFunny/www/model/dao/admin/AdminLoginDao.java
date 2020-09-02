package com.DongHang_ComeFunny.www.model.dao.admin;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdminLoginDao {
	
	@Autowired
	SqlSessionTemplate sqlSession;
	

}
