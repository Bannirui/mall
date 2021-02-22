package com.example.mall.user.service;

import com.example.mall.user.request.UserRegisterRequest;
import com.example.mall.user.response.UserRegisterResponse;

/**
 *@author dingrui
 *@date 2021-02-20
 *@description 用户注册服务
 */
public interface IUserRegisterService {

    /**
     * @author dingrui
     * @date 2021/2/20
     * @param request
     * @return
     * @description 用户注册
     */
    UserRegisterResponse register(UserRegisterRequest request);
}
