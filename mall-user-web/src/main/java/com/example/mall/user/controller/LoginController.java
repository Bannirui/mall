package com.example.mall.user.controller;

import com.alibaba.fastjson.JSON;
import com.example.mall.common.response.ResponseData;
import com.example.mall.common.utils.CookieUtil;
import com.example.mall.user.annotation.Anoymous;
import com.example.mall.user.constant.SysRetCodeEnum;
import com.example.mall.user.interceptor.TokenInterceptor;
import com.example.mall.user.request.KaptchaCodeRequest;
import com.example.mall.user.request.LoginRequest;
import com.example.mall.user.request.UserLoginRequest;
import com.example.mall.user.response.KaptchaCodeResponse;
import com.example.mall.user.response.UserLoginResponse;
import com.example.mall.user.service.IKaptchaService;
import com.example.mall.user.service.IUserLoginService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Optional;

/**
 *@author dingrui
 *@date 2021-02-22
 *@description 用户登陆
 */
@RestController
@RequestMapping("/user")
public class LoginController {

    @DubboReference
    private IKaptchaService iKaptchaService;

    @DubboReference
    private IUserLoginService iUserLoginService;

    /**
     * @author dingrui
     * @date 2021/2/22
     * @param request
     * @param httpServletRequest
     * @param httpServletResponse
     * @return
     * @description 用户登陆
     */
    @Anoymous
    @PostMapping("/login")
    ResponseData login(@RequestBody @Validated LoginRequest request, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        // 生成验证码时的uuid
        String uuid = CookieUtil.getCookieValue(httpServletRequest, "kaptcha_uuid");
        KaptchaCodeRequest kaptchaCodeRequest = new KaptchaCodeRequest();
        kaptchaCodeRequest.setUuid(uuid);
        kaptchaCodeRequest.setCode(request.getKaptcha());
        // 校验验证码 客户端uuid->redis验证码->比较客户点验证码和redis验证码
        KaptchaCodeResponse kaptchaCodeResponse = iKaptchaService.validateKaptchaCode(kaptchaCodeRequest);
        if (!SysRetCodeEnum.SUCCESS.getCode().equals(kaptchaCodeResponse.getCode())) {
            return ResponseData.error(kaptchaCodeResponse.getMsg());
        }
        UserLoginRequest userLoginRequest = new UserLoginRequest();
        userLoginRequest.setUserName(request.getUserName());
        userLoginRequest.setPassword(request.getPassword());
        UserLoginResponse userLoginResponse = iUserLoginService.login(userLoginRequest);
        if (SysRetCodeEnum.SUCCESS.getCode().equals(userLoginResponse.getCode())) {
            Cookie cookie = CookieUtil.genCookie(TokenInterceptor.ACCESS_TOKEN, userLoginResponse.getToken(), "/", 24 * 60 * 60);
            cookie.setHttpOnly(true);
            httpServletResponse.addCookie(cookie);
            return ResponseData.success(userLoginResponse);
        }
        return ResponseData.error(userLoginResponse.getMsg());
    }

    /**
     * @author dingrui
     * @date 2021/2/22
     * @param httpServletRequest
     * @return
     * @description 校验用户登陆状态
     */
    public ResponseData checkLogin(HttpServletRequest httpServletRequest) {
        String userInfo = (String) httpServletRequest.getAttribute(TokenInterceptor.USER_INFO_KEY);
        return ResponseData.success(JSON.parse(userInfo));
    }

    /**
     * @author dingrui
     * @date 2021/2/22
     * @param httpServletRequest
     * @param httpServletResponse
     * @return
     * @description 登出
     */
    @GetMapping("/logout")
    public ResponseData logout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        Cookie[] cookies = httpServletRequest.getCookies();
        if (null != cookies) {
            Optional<Cookie> first = Arrays.stream(cookies).filter(o -> TokenInterceptor.ACCESS_TOKEN.equals(o.getName())).findFirst();
            first.ifPresent(o -> {
                o.setValue(null);
                o.setMaxAge(0);
                o.setPath("/");
                httpServletResponse.addCookie(o);
            });

        }
        return ResponseData.success();
    }
}
