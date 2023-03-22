package com.erounsystems.blogSearch.exception;

import static com.erounsystems.blogSearch.common.enums.ErrorCode.REST_CLIENT_ERROR;
import static com.erounsystems.blogSearch.common.enums.ErrorCode.REST_SERVER_ERROR;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

public class RestTemplateException implements ResponseErrorHandler {
	
    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        HttpStatus statusCode = (HttpStatus) response.getStatusCode();
        return statusCode.is4xxClientError() || statusCode.is5xxServerError();
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        HttpStatus statusCode = (HttpStatus) response.getStatusCode();
        if(statusCode.series() == HttpStatus.Series.SERVER_ERROR) {
        	throw new CustomException(REST_SERVER_ERROR);
        } else if(statusCode.series() == HttpStatus.Series.CLIENT_ERROR) {
            throw new CustomException(REST_CLIENT_ERROR);
        }
    }
}