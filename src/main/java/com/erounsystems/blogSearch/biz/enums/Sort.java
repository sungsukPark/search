package com.erounsystems.blogSearch.biz.enums;

import java.io.Serializable;

import com.erounsystems.blogSearch.common.enums.EnumModel;

public enum Sort implements EnumModel,Serializable {
	// accuracy(정확도순) , recency(최신순)
    ACCURACY("정확도순"),
    RECENCY("최신순");

    private String value;

    Sort(String value) {
        this.value = value;
    }

    @Override
    public String getKey() {
        return name();
    }

    @Override
    public String getValue() {
        return value;
    }
}