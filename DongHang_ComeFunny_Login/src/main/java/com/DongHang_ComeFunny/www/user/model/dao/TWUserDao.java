package com.DongHang_ComeFunny.www.user.model.dao;

import com.DongHang_ComeFunny.www.user.model.vo.User;

public interface TWUserDao {
   
   public User getId(String uname, String umail);
   public boolean FindId(String uname, String umail);

}