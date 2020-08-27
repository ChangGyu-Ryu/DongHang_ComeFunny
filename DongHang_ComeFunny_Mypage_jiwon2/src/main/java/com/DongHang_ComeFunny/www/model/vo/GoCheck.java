package com.DongHang_ComeFunny.www.model.vo;

public class GoCheck {
	private int gcNo;
	private int gcGbNo;
	private int gcAgeGroup;
	private int gcTheme;
	
	@Override
	public String toString() {
		return "GoCheck [gcNo=" + gcNo + ", gcGbNo=" + gcGbNo + ", gcAgeGroup=" + gcAgeGroup + ", gcTheme=" + gcTheme
				+ "]";
	}

	public int getGcNo() {
		return gcNo;
	}

	public void setGcNo(int gcNo) {
		this.gcNo = gcNo;
	}

	public int getGcGbNo() {
		return gcGbNo;
	}

	public void setGcGbNo(int gcGbNo) {
		this.gcGbNo = gcGbNo;
	}

	public int getGcAgeGroup() {
		return gcAgeGroup;
	}

	public void setGcAgeGroup(int gcAgeGroup) {
		this.gcAgeGroup = gcAgeGroup;
	}

	public int getGcTheme() {
		return gcTheme;
	}

	public void setGcTheme(int gcTheme) {
		this.gcTheme = gcTheme;
	}
	
	
	

}
