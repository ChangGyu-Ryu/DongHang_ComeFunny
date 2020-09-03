package com.DongHang_ComeFunny.www.model.dao.admin;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.DongHang_ComeFunny.www.model.vo.FreeBoard;

@Repository
public class AdminFreeBoardDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	public int selectFreeBoardCnt(Map<String, Object> searchFreeBoard) {
		return sqlSession.selectOne("AdminFreeBoard.selectFreeBoardCnt", searchFreeBoard);
	}

	public List<FreeBoard> selectFreeBoardList(Map<String, Object> searchFreeBoardMap) {
		return sqlSession.selectList("AdminFreeBoard.selectFreeBoardList", searchFreeBoardMap);
	}

	public void deleteFreeBoard(String fbNo) {
		sqlSession.delete("AdminFreeBoard.deleteFreeBoard", fbNo);
	}

	public List<Map<String, Object>> selectFreeCommentList(int fbNo) {
		return sqlSession.selectList("AdminFreeBoard.selectFreeWithCommentList", fbNo);
	}

	public Map<String, Object> selectFreeDetail(int fbNo) {
		return sqlSession.selectOne("AdminFreeBoard.selectFreeDetail", fbNo);
	}

	public List<Map<String, Object>> selectFileWithFree(int fbNo) {
		return sqlSession.selectList("AdminFreeBoard.selectFileWithFree", fbNo);
	}

}
