package com.erounsystems.blogSearch.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorDto {
	private Integer status;
	private String Message;

}
