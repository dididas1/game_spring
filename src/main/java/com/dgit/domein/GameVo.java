package com.dgit.domein;

import java.util.Arrays;

public class GameVo {
	private int gNo;
	private String title;
	private String gComp;
	private String category;
	private int saleYear;
	private String gContent;
	private int salePrice;
	private int discount;
	private boolean isSale;
	private String start;
	private String platform;
	private int downcnt;
	private String titleImg;
	private String[] gPath;
	private String[] sPath;
	
	
	public int getgNo() {
		return gNo;
	}
	public void setgNo(int gNo) {
		this.gNo = gNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getgComp() {
		return gComp;
	}
	public void setgComp(String gComp) {
		this.gComp = gComp;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getgContent() {
		return gContent;
	}
	public void setgContent(String gContent) {
		this.gContent = gContent;
	}
	public int getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(int salePrice) {
		this.salePrice = salePrice;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public boolean isSale() {
		return isSale;
	}
	public void setSale(boolean isSale) {
		this.isSale = isSale;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	public int getDowncnt() {
		return downcnt;
	}
	public void setDowncnt(int downcnt) {
		this.downcnt = downcnt;
	}
	public String[] getgPath() {
		return gPath;
	}
	public void setgPath(String[] gPath) {
		this.gPath = gPath;
	}
	public String[] getsPath() {
		return sPath;
	}
	public void setsPath(String[] sPath) {
		this.sPath = sPath;
	}
	public int getSaleYear() {
		return saleYear;
	}
	public void setSaleYear(int saleYear) {
		this.saleYear = saleYear;
	}
	
	
	public String getTitleImg() {
		return titleImg;
	}
	public void setTitleImg(String titleImg) {
		this.titleImg = titleImg;
	}
	@Override
	public String toString() {
		return "GameVo [gNo=" + gNo + ", title=" + title + ", gComp=" + gComp + ", category=" + category + ", saleYear="
				+ saleYear + ", gContent=" + gContent + ", salePrice=" + salePrice + ", discount=" + discount
				+ ", isSale=" + isSale + ", start=" + start + ", platform=" + platform + ", downcnt=" + downcnt
				+ ", titleImg=" + titleImg + ", gPath=" + Arrays.toString(gPath) + ", sPath=" + Arrays.toString(sPath)
				+ "]";
	}
	
	
}
