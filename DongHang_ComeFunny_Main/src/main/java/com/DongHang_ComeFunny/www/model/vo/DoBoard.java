package com.DongHang_ComeFunny.www.model.vo;

import java.util.Date;

public class DoBoard {
	private int dbNo; //함께해요 게시글번호
	private int dbUNo; //함께해요게시글작성자번호
	private String dbTitle; //게시글제목
	private String dbContent; //게시글내용
	private Date dbWrittenDate; //게시글작성날짜
	private int dbLikeCnt; //게시글찜수
	private int dbIsDel; //게시글삭제여부
	private String dbRecruitDate; //모집날짜
	private String dbRecruitArea; //모집지역
	private int dbRecruitStatus; //모집상태
	private int dbRecruitNumber; //모집인원수
	private int dbRecruitGender; //모집성별
	@Override
	public String toString() {
		return "DoBoard [dbNo=" + dbNo + ", dbUNo=" + dbUNo + ", dbTitle=" + dbTitle + ", dbContent=" + dbContent
				+ ", dbWrittenDate=" + dbWrittenDate + ", dbLikeCnt=" + dbLikeCnt + ", dbIsDel=" + dbIsDel
				+ ", dbRecruitDate=" + dbRecruitDate + ", dbRecruitArea=" + dbRecruitArea + ", dbRecruitStatus="
				+ dbRecruitStatus + ", dbRecruitNumber=" + dbRecruitNumber + ", dbRecruitGender=" + dbRecruitGender
				+ "]";
	}
	public int getDbNo() {
		return dbNo;
	}
	public void setDbNo(int dbNo) {
		this.dbNo = dbNo;
	}
	public int getDbUNo() {
		return dbUNo;
	}
	public void setDbUNo(int dbUNo) {
		this.dbUNo = dbUNo;
	}
	public String getDbTitle() {
		return dbTitle;
	}
	public void setDbTitle(String dbTitle) {
		this.dbTitle = dbTitle;
	}
	public String getDbContent() {
		return dbContent;
	}
	public void setDbContent(String dbContent) {
		this.dbContent = dbContent;
	}
	public Date getDbWrittenDate() {
		return dbWrittenDate;
	}
	public void setDbWrittenDate(Date dbWrittenDate) {
		this.dbWrittenDate = dbWrittenDate;
	}
	public int getDbLikeCnt() {
		return dbLikeCnt;
	}
	public void setDbLikeCnt(int dbLikeCnt) {
		this.dbLikeCnt = dbLikeCnt;
	}
	public int getDbIsDel() {
		return dbIsDel;
	}
	public void setDbIsDel(int dbIsDel) {
		this.dbIsDel = dbIsDel;
	}
	public String getDbRecruitDate() {
		return dbRecruitDate;
	}
	public void setDbRecruitDate(String dbRecruitDate) {
		this.dbRecruitDate = dbRecruitDate;
	}
	public String getDbRecruitArea() {
		return dbRecruitArea;
	}
	public void setDbRecruitArea(String dbRecruitArea) {
		this.dbRecruitArea = dbRecruitArea;
	}
	public int getDbRecruitStatus() {
		return dbRecruitStatus;
	}
	public void setDbRecruitStatus(int dbRecruitStatus) {
		this.dbRecruitStatus = dbRecruitStatus;
	}
	public int getDbRecruitNumber() {
		return dbRecruitNumber;
	}
	public void setDbRecruitNumber(int dbRecruitNumber) {
		this.dbRecruitNumber = dbRecruitNumber;
	}
	public int getDbRecruitGender() {
		return dbRecruitGender;
	}
	public void setDbRecruitGender(int dbRecruitGender) {
		this.dbRecruitGender = dbRecruitGender;
	}
	
	

}
