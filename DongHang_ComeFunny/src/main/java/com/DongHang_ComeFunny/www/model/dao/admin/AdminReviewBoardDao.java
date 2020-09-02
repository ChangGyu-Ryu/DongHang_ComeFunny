package com.DongHang_ComeFunny.www.model.dao.admin;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.DongHang_ComeFunny.www.model.vo.ReviewBoard;

@Repository
public class AdminReviewBoardDao {
	
	@Autowired
	SqlSessionTemplate sqlSession;

	public List<ReviewBoard> selectReviewBoardList(Map<String, Object> searchReviewBoardMap) {
		return sqlSession.selectList("AdminReviewBoard.selectReviewBoardList", searchReviewBoardMap);
	}

	public int selectReviewBoardCnt(Map<String, Object> searchReviewBoard) {
		return sqlSession.selectOne("AdminReviewBoard.selectReviewBoardCnt", searchReviewBoard);
	}

	public void deleteReviewBoard(String rbNo) {
		sqlSession.delete("AdminReviewBoard.deleteReviewBoard", rbNo);
	}

}
