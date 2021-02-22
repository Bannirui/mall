package com.example.mall.user.annotation;

import java.lang.annotation.*;

/**
 *@author dingrui
 *@date 2021-02-21
 *@description 匿名用户 游客 不需要认证
 */
@Documented
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Anoymous {
}
