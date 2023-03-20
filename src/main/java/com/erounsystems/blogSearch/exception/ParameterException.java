package com.erounsystems.blogSearch.exception;

import com.erounsystems.blogSearch.common.enums.ResponseEnum;

/**
 * Exception
 *
 * @version 8.19.09.17 - Fresh
 */
public class ParameterException extends RuntimeException {

    private String message = ResponseEnum.PARAMETER.getMessage();

    public ParameterException() {
    }

    public ParameterException(String message) {
        this.message = message;
    }

}
