package com.DongHang_ComeFunny.www.model.vo;

import java.util.Date;

public class AnswerBoard {
	private int abNo;
	private int abUno;
	private int abObNo;
	private String abTitle;
	private String abContent;
	private Date abWrittenDate;
	private int  abIsDel;
	@Override
	public String toString() {
		return "AnswerBoard [abNo=" + abNo + ", abUno=" + abUno + ", abObNo=" + abObNo + ", abTitle=" + abTitle
				+ ", abContent=" + abContent + ", abWrittenDate=" + abWrittenDate + ", abIsDel=" + abIsDel + "]";
	}
	public int getAbNo() {
		return abNo;
	}
	public void setAbNo(int abNo) {
		this.abNo = abNo;
	}
	public int getAbUno() {
		return abUno;
	}
	public void setAbUno(int abUno) {
		this.abUno = abUno;
	}
	public int getAbObNo() {
		return abObNo;
	}
	public void setAbObNo(int abObNo) {
		this.abObNo = abObNo;
	}
	public String getAbTitle() {
		return abTitle;
	}
	public void setAbTitle(String abTitle) {
		this.abTitle = abTitle;
	}
	public String getAbContent() {
		return abContent;
	}
	public void setAbContent(String abContent) {
		this.abContent = abContent;
	}
	public Date getAbWrittenDate() {
		return abWrittenDate;
	}
	public void setAbWrittenDate(Date abWrittenDate) {
		this.abWrittenDate = abWrittenDate;
	}
	public int getAbIsDel() {
		return abIsDel;
	}
	public void setAbIsDel(int abIsDel) {
		this.abIsDel = abIsDel;
	}
	
	

}