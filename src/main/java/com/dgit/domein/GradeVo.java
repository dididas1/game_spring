package com.dgit.domein;

public class GradeVo {
	private int rateNo;
	private int gNo;
	private String id;
	private int good;
	private int bad;
	private int rate;
	public int getRateNo() {
		return rateNo;
	}
	public void setRateNo(int rateNo) {
		this.rateNo = rateNo;
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
	public int getGood() {
		return good;
	}
	public void setGood(int good) {
		this.good = good;
	}
	public int getBad() {
		return bad;
	}
	public void setBad(int bad) {
		this.bad = bad;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	@Override
	public String toString() {
		return "GradeVo [rateNo=" + rateNo + ", gNo=" + gNo + ", id=" + id + ", good=" + good + ", bad=" + bad
				+ ", rate=" + rate +  "]";
	}
	
	
	

}
