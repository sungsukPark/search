package com.erounsystems.blogSearch.exception;



import com.erounsystems.blogSearch.common.enums.ErrorCode;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CustomException extends RuntimeException {
    private final ErrorCode errorCode;
}