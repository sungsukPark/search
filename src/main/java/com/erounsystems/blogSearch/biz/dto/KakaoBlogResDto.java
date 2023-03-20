package com.erounsystems.blogSearch.biz.dto;

import java.io.Serializable;
import java.util.List;

import com.erounsystems.blogSearch.biz.vo.KakaoBlogDocuments;
import com.erounsystems.blogSearch.biz.vo.KakaoBlogMeta;

import lombok.Data;


@Data
public class KakaoBlogResDto  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private KakaoBlogMeta meta;
    private List<KakaoBlogDocuments> documents;

}