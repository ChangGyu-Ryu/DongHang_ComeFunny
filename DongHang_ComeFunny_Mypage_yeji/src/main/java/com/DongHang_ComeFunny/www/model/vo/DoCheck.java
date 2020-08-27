package com.DongHang_ComeFunny.www.model.vo;

public class DoCheck {
	private int dcNo;
	private int dcDbNo;
	private int dcAgeGroup;
	private int dcTheme;
	@Override
	public String toString() {
		return "DoCheck [dcNo=" + dcNo + ", dcDbNo=" + dcDbNo + ", dcAgeGroup=" + dcAgeGroup + ", dcTheme=" + dcTheme
				+ "]";
	}
	public int getDcNo() {
		return dcNo;
	}
	public void setDcNo(int dcNo) {
		this.dcNo = dcNo;
	}
	public int getDcDbNo() {
		return dcDbNo;
	}
	public void setDcDbNo(int dcDbNo) {
		this.dcDbNo = dcDbNo;
	}
	public int getDcAgeGroup() {
		return dcAgeGroup;
	}
	public void setDcAgeGroup(int dcAgeGroup) {
		this.dcAgeGroup = dcAgeGroup;
	}
	public int getDcTheme() {
		return dcTheme;
	}
	public void setDcTheme(int dcTheme) {
		this.dcTheme = dcTheme;
	}
	
	

}
