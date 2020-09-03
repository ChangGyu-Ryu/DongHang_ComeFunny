package com.DongHang_ComeFunny.www.model.service.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DongHang_ComeFunny.www.model.dao.admin.AdminGoBoardDao;
import com.DongHang_ComeFunny.www.model.vo.GoBoard;

import common.util.Paging;

@Service
public class AdminGoBoardServiceImpl implements AdminGoBoardService {
	
	@Autowired
	AdminGoBoardDao adminGoBoardDao;

	@Override
	public Map<String, Object> viewGoBoardList(int cPage, int cntPerPage, Map<String, Object> searchGoBoard) {
		Map<String,Object> commandMap = new HashMap<>();
		
		Paging p = new Paging(adminGoBoardDao.selectGoBoardCnt(searchGoBoard), cPage, cntPerPage);
		
		Map<String,Object> searchDoBoardMap = new HashMap<>();
		searchDoBoardMap.put("paging",p);
		searchDoBoardMap.putAll(searchGoBoard);
		System.out.println(searchDoBoardMap);
		
		List<GoBoard> doBoardList = adminGoBoardDao.selectGoBoardList(searchDoBoardMap);
		
		commandMap.put("paging", p);
		commandMap.put("doBoardList", doBoardList);
		
		
		return commandMap;
		
		
	}

	@Override
	public void deleteGoBoard(String[] gbNo) {
		for(int i=0; i<gbNo.length; i++) {
			adminGoBoardDao.deleteGoBoard(gbNo[i]);
		}
		
	}
	
}
