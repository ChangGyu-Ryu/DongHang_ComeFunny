package com.DongHang_ComeFunny.www.user.model.vo;

import java.sql.Date;

public class User {
	private int uno;
	private String userid;
	private String upw;
	private String uname;
	private String ubirth;
	private int ugender;
	private String unick;
	private String uphone;
	private String umail;
	private String uaddress;
	private int udhtcnt;
	private Date uregdate;
	private String salt;
	
	public User() { }

	@Override
	public String toString() {
		return "User [uno=" + uno + ", userid=" + userid + ", upw=" + upw + ", uname=" + uname + ", ubirth=" + ubirth
				+ ", ugender=" + ugender + ", unick=" + unick + ", uphone=" + uphone + ", umail=" + umail
				+ ", uaddress=" + uaddress + ", udhtcnt=" + udhtcnt + ", uregdate=" + uregdate + ", salt=" + salt
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

	public int getUno() {
		return uno;
	}

	public void setUno(int uno) {
		this.uno = uno;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUpw() {
		return upw;
	}

	public void setUpw(String upw) {
		this.upw = upw;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUbirth() {
		return ubirth;
	}

	public void setUbirth(String ubirth) {
		this.ubirth = ubirth;
	}

	public int getUgender() {
		return ugender;
	}

	public void setUgender(int ugender) {
		this.ugender = ugender;
	}

	public String getUnick() {
		return unick;
	}

	public void setUnick(String unick) {
		this.unick = unick;
	}

	public String getUphone() {
		return uphone;
	}

	public void setUphone(String uphone) {
		this.uphone = uphone;
	}

	public String getUmail() {
		return umail;
	}

	public void setUmail(String umail) {
		this.umail = umail;
	}

	public String getUaddress() {
		return uaddress;
	}

	public void setUaddress(String uaddress) {
		this.uaddress = uaddress;
	}

	public int getUdhtcnt() {
		return udhtcnt;
	}

	public void setUdhtcnt(int udhtcnt) {
		this.udhtcnt = udhtcnt;
	}

	public Date getUregdate() {
		return uregdate;
	}

	public void setUregdate(Date uregdate) {
		this.uregdate = uregdate;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}


	
	
}