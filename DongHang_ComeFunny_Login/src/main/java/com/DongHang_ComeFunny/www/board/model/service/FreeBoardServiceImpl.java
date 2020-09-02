package com.DongHang_ComeFunny.www.board.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.DongHang_ComeFunny.www.board.model.dao.FreeBoardDao;
import com.DongHang_ComeFunny.www.board.model.vo.FreeBoard;
import com.DongHang_ComeFunny.www.user.model.vo.User;

import common.exception.FileException;
import common.util.FileUtil;
import common.util.Paging;

@Service
public class FreeBoardServiceImpl implements FreeBoardService {
	
	@Autowired
	private FreeBoardDao freeBoardDao;
	
	//스프링에 트랜잭션 관리를 위임하는 어노테이션
	//method 혹은 class 위에 작성할 수 있다.
	//class에 지정할 경우 해당 클래스의 모든 메서드가 스프링에 트랜잭션 관리를 받게 된다.
	/* @Transactional */
	public int insertFree(
			//Controller가 보내준
			//사용자가 등록한 파일 정보를 가지고 있는 리스트
			FreeBoard free
			, List<MultipartFile> files
			, String root
			) throws FileException  {
		//사용자가 올린 게시글을 게시판 테이블에 등록
		if(free.getFbtitle()==null || "".equals(free.getFbtitle()) ) {
			free.setFbtitle("<제목없음>");
			
		} 
		if(free.getFbcontent()==null || "".equals(free.getFbcontent()) ) {
			free.setFbcontent("<내용없음>");
		}
		


		int result = freeBoardDao.insertFree(free);
		//에러발생을 위한 코드
//		int errorNumber = 10/0;
		
		// 파일 업로드를 위한 fileUtil 생성
		FileUtil fileUtil = new FileUtil();
		
		
		//파일을 업로드하고, tb_file 테이블에 저장할 데이터를 변화
		List<Map<String, Object>> filedata = fileUtil.fileUpload(files, root);
		System.out.println("listmap[1] : "+filedata.get(0).get("originFileName"));
		if( filedata.get(0).get("originFileName") == null || "".equals(filedata.get(0).get("originFileName"))) {
			return result;
		}
		for(Map<String, Object> data : filedata) {
			//file 테이블에 파일과 관련된 정보를 저장
			freeBoardDao.insertFile(data);
		}
		return result;
		
	}
	
	@Override
	public Map<String, Object> selectFreeList(
			//현재 페이지
			int cPage 
			//페이지당 노출할 게시글 수
			, int cntPerPage) {
		Map<String, Object> commandMap = new HashMap<>();	
		Paging page = new Paging(freeBoardDao.selectContentCnt(), cPage, cntPerPage);
		List<Map<String, Object>> flist = freeBoardDao.selectFreeList(page);
		commandMap.put("flist", flist);
		commandMap.put("paging", page);
		
		return commandMap;
	}
	
	
	@Override
	public Map<String, Object> selectFreeView(int fbno) {
		Map<String, Object> fdetail = freeBoardDao.selectFreeDetail(fbno);
		List<Map<String, Object>> filelist = freeBoardDao.selectFileWithFree(fbno);
		Map<String, Object> commandMap = new HashMap<>();
		commandMap.put("detail", fdetail);
		commandMap.put("filelist", filelist);
		return commandMap;
	}
	
	


}
