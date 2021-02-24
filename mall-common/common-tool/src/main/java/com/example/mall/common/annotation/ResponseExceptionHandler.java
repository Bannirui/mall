package com.example.mall.common.annotation;

import com.example.mall.common.response.AbstractResponse;

import java.lang.annotation.*;

/**
 *@author dingrui
 *@date 2021-02-20
 *@description 全局异常处理
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface ResponseExceptionHandler {
    // 返回值类型
    Class<? extends AbstractResponse> returnType();
}
