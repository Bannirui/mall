package com.example.mall.user.service;

import com.example.mall.user.request.CheckAuthRequest;
import com.example.mall.user.request.UserLoginRequest;
import com.example.mall.user.response.CheckAuthResponse;
import com.example.mall.user.response.UserLoginResponse;

/**
 *@author dingrui
 *@date 2021-02-21
 *@description 用户登陆
 */
public interface IUserLoginService {

    /**
     * @author dingrui
     * @date 2021/2/21
     * @param request
     * @return
     * @description 用户登陆
     */
    UserLoginResponse login(UserLoginRequest request);

    /**
     * @author dingrui
     * @date 2021/2/21
     * @param request
     * @return
     * @description 用户校验认证
     */
    CheckAuthResponse validToken(CheckAuthRequest request);
}
