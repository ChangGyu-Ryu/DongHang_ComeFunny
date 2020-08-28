package com.DongHang_ComeFunny.www.user.model.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.DongHang_ComeFunny.www.user.model.vo.User;

@Repository
public class UserDao {
   @Autowired
   SqlSessionTemplate session;
   
   public User selectMember(
         Map<String, Object> commandMap) {
      
      return session.selectOne("USER.selectMember", commandMap);
   }
   
   public int insertUser(User user) {
      System.out.println("dao >>>>> : " + user);
      
      return session.insert("USER.insertUser", user);
   }
   
   public int idChk(String user) throws Exception {
      return session.selectOne("USER.idChk", user);
   }
   
   public String fId(String uname, String umail) {
		return session.selectOne("USER.fId", uname);
	}

//   public User findPassword(String umail) {
//      return session.selectOne("USER.findPassword", umail);
//   }
}