package com.DongHang_ComeFunny.www.user.model.service;

import java.util.Map;

import com.DongHang_ComeFunny.www.user.model.vo.User;

public interface UserService {
	
	/**
	 * 회원 로그인
	 * @param commandMap - 로그인DB가 담긴 객체
	 * @return User - 회원정보
	 */
	public User selectMember(Map<String, Object> commandMap);
	
	/**
	 * 회원 가입
	 * @param user - 회원가입DB가 담긴 객체
	 * @return int - 가입완료 : 1 가입실패 : 0
	 */
	public int insertUser(User user);
}
