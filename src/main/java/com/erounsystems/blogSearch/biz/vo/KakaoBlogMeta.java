package com.erounsystems.blogSearch.biz.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
public class KakaoBlogMeta {
	private Integer total_count;
	private Integer pageable_count;
	private Boolean is_end;

}
