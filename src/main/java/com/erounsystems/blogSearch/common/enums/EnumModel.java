package com.erounsystems.blogSearch.common.enums;


import com.fasterxml.jackson.annotation.JsonValue;

public interface EnumModel {

    @JsonValue
    String getKey();

    String getValue();

}