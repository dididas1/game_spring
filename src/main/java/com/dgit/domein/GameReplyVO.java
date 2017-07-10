package com.dgit.domein;

import java.util.Date;

public class GameReplyVO {
	private int cNo;
	private int gNo;
	private String id;
	private String content;
	private Date regDate;
	private Date modiDate;
	public int getcNo() {
		return cNo;
	}
	public void setcNo(int cNo) {
		this.cNo = cNo;
	}
	public int getgNo() {
		return gNo;
	}
	public void setgNo(int gNo) {
		this.gNo = gNo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public Date getModiDate() {
		return modiDate;
	}
	public void setModiDate(Date modiDate) {
		this.modiDate = modiDate;
	}
	@Override
	public String toString() {
		return "GameReplyVO [cNo=" + cNo + ", gNo=" + gNo + ", id=" + id + ", content=" + content + ", regDate="
				+ regDate + ", modiDate=" + modiDate + "]";
	}
	
	

}
