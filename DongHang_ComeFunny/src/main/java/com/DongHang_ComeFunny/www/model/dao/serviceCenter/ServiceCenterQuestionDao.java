package com.DongHang_ComeFunny.www.model.dao.serviceCenter;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.DongHang_ComeFunny.www.model.vo.QuestionBoard;
import com.DongHang_ComeFunny.www.model.vo.QuestionFile;

@Repository
public class ServiceCenterQuestionDao {
	
	@Autowired
	SqlSessionTemplate sqlSession;

	public int selectQuestionCnt(Map<String, Object> searchQuestionBoard) {
		return sqlSession.selectOne("ServiceCenterQuestion.selectQuestionCnt", searchQuestionBoard);
	}

	public List<QuestionBoard> selectQuestionList(Map<String, Object> searchQuestionMap) {
		// TODO Auto-generated method stub
		return null;
	}

	public void insertQuestion(QuestionBoard writeQuestionInfo) {
		// TODO Auto-generated method stub
		
	}

	public int selectWriteQbNo() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void InsertQuestionFile(Map<String, Object> data) {
		// TODO Auto-generated method stub
		
	}

	public QuestionBoard selectQuestionByQbNo(int qbNo) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<QuestionFile> selectQuestionFileByQbNo(int qbNo) {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<String, String> selectFile(int qfNo) {
		// TODO Auto-generated method stub
		return null;
	}

	public int deleteFile(int qfNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void updateQuestion(QuestionBoard modiQuestionInfo) {
		// TODO Auto-generated method stub
		
	}

}
