package com.example.mall.common.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *@author dingrui
 *@date 2021-02-21
 *@description 响应体
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseData<T> {

    /**
     * 是否成功
     */
    private Boolean success;

    /**
     * 编码
     */
    private Integer code;

    /**
     * 消息
     */
    private String message;

    /**
     * 时间戳
     */
    private Long timeStamp;

    /**
     * 返回的数据
     */
    private T result;

    public static <T> ResponseData<T> success() {
        ResponseData<T> responseData = new ResponseData<>();
        responseData.setSuccess(true);
        responseData.setCode(200);
        responseData.setTimeStamp(System.currentTimeMillis());
        return responseData;
    }

    public static <T> ResponseData<T> success(T result) {
        ResponseData<T> responseData = new ResponseData<>();
        responseData.setSuccess(true);
        responseData.setCode(200);
        responseData.setTimeStamp(System.currentTimeMillis());
        responseData.setResult(result);
        return responseData;
    }

    public static <T> ResponseData<T> success(String msg) {
        ResponseData<T> responseData = new ResponseData<>();
        responseData.setSuccess(true);
        responseData.setCode(200);
        responseData.setMessage(msg);
        responseData.setTimeStamp(System.currentTimeMillis());
        return responseData;
    }

    public static <T> ResponseData<T> success(T result, String msg) {
        ResponseData<T> responseData = new ResponseData<>();
        responseData.setSuccess(true);
        responseData.setCode(200);
        responseData.setMessage(msg);
        responseData.setTimeStamp(System.currentTimeMillis());
        responseData.setResult(result);
        return responseData;
    }

    public static <T> ResponseData<T> error(String msg) {
        ResponseData<T> responseData = new ResponseData<>();
        responseData.setSuccess(false);
        responseData.setCode(500);
        responseData.setMessage(msg);
        responseData.setTimeStamp(System.currentTimeMillis());
        return responseData;
    }

    public static <T> ResponseData<T> error(T result, String msg) {
        ResponseData<T> responseData = new ResponseData<>();
        responseData.setSuccess(false);
        responseData.setCode(500);
        responseData.setMessage(msg);
        responseData.setTimeStamp(System.currentTimeMillis());
        responseData.setResult(result);
        return responseData;
    }
}
