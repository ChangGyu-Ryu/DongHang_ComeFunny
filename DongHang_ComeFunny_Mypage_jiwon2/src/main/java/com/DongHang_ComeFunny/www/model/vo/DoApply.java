package com.DongHang_ComeFunny.www.model.vo;

public class DoApply {
	private int daNo;
	private int daDbNo;
	private int daUNo;
	private int daStatus;
	@Override
	public String toString() {
		return "DoApply [daNo=" + daNo + ", daDbNo=" + daDbNo + ", daUNo=" + daUNo + ", daStatus=" + daStatus + "]";
	}
	public int getDaNo() {
		return daNo;
	}
	public void setDaNo(int daNo) {
		this.daNo = daNo;
	}
	public int getDaDbNo() {
		return daDbNo;
	}
	public void setDaDbNo(int daDbNo) {
		this.daDbNo = daDbNo;
	}
	public int getDaUNo() {
		return daUNo;
	}
	public void setDaUNo(int daUNo) {
		this.daUNo = daUNo;
	}
	public int getDaStatus() {
		return daStatus;
	}
	public void setDaStatus(int daStatus) {
		this.daStatus = daStatus;
	}
	
	

}
