package com.example.mall.user.service;

import com.example.mall.user.request.KaptchaCodeRequest;
import com.example.mall.user.response.KaptchaCodeResponse;

/**
 *@author dingrui
 *@date 2021-02-21
 *@description 图形验证码
 */
public interface IKaptchaService {

    /**
     * @author dingrui
     * @date 2021/2/21
     * @param request
     * @return
     * @description 获取图形验证码
     */
    KaptchaCodeResponse getKaptchaCode(KaptchaCodeRequest request);

    /**
     * @author dingrui
     * @date 2021/2/21
     * @param request
     * @return
     * @description 验证图形验证码
     */
    KaptchaCodeResponse validateKaptchaCode(KaptchaCodeRequest request);
}
