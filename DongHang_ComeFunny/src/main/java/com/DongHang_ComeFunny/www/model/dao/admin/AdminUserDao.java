package com.DongHang_ComeFunny.www.model.dao.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.DongHang_ComeFunny.www.model.vo.User;
import com.DongHang_ComeFunny.www.model.vo.UserImg;

@Repository
public class AdminUserDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	/**
	 * 전체 회원 수를 데이터베이스에서 조회
	 * @return - 전체 회원의 수
	 */
	public int selectUserCnt(Map<String,Object> searchUser) {
		return sqlSession.selectOne("AdminUser.selectUserCnt", searchUser);
	}
	
	/**
	 * 페이징 처리된 회원을 데이터베이스에서 조회 후 리스트로 반환
	 * @param p - 페이징 처리한 전체 회원의 수 
	 * @return List - 페이징 처리된 회원의 리스트
	 */
//	public List<User> selectUserList(UserPaging p) {
//		return sqlSession.selectList("AdminUser.selectUserList", p);
//		
//	}
	
	/**
	 * 페이징 처리된 회원을 데이터베이스에서 조회 후 리스트로 반환
	 * @param p - 페이징 처리한 검색한 회원의 수
	 * @return List - 페이징 처리된 검색한 회원의 리스트
	 */
	public List<User> selectUserList(Map<String, Object> searchUserMap) {
		return sqlSession.selectList("AdminUser.selectUserList", searchUserMap);
		
	}

	/**
	 * 
	 * @param uNo
	 */
	public void deleteUser(String uNo) {
		sqlSession.delete("AdminUser.deleteUser", uNo);
	}

	public User selectUser(int uNo) {
		return sqlSession.selectOne("AdminUser.selectUserByUNo", uNo);
	}

	public void updateUser(User modiUserInfo) {
		sqlSession.update("AdminUser.updateUser", modiUserInfo );
	}

	public UserImg selectUserImgByUNo(int uNo) {
		return sqlSession.selectOne("AdminUser.selectUserImgByUNo", uNo);
	}

	public void updateUserImg(Map<String, Object> userImg) {
		sqlSession.update("AdminUser.updateUserImg", userImg);		
	}



}
