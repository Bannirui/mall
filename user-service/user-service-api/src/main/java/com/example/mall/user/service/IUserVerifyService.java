package com.example.mall.user.service;

import com.example.mall.user.request.UserVerifyRequest;
import com.example.mall.user.response.UserVerifyResponse;

/**
 *@author dingrui
 *@date 2021-02-21
 *@description 用户激活
 */
public interface IUserVerifyService {

    /**
     * @author dingrui
     * @date 2021/2/21
     * @param request
     * @return
     * @description 激活邮件
     */
    UserVerifyResponse verifyMember(UserVerifyRequest request);
}
