package com.DongHang_ComeFunny.www.model.vo;

public class Order {
	private int pONo;
	private int oUNo;
	private int oPNo;
	private String oPayDate;
	private String oName;
	private int oQunatity;
	private int oPrice;
	private int isDelete;
	
	
	@Override
	public String toString() {
		return "Order [pONo=" + pONo + ", oUNo=" + oUNo + ", oPNo=" + oPNo + ", oPayDate=" + oPayDate + ", oName="
				+ oName + ", oQunatity=" + oQunatity + ", oPrice=" + oPrice + ", isDelete=" + isDelete + "]";
	}
	public int getisDelete() {
		return isDelete;
	}
	public void setisDelete(int isDelete) {
		this.isDelete = isDelete;
	}
	public int getoPrice() {
		return oPrice;
	}
	public void setoPrice(int oPrice) {
		this.oPrice = oPrice;
	}
	
	public int getpONo() {
		return pONo;
	}
	public void setpONo(int pONo) {
		this.pONo = pONo;
	}
	public int getoUNo() {
		return oUNo;
	}
	public void setoUNo(int oUNo) {
		this.oUNo = oUNo;
	}
	public int getoPNo() {
		return oPNo;
	}
	public void setoPNo(int oPNo) {
		this.oPNo = oPNo;
	}
	public String getoPayDate() {
		return oPayDate;
	}
	public void setoPayDate(String oPayDate) {
		this.oPayDate = oPayDate;
	}
	public String getoName() {
		return oName;
	}
	public void setoName(String oName) {
		this.oName = oName;
	}
	public int getoQunatity() {
		return oQunatity;
	}
	public void setoQunatity(int oQunatity) {
		this.oQunatity = oQunatity;
	}
	
	
	
	
	
	

}
