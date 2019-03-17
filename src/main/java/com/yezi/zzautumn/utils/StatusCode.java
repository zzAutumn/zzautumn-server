package com.yezi.zzautumn.utils;

/**
 * @Author: yezi
 * @Date: 2019/3/17 09 06
 * @Description:
 */
public enum  StatusCode {

    GENERAL_FAIL("400"),
    RESULT_OK("200"),
    RESULT_FAIL("500"),
    INPUT_NOT_VALID("505");

    private String code;

    StatusCode (String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
