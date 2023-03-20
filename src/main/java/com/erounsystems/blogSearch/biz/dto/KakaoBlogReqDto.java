package com.erounsystems.blogSearch.biz.dto;

import java.io.Serializable;

import com.erounsystems.blogSearch.biz.enums.Sort;

import lombok.Data;

@Data
public class KakaoBlogReqDto implements Serializable{
	private static final long serialVersionUID = 1L;
	private String query;
	//정렬 방식 accuracy(정확도순) , recency(최신순)
	private String sort;
	private Integer page;
	private Integer size;
	
	

}
