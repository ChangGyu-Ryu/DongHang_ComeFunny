package com.DongHang_ComeFunny.www.board.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.DongHang_ComeFunny.www.board.model.vo.FreeBoard;

import common.exception.FileException;

public interface FreeBoardService {
	
	/**
	 * 게시글 작성(파일업로드 포함)
	 * @param free
	 * @param files
	 * @param root
	 * @return
	 * @throws FileException
	 */
	public int insertFree(
			//Controller가 보내준
			//사용자가 등록한 파일 정보를 가지고 있는 리스트
			FreeBoard free
			, List<MultipartFile> files
			, String root
			) throws FileException;
	
	/**
	 * 게시글 리스트 조회(페이지네이션 포함)
	 * @param cPage
	 * @param cntPerPage
	 * @return
	 */
	public Map<String, Object> selectFreeList(int cPage, int cntPerPage);

	public Map<String, Object> selectFreeView(int fbno);

	public int deleteFreeFile(int ffno);

	public int updateFreeModify(FreeBoard freeboard, List<MultipartFile> files, String root) throws FileException;

	public int deleteFreeBoard(int fbno);

	public int insertFreeComment(int fbno);

	
	
}
