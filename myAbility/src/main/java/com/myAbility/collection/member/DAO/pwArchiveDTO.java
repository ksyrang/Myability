package com.myAbility.collection.member.DAO;

import com.myAbility.collection.login.DAO.loginDTO;

public class pwArchiveDTO extends loginDTO {
	
	private String pw1;
	private String pw2;
	private String pw3;
	private int count;
	
	
	public pwArchiveDTO() {
		this.count = 0;
		this.pw1 = "";
		this.pw2 = "";
		this.pw3 = "";
	}

	
	public String getPw1() {
		return pw1;
	}
	public void setPw1(String pw1) {
		this.pw1 = pw1;
	}
	public String getPw2() {
		return pw2;
	}
	public void setPw2(String pw2) {
		this.pw2 = pw2;
	}
	public String getPw3() {
		return pw3;
	}
	public void setPw3(String pw3) {
		this.pw3 = pw3;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
}
