package com.DongHang_ComeFunny.www.model.service.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DongHang_ComeFunny.www.model.dao.admin.AdminReviewBoardDao;
import com.DongHang_ComeFunny.www.model.vo.ReviewBoard;
import com.DongHang_ComeFunny.www.model.vo.ReviewComment;

import common.util.Paging;

@Service
public class AdminReviewBoardServiceImpl implements AdminReviewBoardService {

	@Autowired
	AdminReviewBoardDao adminReviewBoardDao;

	@Override
	public Map<String, Object> viewReviewBoardList(int cPage, int cntPerPage, Map<String, Object> searchReviewBoard) {
		
		Map<String,Object> commandMap = new HashMap<>();
		
		Paging p = new Paging(adminReviewBoardDao.selectReviewBoardCnt(searchReviewBoard), cPage, cntPerPage);
		
		Map<String,Object> searchReviewBoardMap = new HashMap<>();
		searchReviewBoardMap.put("paging",p);
		searchReviewBoardMap.putAll(searchReviewBoard);
		System.out.println(searchReviewBoardMap);
		
		List<ReviewBoard> reviewBoardList = adminReviewBoardDao.selectReviewBoardList(searchReviewBoardMap);
		
		commandMap.put("paging", p);
		commandMap.put("reviewBoardList", reviewBoardList);
		
		
		return commandMap;
	}

	@Override
	public void deleteReviewBoard(String[] rbNo) {
		for(int i=0; i<rbNo.length; i++) {
			adminReviewBoardDao.deleteReviewBoard(rbNo[i]);
		}
	}

	@Override
	public Map<String, Object> selectReviewView(int rbNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> selectGoBoardView(int rbGbNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> selectDoBoardView(int rbDbNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> selectReviewCommentList(int rbNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateReviewContent(ReviewComment reviewComment) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteReviewComment(ReviewComment reviewComment) {
		// TODO Auto-generated method stub
		return 0;
	}
}
