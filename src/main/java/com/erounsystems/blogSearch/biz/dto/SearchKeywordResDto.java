package com.erounsystems.blogSearch.biz.dto;

import com.erounsystems.blogSearch.biz.entity.TpSearchKeyword;

import lombok.Getter;

@Getter
public class SearchKeywordResDto {

	private Long id;

	private String keyword;
	
	private Integer searchCnt;	
	
	public SearchKeywordResDto(TpSearchKeyword entity) {
		this.id = entity.getId();
		this.keyword = entity.getKeyword();
		this.searchCnt = entity.getSearchCnt();
	}
}
