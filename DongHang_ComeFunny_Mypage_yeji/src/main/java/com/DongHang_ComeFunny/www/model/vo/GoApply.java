package com.DongHang_ComeFunny.www.model.vo;

public class GoApply {
	private int gaNo;
	private int gaGbNo;
	private int gaUNo;
	private int gaStatus;
	@Override
	public String toString() {
		return "GoApply [gaNo=" + gaNo + ", gaGbNo=" + gaGbNo + ", gaUNo=" + gaUNo + ", gaStatus=" + gaStatus + "]";
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
	
	
}
