package com.yezi.zzautumn.utils;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * @Author: yezi
 * @Date: 2019/1/6 20 45
 * @Description:
 */
public class OperationResult implements Serializable {

    private static final long serialVersionUID = -6138207938071576357L;

    private boolean result = false;
    private String code = "";

    @JsonInclude(value = JsonInclude.Include.NON_NULL, content = JsonInclude.Include.NON_NULL)
    private String msg;

    @JsonInclude(value = JsonInclude.Include.NON_NULL, content = JsonInclude.Include.NON_NULL)
    private Object data;

    public OperationResult(boolean result) {
        this.result = result;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static class Strings {
        public static final String ERROR = "error";
        public static final String MESSAGE = "message";
        public static final String URL = "url";
    }

    public static class CommonCodes {
        public static final String GENERAL_FAIL = "400";

        // 正常
        public static final String RESULT_OK = "200";

        // 出错
        public static final String RESULT_FAIL = "500";

        // 输入参数有问题
        public static final String INPUT_NOT_VALID = "505";
    }

}
