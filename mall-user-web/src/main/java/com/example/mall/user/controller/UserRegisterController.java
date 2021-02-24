package com.example.mall.user.controller;

import com.example.mall.common.response.ResponseData;
import com.example.mall.common.utils.CookieUtil;
import com.example.mall.user.annotation.Anoymous;
import com.example.mall.user.constant.SysRetCodeEnum;
import com.example.mall.user.request.KaptchaCodeRequest;
import com.example.mall.user.request.RegisterRequest;
import com.example.mall.user.request.UserRegisterRequest;
import com.example.mall.user.response.KaptchaCodeResponse;
import com.example.mall.user.response.UserRegisterResponse;
import com.example.mall.user.service.IKaptchaService;
import com.example.mall.user.service.IUserRegisterService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 *@author dingrui
 *@date 2021-02-21
 *@description 用户注册
 */
@RestController
@RequestMapping("/user")
public class UserRegisterController {

    @DubboReference(timeout = 3000, check = false)
    private IKaptchaService iKaptchaService;

    @DubboReference(timeout = 3000, check = false)
    private IUserRegisterService iUserRegisterService;

    /**
     * @author dingrui
     * @date 2021/2/22
     * @param dto
     * @param request
     * @return
     * @description 用户注册
     */
    @Anoymous
    @PostMapping("/register")
    public ResponseData<Object> register(@RequestBody @Validated RegisterRequest dto, HttpServletRequest request) {
        // 请求中uuid
        String uuid = CookieUtil.getCookieValue(request, "kaptcha_uuid");
        // 校验验证码
        KaptchaCodeRequest kaptchaCodeRequest = new KaptchaCodeRequest();
        kaptchaCodeRequest.setUuid(uuid);
        kaptchaCodeRequest.setCode(dto.getCaptcha());
        KaptchaCodeResponse kaptchaCodeResponse = iKaptchaService.validateKaptchaCode(kaptchaCodeRequest);
        if (!SysRetCodeEnum.SUCCESS.getCode().equals(kaptchaCodeResponse.getCode())) {
            // 图形验证码校验失败
            return ResponseData.error(kaptchaCodeResponse.getMsg());
        }
        // 注册用户
        UserRegisterRequest userRegisterRequest = new UserRegisterRequest();
        userRegisterRequest.setUserName(dto.getUserName());
        userRegisterRequest.setPassword(dto.getPassword());
        userRegisterRequest.setEmail(dto.getEmail());
        UserRegisterResponse userRegisterResponse = iUserRegisterService.register(userRegisterRequest);
        return SysRetCodeEnum.SUCCESS.getCode().equals(userRegisterResponse.getCode()) ? ResponseData.success() : ResponseData.error(userRegisterResponse.getMsg());
    }
}
