package com.yezi.zzautumn.controller;

import com.yezi.zzautumn.utils.OperationResult;
import org.springframework.validation.ObjectError;

import java.util.stream.Collectors;

/**
 * @Author: yezi
 * @Date: 2019/1/6 20 07
 * @Description:
 */
public abstract class BaseController {

    public OperationResult processSimple(OperationResult rr, Taker taker) {

        try {

            taker.process(rr);
            rr.setResult(true);
            rr.setCode(OperationResult.CommonCodes.RESULT_OK);

        } catch (Exception e) {
            rr.setResult(false);
            rr.setCode(OperationResult.CommonCodes.RESULT_FAIL);
            rr.setMsg("System Biz,Pls Try Later");
        }

        return rr;
    }


    /**
     * @param taker
     * @return
     */
    public OperationResult processSimple(Taker taker) {

        return processSimple(new OperationResult(false), taker);

    }

    @FunctionalInterface
    public interface Taker {
        void process(OperationResult rr);
    }
}
