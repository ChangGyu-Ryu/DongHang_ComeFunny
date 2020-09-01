package com.DongHang_ComeFunny.www.model.dao.mypage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.DongHang_ComeFunny.www.model.vo.DoApply;
import com.DongHang_ComeFunny.www.model.vo.FreeBoard;
import com.DongHang_ComeFunny.www.model.vo.FreeComment;
import com.DongHang_ComeFunny.www.model.vo.GoApply;
import com.DongHang_ComeFunny.www.model.vo.GoBoard;
import com.DongHang_ComeFunny.www.model.vo.Order;
import com.DongHang_ComeFunny.www.model.vo.PayMent;
import com.DongHang_ComeFunny.www.model.vo.ReviewBoard;
import com.DongHang_ComeFunny.www.model.vo.ReviewComment;
import com.DongHang_ComeFunny.www.model.vo.User;

import common.util.Paging;

@Repository
public class FboardListDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	//자유게시판 게시글수 카운트 
	public int selectFbContentCnt(int uno) { 
		
		return sqlSession.selectOne("Fboard.selectFbContentCnt", uno);
	}

	//자유게시판 댓글 띄우기
	public int selectFcommentCnt(int uno) {
		
		return sqlSession.selectOne("Fboard.selectFcommentCnt", uno);
	}

	//자유게시판 리스트 띄우기
	public List<FreeBoard> selectFboardList(Paging p, int uno) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("p",p);
		param.put("uno", uno);
		return sqlSession.selectList("Fboard.selectFboardList", param);
	}


	//자유게시판 게시글 삭제
	public void deleteFboardList(FreeBoard fboard) {
//		System.out.println(fboard);
		sqlSession.delete("Fboard.deleteFboardList", fboard);
	}

	//후기게시판 게시글수 카운트 
	public int selectRbContentCnt(int uno) {
		return sqlSession.selectOne("Fboard.selectRbContentCnt", uno);
	}

	//후게시판 댓글 띄우기
	public int selectRbcommentCnt(int uno) {
		return sqlSession.selectOne("Fboard.selectRbcommentCnt", uno);
	}

	//후기게시판 리스트 띄우기
	public List<ReviewBoard> selectRboardList(Paging p, int uno) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("p",p);
		param.put("uno", uno);
		return sqlSession.selectList("Fboard.selectRboardList", param);
	}

	//후기게시판 리스트 삭제
	public void deleteRboardList(ReviewBoard rboard) {
//		System.out.println(rboard);
		sqlSession.delete("Fboard.deleteRboardList", rboard);
		
	}

	//나의댓글수 카운트
	public int selectCbContentCnt(int uno) {
		return sqlSession.selectOne("Fboard.selectCbContentCnt", uno);
	}

	//나의 댓글 리스트 띄우기
	public List<FreeComment> selectFcmtList(Paging p, int uno) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("p",p);
		param.put("uno", uno);
		return sqlSession.selectList("Fboard.selectFcmtList", param);
	}

	//댓글(자유) 삭제
	public void deletefcmtList(FreeComment fcmt) {

		sqlSession.delete("Fboard.deletefcmtList", fcmt);
		
	}

	//후기 게시판 댓글 개수
	public int selectRcmtContentCnt(int uno) {
		return sqlSession.selectOne("Fboard.selectRcmtContentCnt", uno);
	}

	//후기게시판 댓글 목록 띄우기
	public List<ReviewComment> selectRcmtList(Paging p, int uno) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("p",p);
		param.put("uno", uno);
		return sqlSession.selectList("Fboard.selectRcmtList", param);
	}	
	
	
	//댓글(후기) 삭제
	public void deleteRcmtList(ReviewComment rcmt) {
		sqlSession.delete("Fboard.deleteRcmtList", rcmt);
		
	}

	//복권 구매 내역 카운트
	public int selectPmContentCnt(int uno) {
		return sqlSession.selectOne("Fboard.selectPmContentCnt", uno);
	}

	//복권 구매 내역 리스트
	public List<PayMent> selectPmList(Paging p, int uno) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("p",p);
		param.put("uno", uno);
		return sqlSession.selectList("Fboard.selectPmList", param);
	}
	
	//보유복권 수량 카운트
	public int selecTkCnt(int uno) {
		return sqlSession.selectOne("Fboard.selecTkCnt", uno);
	}

	//복권구매내역 삭제
	public void deletepmList(Order order) {
		sqlSession.update("Fboard.deletepmList", order);
		
	}

	//(함께가요 ) 신청한 동행 카운트
	public int selectApDhContentCnt(int uno) {
		return sqlSession.selectOne("Fboard.selectApDhContentCnt", uno);
	}

	//(함께가요) 신청한 동행 리스트
	public List<GoApply> selectApDhList(Paging p, int uno) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("p",p);
		param.put("uno", uno);
		return sqlSession.selectList("Fboard.selectApDhList", param);
	}

	//(함께 가요) 신청한 동행 삭재
	public void deleteAplyDhList(GoApply goapply) {
		sqlSession.delete("Fboard.deleteApDhList", goapply);
	}

	//(함께 해요) 신청한 동행 카운트
	public int selectDoApDhContentCnt(int uno) {
		return sqlSession.selectOne("Fboard.selectDoApDhContentCnt", uno);
	}

	//(함께 해요) 신청한 동행 리스트
	public List<DoApply> selectDoApDhList(Paging p, int uno) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("p",p);
		param.put("uno", uno);
		return sqlSession.selectList("Fboard.selectDoApDhList", param);
	}

	//(함께 해요) 신청한 동행 삭제
	public void deleteDoAplyDhList(DoApply doapply) {
		sqlSession.delete("Fboard.deleteDoAplyDhList", doapply);
	}

	//나의 동행 (함께 가요) 카운트
	public int selectMyGoDhContentCnt(int uno) {
		return sqlSession.selectOne("Fboard.selectMyGoDhContentCnt", uno);
	}

	//나의 동행 (함께 가요) 리스트
	public List<GoBoard> selectMyGoDhList(Paging p, int uno) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("p",p);
		param.put("uno", uno);
		return sqlSession.selectList("Fboard.selectMyGoDhList", param);
	}

	//현재 수락된 인원
	public int selectRecruitNumCnt(int gbno, String gbcategory ) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("gbno", gbno);
		param.put("gbcategory", gbcategory);
		int res = sqlSession.selectOne("Fboard.selectRecruitNumCnt", param);
		System.out.println("신청자수  : " + res);
		
		return sqlSession.selectOne("Fboard.selectRecruitNumCnt", param);
	}

	//나의 동행 (함께 가요) 리스트 삭제
	public void deleteGoMyDhList(GoBoard goboard) {
		sqlSession.update("Fboard.deleteMyGoDhList", goboard);	
	}

//	//(함께 가요)동행 신청자 리스트 카운트
//	public int selectrecruitContentCnt(int gbno , String gbcategory) {		
//		Map<String, Object> param = new HashMap<String, Object>();
//		param.put("gbno", gbno);
//		param.put("gbcategory", gbcategory);
//		System.out.println( "신청자 리스트 : " + param);
//		return sqlSession.selectOne("Fboard.selectrecruitContentCnt",param);
//	}
	
	public List<User> selectrecruitList(int gbno, String gbcategory) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("gbno", gbno);
		param.put("gbcategory", gbcategory);
		return sqlSession.selectList("Fboard.selectrecruitList", param);
	}
	
	
}
