package com.DongHang_ComeFunny.www.model.vo;

public class AnswerFile {
	private int afNo;
	private String afAbNo;
	private String afOriginFileName;
	private int afStoredFileName;
	private String afSize;
	private int afSavePath;
	private int afIsDel;
	@Override
	public String toString() {
		return "AnswerFile [afNo=" + afNo + ", afAbNo=" + afAbNo + ", afOriginFileName=" + afOriginFileName
				+ ", afStoredFileName=" + afStoredFileName + ", afSize=" + afSize + ", afSavePath=" + afSavePath
				+ ", afIsDel=" + afIsDel + "]";
	}
	public int getAfNo() {
		return afNo;
	}
	public void setAfNo(int afNo) {
		this.afNo = afNo;
	}
	public String getAfAbNo() {
		return afAbNo;
	}
	public void setAfAbNo(String afAbNo) {
		this.afAbNo = afAbNo;
	}
	public String getAfOriginFileName() {
		return afOriginFileName;
	}
	public void setAfOriginFileName(String afOriginFileName) {
		this.afOriginFileName = afOriginFileName;
	}
	public int getAfStoredFileName() {
		return afStoredFileName;
	}
	public void setAfStoredFileName(int afStoredFileName) {
		this.afStoredFileName = afStoredFileName;
	}
	public String getAfSize() {
		return afSize;
	}
	public void setAfSize(String afSize) {
		this.afSize = afSize;
	}
	public int getAfSavePath() {
		return afSavePath;
	}
	public void setAfSavePath(int afSavePath) {
		this.afSavePath = afSavePath;
	}
	public int getAfIsDel() {
		return afIsDel;
	}
	public void setAfIsDel(int afIsDel) {
		this.afIsDel = afIsDel;
	}
	
	

}
