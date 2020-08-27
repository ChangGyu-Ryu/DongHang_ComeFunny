package com.DongHang_ComeFunny.www.model.service.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import common.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.firewall.FirewalledRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.DongHang_ComeFunny.www.controller.board.BoardController;
import com.DongHang_ComeFunny.www.model.dao.main.GoDao;
import com.DongHang_ComeFunny.www.model.vo.GoBoard;
import com.DongHang_ComeFunny.www.model.vo.GoCheck;

@Service
public class GoService {

	@Autowired GoDao goDao;
	
	//insertGoForm( 파일 포함 )
//	public void insertGoForm(GoBoard goBoard, GoCheck goCheck, List<MultipartFile> files, String root) 
//	{
//		
//		goDao.insertGoForm(goBoard); 
//		goDao.insertGoCheck(goCheck);
//		
//		if(!(files.size() == 1 && files.get(0).getOriginalFilename().equals(""))) {
//			List<Map<String,String>> filedata = new FileUtil().fileUpload(files, root);
//			
//			for(Map<String, String> fileInfo : filedata) {
//				goDao.insertFileWithSC(fileInfo);
//			}
//		}
//	}
	
	//insertGoForm( 파일 제외 )
	public void insertGoForm(GoBoard goBoard, GoCheck goCheck) 
	{
		//체크박스 String -> List 변환
		List<String> age = Arrays.asList(goCheck.getGcAgeGroup().split(","));
		List<String> theme = Arrays.asList(goCheck.getGcTheme().split(","));
		
		goDao.insertGoForm(goBoard); 
		goDao.insertGoAge(age); 
		goDao.insertGoTheme(theme);

	}
	
	//리스트전체 불러오기 최신순으로
	public List<Map<String, Object>> selectGoList(Map<String, Object> map) {
		
		System.out.println("[SERVICE]");
		return goDao.selectGoList(map);
		
	}
	
	//키워드검색
	public Map<String, Object> selectSearchList(Map<String, Object> search, Map<String, Object> map) {
		
		Map<String,Object> commandMap = new HashMap<String, Object>();
		
		if(search != null) {
			
			Map<String, Object> searchMap = new HashMap<>();
			searchMap.putAll(search); //검색값넣기
			
			//키우드로 검색된 게시글 조회
			List<Map<String,Object>> list = goDao.selectSearchList(search) ;
			commandMap.put("glist",list);
			
		} else { //키워드 없을경우
			List<Map<String, Object>> list = goDao.selectGoList(map);
			commandMap.put("glist", list);
		}
			
		return commandMap;
	}
	
	//ajax 필터링 검색
	public Map<String, Object> selectFilterList(Map<String, Object> search, Map<String, Object> map, Map<String, Object> filter) {
		
		Map<String,Object> commandMap = new HashMap<String, Object>();
		
		if(search != null) {
			Map<String, Object> searchMap = new HashMap<>();
			searchMap.putAll(search); //검색값넣기
			
			//키워드로 검색된 게시글 조회
			List<Map<String,Object>> list = goDao.selectSearchList(search) ;
			commandMap.put("glist",list);
			
		} 
//			else if (filter != null) {
//			List<Map<String, Object>> list = goDao.selectGoList(map);
//			commandMap.put("glist", list);
//		} 
			else { //서치하기 전에
			Map<String, Object> filterMap = new HashMap<>();
			filterMap.putAll(filter);
			
			List<Map<String,Object>> list = goDao.selectFilterList(filter) ;
			commandMap.put("glist",list);
		}
			
		return commandMap;
	}

	
	
}
