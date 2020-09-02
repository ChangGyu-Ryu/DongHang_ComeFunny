package com.DongHang_ComeFunny.www.model.dao.main;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.DongHang_ComeFunny.www.model.vo.DoBoard;
import com.DongHang_ComeFunny.www.model.vo.DoCheck;

@Repository
public class DoDao {
	
	@Autowired private SqlSessionTemplate sqlSession;

	//doboard에 값 삽입
	public int insertDoBoard(DoBoard doBoard) {
		return sqlSession.insert("DO.insertdoboard", doBoard);
	}

	//gocheck에 값 삽입
	public int insertDoAge(List<String> age) {
		return sqlSession.insert("DO.insertdoage", age);
	}
	
	//docheck에 값 삽입
	public int insertDoTheme(List<String> theme) {
		return sqlSession.insert("DO.insertdotheme", theme);
	}
	
	//fileboard에 삽입
	public int insertgoImg(Map<String, String> fileInfo) {
		return sqlSession.insert("DO.insertfile",fileInfo);
	}

	//기본리스트띄우기 
	public List<Map<String, Object>> selectDolist(Map<String, Object> map) {
		return sqlSession.selectList("DO.selectdolist", map);
	}
	
	//검색필터
	public List<Map<String, Object>> selectSearchList(Map<String, Object> search) {
		System.out.println("[DODAO]"); 
		return sqlSession.selectList("DO.selectdosearch", search);
	}

	//필터링
	public List<Map<String, Object>> selectFilterList(Map<String, Object> filter) {
		return sqlSession.selectList("DO.selectfilterlist", filter); 
	}


	

}
