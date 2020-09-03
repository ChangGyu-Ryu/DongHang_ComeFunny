package com.DongHang_ComeFunny.www.model.dao.admin;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.DongHang_ComeFunny.www.model.vo.GoBoard;

@Repository
public class AdminGoBoardDao {
	
	@Autowired
	SqlSessionTemplate sqlSession;


	public int selectGoBoardCnt(Map<String, Object> searchGoBoard) {
		return sqlSession.selectOne("AdminGoBoard.selectGoBoardCnt", searchGoBoard);
	}

	public List<GoBoard> selectGoBoardList(Map<String, Object> searchDoBoardMap) {
		return sqlSession.selectList("AdminGoBoard.selectGoBoardList", searchDoBoardMap);
	}
	
	public void deleteGoBoard(String gbNo) {
		sqlSession.delete("AdminGoBoard.deleteGoBoard", gbNo);
	}
	

}
