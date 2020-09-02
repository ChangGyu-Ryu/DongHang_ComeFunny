package com.DongHang_ComeFunny.www.controller.admin;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.DongHang_ComeFunny.www.model.service.admin.AdminFreeBoardService;

@Controller
@RequestMapping("/admin/boards/freeBoard")
public class AdminFreeBoardController {
	
	@Autowired
	AdminFreeBoardService adminFreeBoardService;
	
	@RequestMapping("/list")
	public ModelAndView viewFreeBoardList (	String searchKinds,
											String searchText,
											@RequestParam(required = false, defaultValue = "1")int cPage) {
		
		ModelAndView mav = new ModelAndView();
		int cntPerPage = 10;
		
		Map<String,Object> searchFreeBoard = new HashMap<>();
		
		searchFreeBoard.put("searchKinds", searchKinds);
		searchFreeBoard.put("searchText", searchText);
		Map<String,Object> freeBoardList = adminFreeBoardService.viewFreeBoardList(cPage, cntPerPage, searchFreeBoard);

		mav.addObject("paging",freeBoardList.get("paging"));
		mav.addObject("freeBoardData", freeBoardList);
		mav.addObject("searchKinds", searchKinds);
		mav.addObject("searchText", searchText);
		mav.setViewName("admin/boards/freeBoard/list");
		return mav;
	}
	
		@RequestMapping("/delete")
		public ModelAndView deleteFreeBoard(String[] fbNo) {
			
			ModelAndView mav = new ModelAndView();
					
					if(fbNo != null) {
						adminFreeBoardService.deleteFreeBoard(fbNo);
						mav.setViewName("redirect:/admin/boards/freeBoard/list");
						return mav; 
					}else {
						mav.setViewName("redirect:/admin/boards/freeBoard/list");
						return mav;
					}
		}
		
		@RequestMapping(value = "/view", method = RequestMethod.GET)
		public ModelAndView freeView(int fbNo
			) {
			ModelAndView mav = new ModelAndView();
			Map<String, Object> commandMap = adminFreeBoardService.viewtFreeBoard(fbNo);
			
			//---------------- Service에서 처리한 데이터값 출력-------------------------
			System.out.println("[controller] freeview - commandMap : " + commandMap);
			//--------------------------------------------------------------------------
			
			// 3. DB에 회원, 자유게시판 테이블을 조회한 결과값이 Not Null
			//   ("detail" : 회원, 자유게시판, "filelist" : 자유게시판, 자유파일 )
			if(commandMap.get("detail") != null) {
				// 4. ModelAndView에 VO 및 View 이름값 넣기 
				mav.addObject("fview", commandMap);
				mav.setViewName("admin/boards/freeBoard/view");
			} else {
				// 5. view페이지 : /WEB-INF/views/common 폴더 안에 result.jsp
				// 5-1. 경고메세지 출력 후 지정된 url로 페이지 이동
				mav.addObject("alertMsg", "해당 게시물이 존재하지 않습니다.");
				mav.addObject("url", "freelist");
				mav.setViewName("common/result");
			}
			// 6. 데이터 처리가 완료된 모델(VO)값과 보여질 페이지(jsp)를 반환한다.
			return mav;
		}
		
		
		// ⑹ 게시글 상세보기 페이지에서 파일 다운로드
		// url : /board/freedownload
		// parameter :
		// HttpServletResponse response - response header 지정하기
		// HttpSession session - 서버에 저장된 파일경로 받기
		// String ofname - 사용자가 올린 파일 이름
		// String rfname - 서버에 저장된 파일 이름
		@RequestMapping(value="/filedownload")
		@ResponseBody
		public FileSystemResource freeDownload(
				HttpServletResponse response
				, HttpSession session
				, String ofname
				, String rfname
				) {
			// 1. 서버에 저장된 업로드 파일경로
			String readFolder = session.getServletContext().getRealPath("/resources/upload");
			
			// ---------------파라미터 값 제대로 불러왔는지 확인-------------------------
			System.out.println("[controller] freeDowonload - readFolder : " + readFolder);
			System.out.println("[controller] freeDowonload - rfname : " +rfname);
			System.out.println("[controller] freeDowonload - ofname : " +ofname);
			// --------------------------------------------------------------------------
			
			// 2. FileSystemResource 객체 생성
			FileSystemResource downFile = new FileSystemResource(readFolder + "/" + rfname);
			
			try {
				//3. response 헤더 설정 + 파일 이름 인코딩
				response.setHeader("Content-Disposition"
						  , "attachment; filename="
						  +URLEncoder.encode(ofname, "UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			// 4. FileSystemResource downFile 값 반환
			return downFile;
		}
		
		@ResponseBody
		@RequestMapping(value = "/getReplyList", method = RequestMethod.POST)
		public List<Map<String,Object>> getReplyList(
				@RequestParam("fbNo") int fbNo) {
			// 1. 파라미터값 Service에 전달 후 int 값 반환
			//    ( 성공 : 1, 실패 : 0 )
			return adminFreeBoardService.viewFreeCommentList(fbNo);
		}
		
	

}
