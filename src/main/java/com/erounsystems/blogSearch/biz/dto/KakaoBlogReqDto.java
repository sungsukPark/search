package com.erounsystems.blogSearch.biz.dto;

import java.io.Serializable;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class KakaoBlogReqDto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@NotBlank(message = "search word must not be null")
	private String query;
	//정렬 방식 accuracy(정확도순) , recency(최신순)
	private String sort;
	
	@Min(1)
	@Max(50)
	private Integer page;
	
	@Min(1)
	@Max(50)
	private Integer size;
	
	

}
