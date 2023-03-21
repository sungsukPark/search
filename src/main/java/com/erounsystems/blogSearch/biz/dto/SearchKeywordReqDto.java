package com.erounsystems.blogSearch.biz.dto;

import com.erounsystems.blogSearch.biz.entity.TpSearchKeyword;

import lombok.Getter;

@Getter
public class SearchKeywordReqDto {

	private String keyword;
	
	private Integer searchCnt;	
	
	public SearchKeywordReqDto(String keyword, Integer searchCnt) {
		this.keyword = keyword;
		this.searchCnt = searchCnt;
	}
	
	public TpSearchKeyword toEntity() {
		return TpSearchKeyword.builder().keyword(keyword).searchCnt(searchCnt).build();
	}
}
