package com.DongHang_ComeFunny.www.model.vo;

import java.util.Date;

public class DoBoard {
	private int dbNo;
	private int dbUNo;
	private String dbTitle;
	private String dbContent;
	private Date dbWrittenDate;
	private int dbLikeCnt;
	private int dbIsDel;
	private String dbRecruitDate;
	private String dbRecruitArea;
	private int dbRecruitStatus;
	private int dbRecruitNumber;
	private int dbRecruitGender;
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
