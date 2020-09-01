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
		System.out.println("[GODAO]");
		return sqlSession.selectList("GO.selectgosearch", search);
	}

	public List<Map<String, Object>> selectFilterList(Map<String, Object> filter) {
		return sqlSession.selectList("GO.selectfilter", filter);
	}

	//함께가요 상세 글 정보, 작성자 프로필 이미지
	public Map<String, Object> selectGoUserInfo(int gbNo) {
		return sqlSession.selectOne("GO.selectGoUserInfo", gbNo);
	}
	
	//함께가요 상세 체크박스
	public List<GoCheck> selectGocheck(int gbNo) {
		return sqlSession.selectList("GO.selectGocheck", gbNo);
	}
	
	//체크리스트 갖고오기 (selectGoDetail 에 put) - 문정 필요
	public Map<String, Object> selectGochklist(int gbNo) {
	    return sqlSession.selectOne("GO.selectGochklist", gbNo);
	}
	
	//함께가요 호스트 평점
	public List<Map<String, Object>> selectGoHostReview(int gbNo) {
		return sqlSession.selectList("GO.selectGoHostReview", gbNo);
	}
	
	//함꼐가요 호스트 평점 갯수
	public int selecthostReviewCnt(int gbNo) {
		return sqlSession.selectOne("GO.selecthostReviewCnt", gbNo);
	}
	
	//함께가요 찜목록 클릭 여부
	public int selectGoLikeStatus(int gbNo, int uNo) {
		Map<Object, Object> param = new HashMap<Object, Object>();
		param.put("gbNo", gbNo);
		param.put("uNo", uNo);
		
		return sqlSession.selectOne("GO.selectGoLikeStatus", param);
	}
		
	//함께가요 동행 신청
	public int insertGoDhApply(int gbNo, int uNo) {
		
		Map<Object, Object> param = new HashMap<Object, Object>();
		param.put("gbNo", gbNo);
		param.put("uNo", uNo);
		
		
		return sqlSession.insert("GO.insertGoDhApply", param);
	}
	
	
	//함께가요 동행 신청 목록
	public List<Map<String, Object>> selectgoDhApplylist(int gbNo) {
		return sqlSession.selectList("GO.selectgoDhApplylist", gbNo);
	}
	
	//함께가요 새로운 동행 추가 조회
	public Map<String, Object> selectGoNewApply(int gbNo, int uNo) {
		Map<Object, Object> param = new HashMap<Object, Object>();
		param.put("gbNo", gbNo);
		param.put("uNo", uNo);
		
		return sqlSession.selectOne("GO.selectGoNewApply", param);
	}
	
	//함께가요 동행 수락 
	public int updateGoApplyOkStatus(int gbNo, int gaUNo) {
		Map<Object, Object> param = new HashMap<Object, Object>();
		param.put("gbNo", gbNo);
		param.put("gaUNo", gaUNo);
		
		return sqlSession.update("GO.updateGoApplyOkStatus", param);
	}
	
	//함께가요 동행 거절
	public int updateGoApplyNoStatus(int gbNo, int gaUNo) {
		Map<Object, Object> param = new HashMap<Object, Object>();
		param.put("gbNo", gbNo);
		param.put("gaUNo", gaUNo);
		
		return sqlSession.update("GO.updateGoApplyNoStatus", param);
	}

	//함께가요 찜목록 추가
	public int insertGoLike(int gbNo, int uNo) {
		Map<Object, Object> param = new HashMap<Object, Object>();
		param.put("gbNo", gbNo);
		param.put("uNo", uNo);
		
		return sqlSession.insert("GO.insertGoLike", param);
	}

	//함께가요 찜목록 삭제
	public int DeleteGoLike(int gbNo, int uNo) {
		Map<Object, Object> param = new HashMap<Object, Object>();
		param.put("gbNo", gbNo);
		param.put("uNo", uNo);
		
		return sqlSession.delete("GO.DeleteGoLike", param);
	}
	
	//함께가요 삭제 -> gbisdel = 1 로 update
	public int deleteGoboard(int gbNo) {
		return sqlSession.update("GO.deleteGoboard", gbNo);
	}

	

	
	
}
