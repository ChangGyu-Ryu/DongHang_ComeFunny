package com.DongHang_ComeFunny.www.model.service.message;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import com.DongHang_ComeFunny.www.model.vo.Message;
import com.DongHang_ComeFunny.www.model.vo.User;





public interface MessageService {


	Map<String, Object> selectMessageList(User logUser, int cPage, int cntPerPage);

	int deleteArray(String[] arr);

	int delete(String res);

	int storeArray(String[] arr);

	int store(String res);

	Map<String, Object> selectMessage(int msno);

	User selectUserIdById(String string);

	User selectUserIdByNick(String string);

	int sendMailList(String[] arr, User sender, Message sendMessage);

	int SendMail(String receiverId, User sender, Message sendMessage);

	
}
