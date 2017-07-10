package com.dgit.project.model;

import java.util.Date;

public class Project {
	private int pNo;
	private String pName;
	private String pContent;
	private Date startDay;
	private Date endDay;
	private String progress;
	
	public Project() {
	}
	
	

	public Project(int pNo, String pName, String pContent, Date startDay, Date endDay, String progress) {
		super();
		this.pNo = pNo;
		this.pName = pName;
		this.pContent = pContent;
		this.startDay = startDay;
		this.endDay = endDay;
		this.progress = progress;
	}



	public Project(String pName, String pContent, Date startDay, Date endDay, String progress) {
		this.pName = pName;
		this.pContent = pContent;
		this.startDay = startDay;
		this.endDay = endDay;
		this.progress = progress;
	}



	
	public int getpNo() {
		return pNo;
	}

	public void setpNo(int pNo) {
		this.pNo = pNo;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getpContent() {
		return pContent;
	}

	public void setpContent(String pContent) {
		this.pContent = pContent;
	}

	public Date getStartDay() {
		return startDay;
	}

	public void setStartDay(Date startDay) {
		this.startDay = startDay;
	}

	public Date getEndDay() {
		return endDay;
	}

	public void setEndDay(Date endDay) {
		this.endDay = endDay;
	}

	public String getProgress() {
		return progress;
	}

	public void setProgress(String progress) {
		this.progress = progress;
	}
	
	
	
	

}
