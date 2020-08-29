package com.DongHang_ComeFunny.www.model.vo;

public class PayMent {
	private int pNo;
	private int pONo;
	private int pUNo;
	private String pName;
	private int pPrice;
	private int pTotalPrice;
	private int pNonTaxablePrice;
	@Override
	public String toString() {
		return "PayMent [pNo=" + pNo + ", pONo=" + pONo + ", pUNo=" + pUNo + ", pName=" + pName + ", pPrice=" + pPrice
				+ ", pTotalPrice=" + pTotalPrice + ", pNonTaxablePrice=" + pNonTaxablePrice + "]";
	}
	public int getpNo() {
		return pNo;
	}
	public void setpNo(int pNo) {
		this.pNo = pNo;
	}
	public int getpONo() {
		return pONo;
	}
	public void setpONo(int pONo) {
		this.pONo = pONo;
	}
	public int getpUNo() {
		return pUNo;
	}
	public void setpUNo(int pUNo) {
		this.pUNo = pUNo;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public int getpPrice() {
		return pPrice;
	}
	public void setpPrice(int pPrice) {
		this.pPrice = pPrice;
	}
	public int getpTotalPrice() {
		return pTotalPrice;
	}
	public void setpTotalPrice(int pTotalPrice) {
		this.pTotalPrice = pTotalPrice;
	}
	public int getpNonTaxablePrice() {
		return pNonTaxablePrice;
	}
	public void setpNonTaxablePrice(int pNonTaxablePrice) {
		this.pNonTaxablePrice = pNonTaxablePrice;
	}
	
	
	

}
