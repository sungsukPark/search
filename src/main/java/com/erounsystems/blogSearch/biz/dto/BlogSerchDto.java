package com.erounsystems.blogSearch.biz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BlogSerchDto {

	private Integer code;
	private String message;
	
	private KakaoBlogResDto kakaoResDto;
}
