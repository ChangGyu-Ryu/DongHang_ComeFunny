package com.DongHang_ComeFunny.www.board.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.DongHang_ComeFunny.www.board.model.vo.FreeBoard;

import common.util.Paging;

@Repository
public class FreeBoardDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public int insertFree(FreeBoard free) {
		return sqlSession.insert("FREE.insertFree", free);
	}
	
	public int insertFile(Map<String, Object> map) {
		return sqlSession.insert("FREE.insertFile", map);
	}
	
	//전체 게시글 수
	public int selectContentCnt() {
		return sqlSession.selectOne("FREE.selectContentCnt");
	}

	//게시글 리스트(페이지네이션 포함)
	public List<Map<String, Object>> selectFreeList(Paging page) {
		return sqlSession.selectList("FREE.selectFreeList", page);
	}

	public Map<String, Object> selectFreeDetail(int fbno) {
		return sqlSession.selectOne("FREE.selectFreeDetail", fbno);
	}

	public List<Map<String, Object>> selectFileWithFree(int fbno) {
		return sqlSession.selectList("FREE.selectFileWithFree", fbno);
	}

	public int updateHit(Map<String, Object> fdetail) {
		return sqlSession.update("FREE.updateHit",fdetail);
	}

	public Map<String, String> selectFreeFile(int ffno) {
		return sqlSession.selectOne("FREE.selectFreeFile",ffno);
	}

	// 파일 db 완전 삭제 코드
	public int deleteFile(int ffno) {
		return sqlSession.delete("FREE.deleteFile", ffno);
	}
	
	// 파일 db isdel update 코드
//	public int updateFileIsDel(int ffno) {
//		return sqlSession.update("FREE.updateFileIsDel", ffno);
//	}



}
