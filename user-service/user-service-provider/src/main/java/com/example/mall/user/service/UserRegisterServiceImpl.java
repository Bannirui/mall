package com.example.mall.user.service;

import com.example.mall.user.annotation.ResponseExceptionHandler;
import com.example.mall.user.constant.SysRetCodeEnum;
import com.example.mall.user.dal.model.Member;
import com.example.mall.user.dal.model.UserVerify;
import com.example.mall.user.dal.service.MemberDalService;
import com.example.mall.user.dal.service.UserVerifyDalService;
import com.example.mall.user.request.UserRegisterRequest;
import com.example.mall.user.response.UserRegisterResponse;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;

import java.util.UUID;

/**
 *@author dingrui
 *@date 2021-02-20
 *@description 用户注册
 */
@DubboService
public class UserRegisterServiceImpl implements IUserRegisterService {

    @Autowired
    private MemberDalService memberDalService;

    @Autowired
    private UserVerifyDalService userVerifyDalService;

    /**
     * @author dingrui
     * @date 2021/2/20
     * @param request
     * @return
     * @description 用户注册
     */
    @Override
    @ResponseExceptionHandler(returnType = UserRegisterResponse.class)
    public UserRegisterResponse register(UserRegisterRequest request) {
        UserRegisterResponse response = new UserRegisterResponse();
        Member member = Member.builder()
                .userName(request.getUserName())
                .password(DigestUtils.md5DigestAsHex(request.getPassword().getBytes()))
                .email(request.getEmail())
                .state(1)
                .isVerified("N")
                .build();
        // 插入用户表
        if (!memberDalService.save(member)) {
            // 注册失败
            response.setCode(SysRetCodeEnum.USER_REGISTER_FAILED.getCode());
            response.setMsg(SysRetCodeEnum.USER_REGISTER_FAILED.getMessage());
            return response;
        }
        // 插入用户验证表
        UserVerify userVerify = UserVerify.builder()
                .userName(request.getUserName())
                .uuid(DigestUtils.md5DigestAsHex((request.getUserName() + request.getPassword() + UUID.randomUUID().toString()).getBytes()))
                .isExpire("N")
                .isVerify("N")
                .build();
        if (userVerifyDalService.save(userVerify)) {
            // 认证失败
            response.setCode(SysRetCodeEnum.USER_REGISTER_VERIFY_FAILED.getCode());
            response.setMsg(SysRetCodeEnum.USER_REGISTER_VERIFY_FAILED.getMessage());
            return response;
        }
        response.setCode(SysRetCodeEnum.SYSTEM_ERROR.getCode());
        response.setMsg(SysRetCodeEnum.SUCCESS.getMessage());
        // TODO: 2021/2/21 发送激活邮件到消息队列
        return response;
    }
}