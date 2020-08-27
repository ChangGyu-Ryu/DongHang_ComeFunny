package com.DongHang_ComeFunny.www.model.dao.user;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.DongHang_ComeFunny.www.model.vo.User;

@Repository
public class UserDao {
	@Autowired
	SqlSessionTemplate session;
	
	public User selectMember(
			Map<String, Object> commandMap) {
		
		return session.selectOne("User.selectMember", commandMap);
	}
	
	public int insertUser(User user) {
		System.out.println("dao >>>>> : " + user);
		
		return session.insert("User.insertUser", user);
	}
}
