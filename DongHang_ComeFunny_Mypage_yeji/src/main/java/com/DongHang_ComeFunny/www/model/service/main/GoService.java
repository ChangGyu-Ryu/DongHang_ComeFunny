package com.DongHang_ComeFunny.www.model.service.main;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
			
		} else if (filter != null) { //필터 없는 경우
			List<Map<String, Object>> list = goDao.selectGoList(map);
			commandMap.put("glist", list);
			
		} else { //필터가 있는 경우
			Map<String, Object> filterMap = new HashMap<>();
			filterMap.putAll(filter);
			
			List<Map<String,Object>> list = goDao.selectFilterList(filter) ;
			commandMap.put("glist",list);
		}
			
		return commandMap;
	}
	
	//함께가요 상세
	public Map<String, Object> selectGoDetail(int gbNo) {

		//함께가요 상세 글 정보, 작성자 프로필 이미지
		Map<String, Object> goBoardUserInfo =  goDao.selectGoUserInfo(gbNo);
		
		//함께가요 상세 체크박스
		List<GoCheck> goCheck = goDao.selectGocheck(gbNo);
		
		//호스트 평점
		List<Map<String, Object>> hostReview = goDao.selectGoHostReview(gbNo);
		
		//호스트 평점 후기 갯수
		int hostReviewCnt = goDao.selecthostReviewCnt(gbNo);
		
		//함께가요 동행신청 목록
		List<Map<String, Object>> goDhApplylist = goDao.selectgoDhApplylist(gbNo);
		
		
		Map<String,Object> goDetailInfo = new HashMap<String, Object>();
		goDetailInfo.put("goBoardUserInfo", goBoardUserInfo);
		goDetailInfo.put("goCheck", goCheck);
		goDetailInfo.put("hostReview", hostReview);
		goDetailInfo.put("hostReviewCnt", hostReviewCnt);
		goDetailInfo.put("goDhApplylist", goDhApplylist);
		
		
		
				
		return goDetailInfo;
	}
	
	//함께가요 동행 신청하기
	public int insertGoDhApply(int gbNo, int uNo) {
		return goDao.insertGoDhApply(gbNo, uNo);
	}

	
	
}