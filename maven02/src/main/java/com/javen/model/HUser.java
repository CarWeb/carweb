package com.javen.model;

public class HUser {
	
	private Integer id;
	private String acc;
	private String pwd;
	private Integer tel;
	private Integer admin;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getAcc() {
		return acc;
	}
	public void setAcc(String acc) {
		this.acc = acc;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Integer getTel() {
		return tel;
	}
	public void setTel(Integer tel) {
		this.tel = tel;
	}
	public Integer getAdmin() {
		return admin;
	}
	public void setAdmin(Integer admin) {
		this.admin = admin;
	}
	@Override
	public String toString() {
		return "HUser [id=" + id + ", acc=" + acc + ", pwd=" + pwd + ", tel=" + tel + ", admin=" + admin + "]";
	}
	

	
}
