package com.erounsystems.blogSearch.biz.vo;

import java.time.ZonedDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
public class KakaoBlogDocuments {
	
	private String title;
	private String contents;
	private String url;
	private String blogname;
	private String thumbnail;
	private String datetime;

}
