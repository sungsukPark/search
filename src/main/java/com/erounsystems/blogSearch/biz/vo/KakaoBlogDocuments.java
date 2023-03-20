package com.erounsystems.blogSearch.biz.vo;

import java.time.ZonedDateTime;

import lombok.Data;

@Data
public class KakaoBlogDocuments {
	
	private String title;
	private String contents;
	private String url;
	private String blogname;
	private String thumbnail;
	private ZonedDateTime datetime;

}
