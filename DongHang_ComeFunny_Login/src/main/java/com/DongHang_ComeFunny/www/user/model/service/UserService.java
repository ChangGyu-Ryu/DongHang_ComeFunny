package com.DongHang_ComeFunny.www.user.model.service;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.DongHang_ComeFunny.www.user.model.vo.User;

import common.exception.MailException;

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
   
   /**
    * 아이디 중복확인
    * @param user - 아이디가 담긴 객체
    * @return int - 있으면 1 없으면 0
    * @throws Exception
    */
   public void idChk(String user, HttpServletResponse response) throws Exception;   
   
//   /**
//    * 아이디 찾기
//    * @param user - 회원정보가 담긴 객체
//    * @return User - 회원정보
//    */
//   public User findId(User user);
//
//   /**
//    * 비밀번호 찾기 이메일 인증
//    * @param userId - 회원 아이디
//    * @param umail - 회원 이메일
//    * @return
//    */
//   public boolean userEmailCheck(String userid, String umail);

   public int mailSending(User user, String urlPath) throws MailException;
   
}