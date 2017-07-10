package com.dgit.domein;

import java.util.Date;

public class ReplyVo {
	private int rno;
	private int bno;
	private String id;
	private String rContent;
	private Date regDate;
	private Date modiDate;
	
	
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getrContent() {
		return rContent;
	}
	public void setrContent(String rContent) {
		this.rContent = rContent;
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
		return "ReplyVo [rno=" + rno + ", bno=" + bno + ", id=" + id + ", rContent=" + rContent + ", regDate=" + regDate
				+ ", modiDate=" + modiDate + "]";
	}

	
	

}
