package com.yezi.zzautumn.utils;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * @Author: yezi
 * @Date: 2019/1/6 20 45
 * @Description:
 */
public class OperationResult implements Serializable {

    private boolean result = false;
    private String code = "";

    @JsonInclude
    private String msg;
    private Object data;

}
