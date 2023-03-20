package com.erounsystems.blogSearch.common.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * Enum
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@Getter
public enum ResponseEnum implements EnumModel {

    SUCCESS(HttpStatus.OK, "처리되었습니다.", 100),

    PARAMETER(HttpStatus.BAD_REQUEST, "파라미터 형식이 잘못되었습니다.", 700),
    ERROR_SIGN(HttpStatus.BAD_REQUEST, "계정정보를 확인해주세요.", 710),
    PROCESS(HttpStatus.BAD_REQUEST, "처리 중 에러가 발생했습니다.", 720),
    CREATE_TOKEN(HttpStatus.BAD_REQUEST, "access token creation error.", 730),
    EMAIL_CERTIFY_NOT_FOUND(HttpStatus.BAD_REQUEST, "인증 요청을 찾을 수 없습니다.", 740),
    EMAIL_CERTIFY_TIMEOUT(HttpStatus.BAD_REQUEST, "인증 요청 시간이 만료되었습니다.", 750),
    ENTITY_DUPLICATION(HttpStatus.BAD_REQUEST, "entity duplication error occurred", 760),
    FOLLOW_LIMIT_OVER(HttpStatus.BAD_REQUEST, "follow limit over.", 770),
    SPECIAL_CHARACTER_NOT_PERMIT(HttpStatus.BAD_REQUEST, "special character not permit", 770),
    ENTITY_NOT_FOUNT(HttpStatus.BAD_REQUEST, "cannot found entity", 780),
    FILE_SIZE_LIMIT_OVER(HttpStatus.BAD_REQUEST, "file size limit over", 790),
    EXPIRED_JWT_EXCEPTION(HttpStatus.BAD_REQUEST, "access token was expired", 810),
    ENTITY_DUPLICATED(HttpStatus.BAD_REQUEST, "entity duplicated", 820),

    INVALID_DATA_ACCESS_RESOURCE_USAGE(HttpStatus.BAD_REQUEST, "invalid data access resource usage error occurred", 840),
    SQL_GRAMMAR(HttpStatus.BAD_REQUEST, "sql grammar error occurred", 841),
    SQL_SYNTAX(HttpStatus.BAD_REQUEST, "sql syntax error occurred", 842),

    DATA_INTEGRITY_VIOLATION(HttpStatus.BAD_REQUEST, "data integrity violation error occurred", 850),
    CONSTRAINT_VIOLATION(HttpStatus.BAD_REQUEST, "constraint violation error occurred", 851),
    BATCH_UPDATE(HttpStatus.BAD_REQUEST, "batch update error occurred", 852),
    DATA(HttpStatus.BAD_REQUEST, "data error occurred", 853),


    PERMISSION(HttpStatus.BAD_REQUEST, "접근 권한이 없습니다.", 800),
    ILLEGAL_STATE(HttpStatus.BAD_REQUEST, "illegal state error occurred", 900),
    RUNTIME(HttpStatus.BAD_REQUEST, "runtime error occurred", 999);

    private HttpStatus httpStatus = HttpStatus.OK;
    private String message = "오류가 발생했습니다. 관리자에게 문의해주세요.";

    private Integer code = 100;

    ResponseEnum(HttpStatus httpStatus, String message, Integer code) {
        this.httpStatus = httpStatus;
        this.message = message;
        this.code = code;
    }

    @Override
    public String getKey() {
        return this.name();
    }

    @Override
    public String getValue() {
        return httpStatus.toString();
    }

}
