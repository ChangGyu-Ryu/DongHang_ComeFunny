package com.DongHang_ComeFunny.www.board.model.vo;

public class FreeBoard {
	
	private int fbno;
	private int fbuno;
	private String fbtitle;
	private String fbcontent;
	private String fbwrittendate;
	private int fbhitscnt;
	private int fbisdelete;
	
	@Override
	public String toString() {
		return "FreeBoard [fbno=" + fbno + ", fbuno=" + fbuno + ", fbtitle=" + fbtitle + ", fbcontent=" + fbcontent
				+ ", fbwrittendate=" + fbwrittendate + ", fbhitscnt=" + fbhitscnt + ", fbisdelete=" + fbisdelete + "]";
	}
	
	public int getFbno() {
		return fbno;
	}
	public void setFbno(int fbno) {
		this.fbno = fbno;
	}
	public int getFbuno() {
		return fbuno;
	}
	public void setFbuno(int fbuno) {
		this.fbuno = fbuno;
	}
	public String getFbtitle() {
		return fbtitle;
	}
	public void setFbtitle(String fbtitle) {
		this.fbtitle = fbtitle;
	}
	public String getFbcontent() {
		return fbcontent;
	}
	public void setFbcontent(String fbcontent) {
		this.fbcontent = fbcontent;
	}
	public String getFbwrittendate() {
		return fbwrittendate;
	}
	public void setFbwrittendate(String fbwrittendate) {
		this.fbwrittendate = fbwrittendate;
	}
	public int getFbhitscnt() {
		return fbhitscnt;
	}
	public void setFbhitscnt(int fbhitscnt) {
		this.fbhitscnt = fbhitscnt;
	}
	public int getFbisdelete() {
		return fbisdelete;
	}
	public void setFbisdelete(int fbisdelete) {
		this.fbisdelete = fbisdelete;
	}
	
	
	
	
	
}
