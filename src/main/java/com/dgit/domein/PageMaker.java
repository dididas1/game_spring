package com.dgit.domein;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class PageMaker {
	private int totalCount; //전체 게시물겟구
	private int startPage; //시작페이지 번호
	private int endPage;	// 끝페이지번호
	private boolean prev;	//이전페이지 존재여부
	private boolean next;	//다음페이지존재여부
	private int displayPageNum=10; //화면에 보일 페이지 번호의 총갯수

	private Criteria criteria;

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		calcDate();
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getDisplayPageNum() {
		return displayPageNum;
	}

	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}

	public Criteria getCriteria() {
		return criteria;
	}

	public void setCriteria(Criteria criteria) {
		this.criteria = criteria;
	}
	
	public void calcDate(){
		endPage=(int) (Math.ceil(criteria.getPage() /(double) displayPageNum) * displayPageNum);
		
		startPage=(endPage- displayPageNum)+1;
		
		int tempEndPage=(int) Math.ceil(totalCount/(double)criteria.getPerPageNum());
		
		if(endPage>tempEndPage)
			endPage=tempEndPage;
		
		if(startPage==1){
			prev=false;
		}else{
			prev=true;
		}
		
		if(endPage*criteria.getPerPageNum()>=totalCount){
			next=false;
		}else{
			next=true;
		}
	}
	
	@Override
	public String toString() {
		return "PageMaker [totalCount=" + totalCount + ", startPage=" + startPage + ", endPage=" + endPage + ", prev="
				+ prev + ", next=" + next + ", displayPageNum=" + displayPageNum + ", criteria=" + criteria + "]";
	}
	
	
	

}
