package com.DongHang_ComeFunny.www.user.model.service;

import java.io.PrintWriter;
import java.util.Map;
import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.DongHang_ComeFunny.www.user.model.dao.UserDao;
import com.DongHang_ComeFunny.www.user.model.vo.User;

import common.exception.MailException;
import common.util.SHA256Util;

@Service
public class UserServiceImpl implements UserService {
   
   @Autowired
   UserDao userDao;
   
   @Autowired
   JavaMailSender mailSender;
   
   @Autowired
   BCryptPasswordEncoder passwordEncoder;
   
   @Override
   public User selectMember(Map<String, Object> commandMap) {
      String password = (String) commandMap.get("pw");
      User user = userDao.selectMember(commandMap);
      //사용자가 입력한 패스원드와 인코딩된 패스워드가 일치하는지 확인
      if(passwordEncoder.matches(password, user.getUpw())) {
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
      user.setSalt(salt);
      
      String password = user.getUpw();
      //password 암호화
      //매번 다른 방식으로 암호화가된다.
      password = passwordEncoder.encode(password);
      System.out.println("암호화가 된 password" + password);
      user.setUpw(password);
      
      return userDao.insertUser(user);
   }
//   @Override
//   public User findId(User user) {
//      
//      
//      
//      return null;
//   }
   /*
   @Override
   public boolean userEmailCheck(String umail, String userid) {

        User user = userDao.findPassword(umail);
        if(user!=null && user.getUserid().equals(userid)) {
            return true;
        }
        else {
            return false;
        }
    }
*/
   @Override
   public int mailSending(User user, String urlPath) throws MailException {
      
      //랜덤 인증번호 생성, 인증번호 입력후 비밀번호 변경 페이지로 이동
      Random r = new Random();
      int dice = r.nextInt(157211)+48271;
      
      String setFrom = "rlagurwkd11@naver.com";
      String tomail = user.getUmail();
      String title = "비밀번호 찾기 인증번호";
      String htmlBody =
            "<form action='http://"+urlPath+"/user/fPw'"
            + "methpd='post'>"
            + "<h3>비밀번호 찾기 인증번호.</h3>"
            + "<input type='hidden' value='"
            + user.getUserid()+"' name='userId'>"
            + System.getProperty("line.separator")
            + "비밀번호 찾기 인증번호는 " + dice + "입니다."
            + System.getProperty("line.separator")
            + "받으신 인증번호를 홈페이지에 입력해 주세요!"
            + System.getProperty("line.separator")
            + "<button type='submit'>전송하기</button></form>";
try {
         
      mailSender.send(new MimeMessagePreparator() {
         public void prepare(MimeMessage mimeMessage) throws MessagingException {
            MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, "UTF-8");
            message.setFrom(setFrom);
            message.setTo(tomail);
            message.setSubject(title);
            
            //setText(htmlBody, true)
            //두번째 매개변수로 html여부를 지정
            //true면 html, false이면 텍스트
            message.setText(htmlBody, true);
         }
      });
      
      } catch(Exception e) {
         throw new MailException("M_ERROR_01");
      }
		return dice;
   }

   @Override
   public void idChk(String user, HttpServletResponse response) throws Exception {
      PrintWriter out = response.getWriter();
      out.println(userDao.idChk(user));
      out.close();
   }
}