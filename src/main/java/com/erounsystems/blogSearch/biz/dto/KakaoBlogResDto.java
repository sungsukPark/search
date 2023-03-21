package com.erounsystems.blogSearch.biz.dto;

import java.io.Serializable;
import java.util.List;

import com.erounsystems.blogSearch.biz.vo.KakaoBlogDocuments;
import com.erounsystems.blogSearch.biz.vo.KakaoBlogMeta;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
public class KakaoBlogResDto  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private KakaoBlogMeta meta;
    private List<KakaoBlogDocuments> documents;

    public KakaoBlogResDto(KakaoBlogMeta meta, List<KakaoBlogDocuments> documents){
    	this.meta = meta;
    	this.documents = documents;
    	
    }
}