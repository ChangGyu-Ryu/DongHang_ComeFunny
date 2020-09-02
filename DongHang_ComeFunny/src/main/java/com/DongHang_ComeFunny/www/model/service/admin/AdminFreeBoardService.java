package com.DongHang_ComeFunny.www.model.service.admin;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public interface AdminFreeBoardService {

	Map<String, Object> viewFreeBoardList(int cPage, int cntPerPage, Map<String, Object> searchFreeBoard);

	void deleteFreeBoard(String[] fbNo);

	List<Map<String, Object>> viewFreeCommentList(int fbNo);

	Map<String, Object> viewtFreeBoard(int fbNo);

}
