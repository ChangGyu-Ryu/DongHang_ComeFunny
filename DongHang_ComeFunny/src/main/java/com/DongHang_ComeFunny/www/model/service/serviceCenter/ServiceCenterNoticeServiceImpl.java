package com.DongHang_ComeFunny.www.model.service.serviceCenter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DongHang_ComeFunny.www.model.dao.serviceCenter.ServiceCenterNoticeDao;
import com.DongHang_ComeFunny.www.model.vo.NoticeBoard;

import common.util.Paging;

@Service
public class ServiceCenterNoticeServiceImpl implements ServiceCenterNoticeService {
	
	@Autowired
	ServiceCenterNoticeDao serviceCenterNoticeDao;

	@Override
	public Map<String, Object> viewNoticeBoardList(int cPage, int cntPerPage, Map<String, Object> searchNoticeBoard) {
		
		Map<String,Object> commandMap = new HashMap<>();
		
		Paging p = new Paging(serviceCenterNoticeDao.selectNoticeCnt(searchNoticeBoard), cPage, cntPerPage);
		
		Map<String,Object> searchNoticeMap = new HashMap<>();
		searchNoticeMap.put("paging",p);
		searchNoticeMap.putAll(searchNoticeBoard);
		System.out.println(searchNoticeMap);
		
		List<NoticeBoard> noticeList = serviceCenterNoticeDao.selectNoticeList(searchNoticeMap);
		
		commandMap.put("paging", p);
		commandMap.put("noticeList", noticeList);
		
		
		return commandMap;
	}

	@Override
	public Map<String, Object> viewNotice(int nbNo) {
		
		List<String> viewNotice = serviceCenterNoticeDao.selectNoticeByNbNo(nbNo);
		
		
		Map<String,Object> viewNoticeMap = new HashMap<>();
		viewNoticeMap.put("viewNotice",viewNotice);
		return viewNoticeMap;
		
	}
}
	
