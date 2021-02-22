package com.example.mall.user.service;

import com.example.mall.user.request.KaptchaCodeRequest;
import com.example.mall.user.response.KaptchaCodeResponse;
import org.apache.dubbo.config.annotation.DubboService;

/**
 *@author dingrui
 *@date 2021-02-21
 *@description 图形验证码
 */
@DubboService
public class KaptchaServiceImpl implements IKaptchaService {
    /**
     * @author dingrui
     * @date 2021/2/21
     * @param request
     * @return
     * @description 获取图形验证码
     */
    @Override
    public KaptchaCodeResponse getKaptchaCode(KaptchaCodeRequest request) {
        return null;
    }

    /**
     * @author dingrui
     * @date 2021/2/21
     * @param request
     * @return
     * @description 验证图形验证码
     */
    @Override
    public KaptchaCodeResponse validateKaptchaCode(KaptchaCodeRequest request) {
        return null;
    }
}
