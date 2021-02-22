package com.example.mall.user.service;

import com.example.mall.user.request.CheckAuthRequest;
import com.example.mall.user.request.UserLoginRequest;
import com.example.mall.user.response.CheckAuthResponse;
import com.example.mall.user.response.UserLoginResponse;
import org.apache.dubbo.config.annotation.DubboService;

/**
 *@author dingrui
 *@date 2021-02-21
 *@description 用户登陆
 */
@DubboService
public class UserLoginServiceImpl implements IUserLoginService {
    /**
     * @author dingrui
     * @date 2021/2/21
     * @param request
     * @return
     * @description 用户登陆
     */
    @Override
    public UserLoginResponse login(UserLoginRequest request) {
        return null;
    }

    /**
     * @author dingrui
     * @date 2021/2/21
     * @param request
     * @return
     * @description 用户校验认证
     */
    @Override
    public CheckAuthResponse validToken(CheckAuthRequest request) {
        return null;
    }
}
