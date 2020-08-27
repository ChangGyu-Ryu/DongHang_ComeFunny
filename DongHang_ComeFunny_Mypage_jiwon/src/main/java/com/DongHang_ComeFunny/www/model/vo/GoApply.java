package com.DongHang_ComeFunny.www.model.vo;

public class GoApply {
	private int gaNo;
	private int gaGbNo;
	private int gaUNo;
	private int gaStatus;
	private GoBoard goboard;
	private String dacategory;
	
	

	
	@Override
	public String toString() {
		return "GoApply [gaNo=" + gaNo + ", gaGbNo=" + gaGbNo + ", gaUNo=" + gaUNo + ", gaStatus=" + gaStatus
				+ ", goboard=" + goboard + ", dacategory=" + dacategory + "]";
	}
	public int getGaNo() {
		return gaNo;
	}
	public void setGaNo(int gaNo) {
		this.gaNo = gaNo;
	}
	public int getGaGbNo() {
		return gaGbNo;
	}
	public void setGaGbNo(int gaGbNo) {
		this.gaGbNo = gaGbNo;
	}
	public int getGaUNo() {
		return gaUNo;
	}
	public void setGaUNo(int gaUNo) {
		this.gaUNo = gaUNo;
	}
	public int getGaStatus() {
		return gaStatus;
	}
	public void setGaStatus(int gaStatus) {
		this.gaStatus = gaStatus;
	}
	public GoBoard getGoboard() {
		return goboard;
	}
	public void setGoboard(GoBoard goboard) {
		this.goboard = goboard;
	}
	public String getDacategory() {
		return dacategory;
	}
	public void setDacategory(String dacategory) {
		this.dacategory = dacategory;
	}
	
	
}
