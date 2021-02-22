package com.example.mall.user.service;

import com.example.mall.user.request.UserVerifyRequest;
import com.example.mall.user.response.UserVerifyResponse;
import org.apache.dubbo.config.annotation.DubboService;

/**
 *@author dingrui
 *@date 2021-02-21
 *@description 用户激活
 */
@DubboService
public class UserVerifyServiceImpl implements IUserVerifyService {
    /**
     * @author dingrui
     * @date 2021/2/21
     * @param request
     * @return
     * @description 激活邮件
     */
    @Override
    public UserVerifyResponse verifyMember(UserVerifyRequest request) {
        return null;
    }
}
