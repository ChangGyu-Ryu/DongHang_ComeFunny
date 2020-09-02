package com.DongHang_ComeFunny.www.user.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.DongHang_ComeFunny.www.user.model.vo.User;

@Repository
public class UserDao implements TWUserDao { //TWUserDao.java 인터페이스 파일을 상속받아서 클래스 생성
   @Autowired
   SqlSessionTemplate session;
   
   private JdbcTemplate template;
   
   public void setTemplate(JdbcTemplate template) {
      this.template = template;
   }
   
    // 상속받아서 사용하는 함수기 때문에 override(재정의)해 사용한다.
    // ID를 찾기위해 입력된 uname과 umail을 매개변수로 해 구현한 함수.
   @Override
   public User getId(String uname, String umail) {
      
   // DB에서 돌린 쿼리문, ?는 매개변수에 따라 달라진다.
   // User테이블에서 입력된 uname과 umail이 있으면 해당되는 필드값을 출력하라는 쿼리문
   String sql = "select * from tb_user where uname=? and umail=?";   
   // try/catch문으로 묶어준 이유는 쿼리문의 결과값이 없다면 null을 무조건 return하게 했다.
     try {
      // 위 쿼리문의 ? 에 해당하는 것을 매개변수 Email과 name을 넣어 실행한다.
      return template.queryForObject(sql, new Object[] { uname, umail },
        new RowMapper<User>() {
         @Override
         public User mapRow(ResultSet rs, int rowNum) throws SQLException {
          User user = new User();
          user.setUno(rs.getInt("uno"));
          user.setUserid(rs.getString("userid"));
          user.setUpw(rs.getString("upw"));
          user.setUname(rs.getString("name"));
          user.setUbirth(rs.getString("ubirth"));
          user.setUgender(rs.getInt("ugender"));
          user.setUnick(rs.getString("unick"));
          user.setUphone(rs.getString("uphone"));
          user.setUmail(rs.getString("umail"));
          user.setUaddress(rs.getString("uaddress"));
          user.setUdhtcnt(rs.getInt("Udhtcnt"));
          user.setUregdate(rs.getDate("uregdate"));
          user.setSalt(rs.getString("salt"));
          return user;
         }
        });
     } catch (Exception e) {
      return null;
     }
    }

    // getId(uname, umail)함수를 이용해 값이 있는지 없는지 판단하는 함수
    @Override
    public boolean FindId(String uname, String umail) {
     // getId함수를 이용해 VO(Value Object) user에 담는다.
     User user = getId(uname, umail);
     // user의 값이 null이 아니면
     if (user != null) {
      // user의 Userid값을 userid라는 변수에 담는다.
      String userid = user.getUserid();
      // true를 return한다.
      return true;
     }
     // user의 값이 null이면 false를 return한다.
     return false;
    }   
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