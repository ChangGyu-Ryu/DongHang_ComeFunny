package com.DongHang_ComeFunny.www.model.service.main;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.DongHang_ComeFunny.www.model.dao.main.DoDao;
import com.DongHang_ComeFunny.www.model.dao.main.GoDao;
import com.DongHang_ComeFunny.www.model.vo.DoBoard;
import com.DongHang_ComeFunny.www.model.vo.DoCheck;

import common.util.DoFileUtil;

@Service
public class DoService {

	@Autowired DoDao doDao;
	
	//글 작성하기
	public void insertDoForm(
			DoBoard doBoard, DoCheck doCheck, 
			List<MultipartFile> files, String root) {
		
		List<String> age = Arrays.asList(doCheck.getDcAgeGroup().split(","));
		List<String> theme = Arrays.asList(doCheck.getDcTheme().split(","));
		
		doDao.insertDoBoard(doBoard);
		doDao.insertDoAge(age);
		doDao.insertDoTheme(theme);
		
		if(!(files.size() == 1 && files.get(0).getOriginalFilename().equals(""))) { //파일이 있으면
			List<Map<String,String>> filedata 
				= new DoFileUtil().fileUpload(files, root);
			for(Map<String,String> fileInfo : filedata) {
				doDao.insertgoImg(fileInfo);
			}
		}
		
	}

	
	//기본 리스트 부르기
	public List<Map<String, Object>> selectDoList(Map<String, Object> map) {
		
		System.out.println("[SERVICE]");
		return doDao.selectDolist(map);
		
	}
	
	
	//검색후리스트 부르기
	public Map<String, Object> selectsearchList(Map<String, Object> search, Map<String, Object> map) {
		
		//새로 맵 생성
		Map<String,Object> commandMap = new HashMap<String, Object>();
			
		List<Map<String,Object>> list = doDao.selectSearchList(search) ;
		commandMap.put("dlist", list);
		
		return commandMap;
	}

	//ajax포함 필터
	public Map<String, Object> selectFilterList(Map<String, Object> filter) {
		
		System.out.println("[DoService]");
		Map<String,Object> commandMap = new HashMap<String, Object>();
		
		List<Map<String, Object>> list = doDao.selectFilterList(filter);
		commandMap.put("dlist", list);  
		
		System.out.println("dlist :"+ commandMap);
		
		return commandMap;
	}
	
}
