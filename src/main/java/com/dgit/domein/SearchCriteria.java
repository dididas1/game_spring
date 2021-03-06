package com.dgit.domein;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class SearchCriteria extends Criteria{
	private String searchType;
	private String keyword;
	
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	@Override
	public String toString() {
		return "SearchCriteria [searchType=" + searchType + ", keyword=" + keyword + "]";
	}
	
	public String makeSearch(int page){
		UriComponents uri = UriComponentsBuilder.newInstance()
							.queryParam("page", page)
							.queryParam("perPageNum", getPerPageNum())
							.queryParam("searchType", getSearchType())
							.queryParam("keyword",getKeyword())
							.build();
		return uri.toString();
	}
	
	
	
}
