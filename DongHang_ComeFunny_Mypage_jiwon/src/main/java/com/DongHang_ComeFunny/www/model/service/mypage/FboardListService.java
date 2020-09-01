package com.DongHang_ComeFunny.www.model.service.mypage;

import java.util.Map;

import com.DongHang_ComeFunny.www.model.vo.DoApply;
import com.DongHang_ComeFunny.www.model.vo.FreeBoard;
import com.DongHang_ComeFunny.www.model.vo.FreeComment;
import com.DongHang_ComeFunny.www.model.vo.GoApply;
import com.DongHang_ComeFunny.www.model.vo.GoBoard;
import com.DongHang_ComeFunny.www.model.vo.Order;
import com.DongHang_ComeFunny.www.model.vo.ReviewBoard;

public interface FboardListService {

	/**
	 * 자유게시판 목록 띄우기
	 * @param cPage
	 * @param cntPerPage
	 * @param uno
	 * @return
	 */
	public Map<String, Object> selectFboardList(int cPage, int cntPerPage, int uno);
	
	/**
	 * 자유게시판 삭제
	 * @param fboard
	 */
	public void deleteFboardList(FreeBoard fboard);

	/**
	 * 후기게시판 목록띄우기
	 * @param cPage
	 * @param cntPerPage
	 * @param uno
	 * @return
	 */
	public Map<String, Object> selectRboardList(int cPage, int cntPerPage, int uno);

	/**
	 * 후기 게시판 삭제
	 * @param rboard
	 */
	public void deleteRboardList(ReviewBoard rboard);

	
	/**
	 * 댓글 목록 띄우기
	 * @param cPage
	 * @param cntPerPage
	 * @param uno
	 * @return
	 */
	public Map<String, Object> selectFcmtList(int cPage, int cntPerPage, int uno);

	/**
	 * 자유개시판 댓글 지우기
	 * @param fcmt
	 */
	public void deleteFcmtList(FreeComment fcmt);

	/**
	 * 후기게시판 댓글 리스트 
	 * @param cPage
	 * @param cntPerPage
	 * @param uno
	 * @return
	 */
	public Map<String, Object> selectRcmtList(int cPage, int cntPerPage, int uno);

	/**
	 * 복권 구매내역 
	 * @param cPage
	 * @param cntPerPage
	 * @param uno
	 * @return
	 */
	public Map<String, Object> paymentList(int cPage, int cntPerPage, int uno);

	/**
	 * 복권 구매내역 삭제
	 * @param order
	 */
	public void deletePmList(Order order);

	/**
	 * 신청한 동행 관리 내역
	 * @param cPage
	 * @param cntPerPage
	 * @param uno
	 * @return
	 */
	public Map<String, Object> selectApDhList(int cPage, int cntPerPage, int uno);

	/**
	 * 신청한 동행(함께가요)삭제
	 * @param goapply
	 */
	public void deleteAplyDhList(GoApply goapply);

	/**
	 * 신청한 동행(함께 해요)
	 * @param cPage
	 * @param cntPerPage
	 * @param uno
	 * @return
	 */
	public Map<String, Object> selectDoApDhList(int cPage, int cntPerPage, int uno);

	/**
	 * 신청한 동행(함께해요)삭제
	 * @param doapply
	 */
	public void deleteDoAplyDhList(DoApply doapply);

//	/**
//	 * 나의 동행(함께 가요)
//	 * @param cPage
//	 * @param cntPerPage
//	 * @param uno
//	 * @return
//	 */
	public Map<String, Object> selectMyGoDhList(int cPage, int cntPerPage, int uno);

	/**
	 * 나의 동행(함께 가요) 삭제
	 * @param goboard
	 */
	public void deleteGoMyDhList(GoBoard goboard);

	/**
	 * 나의 동행(함께 가요) 관리
	 * @param gbno : 해당 게시글번호
	 * @param cntPerPage : 한페이지당 나타날 리스트 수
	 * @param cPage : 현재 페이지
	 * @return
	 */
	public Map<String, Object> selectrecruitList(String gbcategory, int gbno, int cPage, int cntPerPage);

	/**
	 * 니의동행(함께 가요)
	 * @param cPage
	 * @param cntPerPage
	 * @param uno
	 * @param gbno
	 * @return
	 */
//	public Map<String, Object> selectMyGoDhList(int cPage, int cntPerPage, int uno, int gbno);

}
