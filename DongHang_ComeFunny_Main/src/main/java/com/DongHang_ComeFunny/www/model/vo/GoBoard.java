package com.DongHang_ComeFunny.www.model.vo;

import java.util.Date;

public class GoBoard {
	private int gbNo; //함께가요게시글번호
	private int gbUNo; //함께가요게시글작성자번호
	private String gbTitle; //게시글제목
	private String gbContent; //게시글내용
	private Date gbWrittenDate; //게시글작성일
	private int gbLikeCnt; //게시글찜수
	private int gbIsDel; //게시글삭제여부
	private String gbRecruitDate; //모집날짜
	private String gbRecruitArea; //모집지역
	private int gbRecruitStatus; //모집상태
	private int gbRecruitNumber; //모집인원수
	private int gbRecruitGender; //모집성별
	
	@Override
	public String toString() {
		return "GoBoard [gbNo=" + gbNo + ", gbUNo=" + gbUNo + ", gbTitle=" + gbTitle + ", gbContent=" + gbContent
				+ ", gbWrittenDate=" + gbWrittenDate + ", gbLikeCnt=" + gbLikeCnt + ", gbIsDel=" + gbIsDel
				+ ", gbRecruitDate=" + gbRecruitDate + ", gbRecruitArea=" + gbRecruitArea + ", gbRecruitStatus="
				+ gbRecruitStatus + ", gbRecruitNumber=" + gbRecruitNumber + ", gbRecruitGender=" + gbRecruitGender
				+ "]";
	}
	public int getGbNo() {
		return gbNo;
	}
	public void setGbNo(int gbNo) {
		this.gbNo = gbNo;
	}
	public int getGbUNo() {
		return gbUNo;
	}
	public void setGbUNo(int gbUNo) {
		this.gbUNo = gbUNo;
	}
	public String getGbTitle() {
		return gbTitle;
	}
	public void setGbTitle(String gbTitle) {
		this.gbTitle = gbTitle;
	}
	public String getGbContent() {
		return gbContent;
	}
	public void setGbContent(String gbContent) {
		this.gbContent = gbContent;
	}
	public Date getGbWrittenDate() {
		return gbWrittenDate;
	}
	public void setGbWrittenDate(Date gbWrittenDate) {
		this.gbWrittenDate = gbWrittenDate;
	}
	public int getGbLikeCnt() {
		return gbLikeCnt;
	}
	public void setGbLikeCnt(int gbLikeCnt) {
		this.gbLikeCnt = gbLikeCnt;
	}
	public int getGbIsDel() {
		return gbIsDel;
	}
	public void setGbIsDel(int gbIsDel) {
		this.gbIsDel = gbIsDel;
	}
	public String getGbRecruitDate() {
		return gbRecruitDate;
	}
	public void setGbRecruitDate(String gbRecruitDate) {
		this.gbRecruitDate = gbRecruitDate;
	}
	public String getGbRecruitArea() {
		return gbRecruitArea;
	}
	public void setGbRecruitArea(String gbRecruitArea) {
		this.gbRecruitArea = gbRecruitArea;
	}
	public int getGbRecruitStatus() {
		return gbRecruitStatus;
	}
	public void setGbRecruitStatus(int gbRecruitStatus) {
		this.gbRecruitStatus = gbRecruitStatus;
	}
	public int getGbRecruitNumber() {
		return gbRecruitNumber;
	}
	public void setGbRecruitNumber(int gbRecruitNumber) {
		this.gbRecruitNumber = gbRecruitNumber;
	}
	public int getGbRecruitGender() {
		return gbRecruitGender;
	}
	public void setGbRecruitGender(int gbRecruitGender) {
		this.gbRecruitGender = gbRecruitGender;
	}
	
	

}
