package com.DongHang_ComeFunny.www.model.dao.message;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.DongHang_ComeFunny.www.model.vo.Message;

import common.util.Paging;

@Repository
public class MessageDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	public int selectContentCnt(int uno) {
		return sqlSession.selectOne("MESSAGE.selectContentCnt", uno);
	}

	public List<Map<String, Object>> selectMessageList(Paging page, int uno) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("paging", page);
		map.put("uno", uno);
		return sqlSession.selectList("MESSAGE.selectMessageList", map);
	}

	public int deleteArr(int[] nums) {
		int res = 0;
		for (int val : nums) {
			res += sqlSession.delete("MESSAGE.deleteMessage", val);
		}
		return res;
	}

	public int delete(int msno) {
		return sqlSession.delete("MESSAGE.deleteMessage", msno);
	}

	public int update(int msno) {
		return sqlSession.update("MESSAGE.updateMessage", msno);
	}

	public int updateArr(int[] nums) {
		int res = 0;
		for (int val : nums) {			
			res += sqlSession.update("MESSAGE.updateMessage", val);
		}
		return res;
	}

	public Message selectMessageList(int msno) {
		return sqlSession.selectOne("MESSAGE.selectMessage",msno);
	}

	public int insert(Message sendMessage) {
		return sqlSession.insert("MESSAGE.insertMessage",sendMessage);
	}

	public int selectSeq() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("MESSAGE.selectSequence");
	}

}
