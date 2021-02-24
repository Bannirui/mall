package com.example.mall.common.exception;

import com.example.mall.common.response.AbstractResponse;

/**
 * @author dingrui
 * @date 2021-02-23
 * @description 异常工具
 */
public class ExceptionUtil {

    /**
     * @author dingrui
     * @date 2021/2/23
     * @param response
     * @param e
     * @return
     * @description 将下层抛出的异常转换为response返回码
     */
    public static AbstractResponse handlerException4Biz(AbstractResponse response, Exception e) throws Exception {
        Exception ex = null;
        if (e == null) {
            return null;
        }
        if (e instanceof ValidateException) {
            response.setCode(((ValidateException) e).getCode());
            response.setMsg(e.getMessage());
        } else if (e instanceof ProcessException) {
            response.setCode(((ProcessException) e).getCode());
            response.setMsg(e.getMessage());
        } else if (e instanceof BizException) {
            response.setCode(((BizException) e).getCode());
            response.setMsg(e.getMessage());
        } else {
            // 处理不了 抛出去调用方处理
            throw e;
        }
        return response;
    }
}
