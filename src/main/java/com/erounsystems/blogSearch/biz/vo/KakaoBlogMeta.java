package com.erounsystems.blogSearch.biz.vo;

import lombok.Data;

@Data
public class KakaoBlogMeta {
	private Integer total_count;
	private Integer pageable_count;
	private Boolean is_end;

}
