package com.DongHang_ComeFunny.www.model.dao.main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.DongHang_ComeFunny.www.model.vo.GoBoard;
import com.DongHang_ComeFunny.www.model.vo.GoCheck;

@Repository
public class GoDao {

	@Autowired private SqlSessionTemplate sqlSession;
	
	//게시글 추가
	public int insertGoForm(GoBoard goBoard) {
		return sqlSession.insert("GO.insertgoboard", goBoard);
	}
	
	//게시글 체크박스 추가
	public int insertGoAge(List<String> age) {
		return sqlSession.insert("GO.insertgoage", age);
	}
	
	public int insertGoTheme(List<String> theme) {
		return sqlSession.insert("GO.insertgotheme", theme);
	}
	
	//파일포함 게시글 추가
//	public int insertFileWithSC(Map<String, String> fileInfo) {
//		return sqlSession.insert("GO.insertgofile", fileInfo);
//	}

	//전체 게시글 리스트 보여주기 (최신순 정렬)
	public List<Map<String, Object>> selectGoList(Map<String, Object> map){
		System.out.println("[GODAO]"); 
		return sqlSession.selectList("GO.selectlist", map);
	}
	
	//검색포함
	public List<Map<String, Object>> selectSearchList(Map<String, Object> search) {
		System.out.println("[GODAO : selectSearchList]");
		return sqlSession.selectList("GO.selectgosearch", search);
	}

	public List<Map<String, Object>> selectFilterList(Map<String, Object> filter, Map<String, Object> search) {
		System.out.println("[GODAO : selectFilterList]");
		Map<String, Object> param = new HashMap<String, Object>();
	      param.put("filter", filter);
	      param.put("search", search);
	      
		return sqlSession.selectList("GO.selectfilter", param);
	}
	
}
