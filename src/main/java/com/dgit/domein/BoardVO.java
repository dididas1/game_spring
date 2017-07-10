package com.dgit.domein;

import java.util.Arrays;
import java.util.Date;

public class BoardVO {
	private int bNo;
	private String id;
	private String bTitle;
	private String bContent;
	private int readCount;
	private int replyCount;
	private Date regDate;
	private Date modiDate;
	private String[] userPath;
	
	
	public int getbNo() {
		return bNo;
	}
	public void setbNo(int bNo) {
		this.bNo = bNo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getbTitle() {
		return bTitle;
	}
	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}
	public String getbContent() {
		return bContent;
	}
	public void setbContent(String bContent) {
		this.bContent = bContent;
	}
	public int getReadCount() {
		return readCount;
	}
	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}
	public int getReplyCount() {
		return replyCount;
	}
	public void setReplyCount(int replyCount) {
		this.replyCount = replyCount;
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
	public String[] getUserPath() {
		return userPath;
	}
	public void setUserPath(String[] userPath) {
		this.userPath = userPath;
	}
	
	@Override
	public String toString() {
		return "BoardVO [bNo=" + bNo + ", id=" + id + ", bTitle=" + bTitle + ", bContent=" + bContent + ", readCount="
				+ readCount + ", replyCount=" + replyCount + ", regDate=" + regDate + ", modiDate=" + modiDate
				+ ", userPath=" + Arrays.toString(userPath) + "]";
	}
	

	
	
}
