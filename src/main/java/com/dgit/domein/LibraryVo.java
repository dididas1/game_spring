package com.dgit.domein;

public class LibraryVo {
	private int libNo;
	private int gNo;
	private String id;
	private boolean isBuy;
	public int getLibNo() {
		return libNo;
	}
	public void setLibNo(int libNo) {
		this.libNo = libNo;
	}
	public int getgNo() {
		return gNo;
	}
	public void setgNo(int gNo) {
		this.gNo = gNo;
	}
	public boolean isBuy() {
		return isBuy;
	}
	public void setBuy(boolean isBuy) {
		this.isBuy = isBuy;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "LibraryVo [libNo=" + libNo + ", gNo=" + gNo + ", id=" + id + ", isBuy=" + isBuy + "]";
	}
	
}
