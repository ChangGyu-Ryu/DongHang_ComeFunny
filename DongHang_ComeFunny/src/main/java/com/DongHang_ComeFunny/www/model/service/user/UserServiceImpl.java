package com.DongHang_ComeFunny.www.model.service.user;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.DongHang_ComeFunny.www.model.dao.user.UserDao;
import com.DongHang_ComeFunny.www.model.vo.User;

import common.util.SHA256Util;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public User selectMember(Map<String, Object> commandMap) {
		String password = (String) commandMap.get("pw");
		User user = userDao.selectMember(commandMap);
		//사용자가 입력한 패스원드와 인코딩된 패스워드가 일치하는지 확인
		if(passwordEncoder.matches(password, user.getuPw())) {
			//마이페이지에 사용자가 입력했던 password로 출력(복호화)
			/* member.setPassword(password); */
			return user;
		} else {
			//일치하지 않으면 null 반환
			return null;
		}
	}
	
	@Override
	public int insertUser(User user) {
		
		//SHA256
		//Hash 알고리즘 기반 암호화 구현
		//salt 난수 생성
		String salt = SHA256Util.generateSalt();
		
		//salt 셋팅
//		user.setSalt(salt);
		
		String password = user.getuPw();
		//password 암호화
		//매번 다른 방식으로 암호화가된다.
		password = passwordEncoder.encode(password);
		System.out.println("암호화가 된 password" + password);
		user.setuPw(password);
		
		return userDao.insertUser(user);
	}
	
	@Override
	public User selectMemberByUserId(String userId) {
		// TODO Auto-generated method stub
		return userDao.selectMemberByUserId(userId);
	}
	
	
}
