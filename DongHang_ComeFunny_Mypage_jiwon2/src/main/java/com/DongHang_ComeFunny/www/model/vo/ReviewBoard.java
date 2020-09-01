package com.DongHang_ComeFunny.www.model.vo;

import java.sql.Date;

public class ReviewBoard {
	private int rbNo;
	private int rbUNo;
	private String rbTitle;
	private String rbContent;
	private Date rbWrittenDate;
	private int rbRecommendCnt;
	private int rbHitsCnt;
	private int rbLikeCnt;
	private int rbIsDel;
	@Override
	public String toString() {
		return "ReviewBoard [rbNo=" + rbNo + ", rbUNo=" + rbUNo + ", rbTitle=" + rbTitle + ", rbContent=" + rbContent
				+ ", rbWrittenDate=" + rbWrittenDate + ", rbRecommendCnt=" + rbRecommendCnt + ", rbHitsCnt=" + rbHitsCnt
				+ ", rbLikeCnt=" + rbLikeCnt + ", rbIsDel=" + rbIsDel + "]";
	}
	public int getRbNo() {
		return rbNo;
	}
	public void setRbNo(int rbNo) {
		this.rbNo = rbNo;
	}
	public int getRbUNo() {
		return rbUNo;
	}
	public void setRbUNo(int rbUNo) {
		this.rbUNo = rbUNo;
	}
	public String getRbTitle() {
		return rbTitle;
	}
	public void setRbTitle(String rbTitle) {
		this.rbTitle = rbTitle;
	}
	public String getRbContent() {
		return rbContent;
	}
	public void setRbContent(String rbContent) {
		this.rbContent = rbContent;
	}
	public Date getRbWrittenDate() {
		return rbWrittenDate;
	}
	public void setRbWrittenDate(Date rbWrittenDate) {
		this.rbWrittenDate = rbWrittenDate;
	}
	public int getRbRecommendCnt() {
		return rbRecommendCnt;
	}
	public void setRbRecommendCnt(int rbRecommendCnt) {
		this.rbRecommendCnt = rbRecommendCnt;
	}
	public int getRbHitsCnt() {
		return rbHitsCnt;
	}
	public void setRbHitsCnt(int rbHitsCnt) {
		this.rbHitsCnt = rbHitsCnt;
	}
	public int getRbLikeCnt() {
		return rbLikeCnt;
	}
	public void setRbLikeCnt(int rbLikeCnt) {
		this.rbLikeCnt = rbLikeCnt;
	}
	public int getRbIsDel() {
		return rbIsDel;
	}
	public void setRbIsDel(int rbIsDel) {
		this.rbIsDel = rbIsDel;
	}
	
	

}
