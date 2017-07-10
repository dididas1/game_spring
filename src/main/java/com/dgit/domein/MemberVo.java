package com.dgit.domein;

import java.util.Date;

public class MemberVo {
	private String id;
	private String password;
	private String name;
	private String email;
	private String phone;
	private int old;
	private Date regdate;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getOld() {
		return old;
	}
	public void setOld(int old) {
		this.old = old;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	@Override
	public String toString() {
		return "MemberVo [id=" + id + ", password=" + password + ", name=" + name + ", email=" + email + ", phone="
				+ phone + ", old=" + old + ", regdate=" + regdate + "]";
	}

	
	

}
