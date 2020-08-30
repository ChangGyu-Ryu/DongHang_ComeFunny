package com.DongHang_ComeFunny.www.model.vo;

import java.util.Date;

public class GoBoard {
	private int gbNo;
	private int gbUNo;
	private String gbTitle;
	private String gbContent;
	private Date gbWrittenDate;
	private int gbLikeCnt;
	private int gbIsDel;
	private String gbRecruitDate;
	private String gbRecruitArea;
	private int gbRecruitStatus;
	private int gbRecruitNumber;
	private int gbRecruitGender;
	private int gbDhstarAvg;
	private int gbHoststarAvg;
	private int gbStarCnt;
	private String gbCateGory;
	
	@Override
	public String toString() {
		return "GoBoard [gbNo=" + gbNo + ", gbUNo=" + gbUNo + ", gbTitle=" + gbTitle + ", gbContent=" + gbContent
				+ ", gbWrittenDate=" + gbWrittenDate + ", gbLikeCnt=" + gbLikeCnt + ", gbIsDel=" + gbIsDel
				+ ", gbRecruitDate=" + gbRecruitDate + ", gbRecruitArea=" + gbRecruitArea + ", gbRecruitStatus="
				+ gbRecruitStatus + ", gbRecruitNumber=" + gbRecruitNumber + ", gbRecruitGender=" + gbRecruitGender
				+ ", gbDhstarAvg=" + gbDhstarAvg + ", gbHoststarAvg=" + gbHoststarAvg + ", gbStarCnt=" + gbStarCnt
				+ ", gbCateGory=" + gbCateGory + "]";
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

	public int getGbDhstarAvg() {
		return gbDhstarAvg;
	}

	public void setGbDhstarAvg(int gbDhstarAvg) {
		this.gbDhstarAvg = gbDhstarAvg;
	}

	public int getGbHoststarAvg() {
		return gbHoststarAvg;
	}

	public void setGbHoststarAvg(int gbHoststarAvg) {
		this.gbHoststarAvg = gbHoststarAvg;
	}

	public int getGbStarCnt() {
		return gbStarCnt;
	}

	public void setGbStarCnt(int gbStarCnt) {
		this.gbStarCnt = gbStarCnt;
	}

	public String getGbCateGory() {
		return gbCateGory;
	}

	public void setGbCateGory(String gbCateGory) {
		this.gbCateGory = gbCateGory;
	}
	
	
	
	

}