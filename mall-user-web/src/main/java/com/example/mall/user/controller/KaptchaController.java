package com.example.mall.user.controller;

import com.example.mall.common.response.ResponseData;
import com.example.mall.common.utils.CookieUtil;
import com.example.mall.user.annotation.Anoymous;
import com.example.mall.user.constant.SysRetCodeEnum;
import com.example.mall.user.request.KaptchaCodeRequest;
import com.example.mall.user.response.KaptchaCodeResponse;
import com.example.mall.user.service.IKaptchaService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 *@author dingrui
 *@date 2021-02-21
 *@description 图形验证码
 */
@RestController
@RequestMapping("/user")
public class KaptchaController {

    @DubboReference(timeout = 3000, check = false)
    private IKaptchaService iKaptchaService;

    /**
     * @author dingrui
     * @date 2021/2/22
     * @param response
     * @return
     * @description 获取验证码
     */
    @Anoymous
    @GetMapping("/kaptcha")
    public ResponseData<Object> getKaptchaCode(HttpServletResponse response) {
        // 验证码服务
        KaptchaCodeResponse kaptchaCodeResponse = iKaptchaService.getKaptchaCode(new KaptchaCodeRequest());
        if (!SysRetCodeEnum.SUCCESS.getCode().equals(kaptchaCodeResponse.getCode())) {
            // 验证码服务失败
            return ResponseData.error(kaptchaCodeResponse.getMsg());
        }
        Cookie cookie = CookieUtil.genCookie("kaptcha_uuid", kaptchaCodeResponse.getUuid(), "/", 60);
        cookie.setHttpOnly(true);
        response.addCookie(cookie);
        return ResponseData.success(kaptchaCodeResponse.getImageCode());
    }

    /**
     * @author dingrui
     * @date 2021/2/22
     * @param code
     * @param httpServletRequest
     * @return
     * @description 验证码校验
     */
    @Anoymous
    @PostMapping("/kaptcha")
    public ResponseData<Object> validKaptcha(@RequestBody @NotNull(message = "验证码不能为空") @NotBlank(message = "验证码不能为空") String code, HttpServletRequest httpServletRequest) {
        // 生成验证码时的uuid
        String uuid = CookieUtil.getCookieValue(httpServletRequest, "kaptcha_uuid");
        KaptchaCodeRequest kaptchaCodeRequest = new KaptchaCodeRequest();
        kaptchaCodeRequest.setUuid(uuid);
        kaptchaCodeRequest.setCode(code);
        KaptchaCodeResponse kaptchaCodeResponse = iKaptchaService.validateKaptchaCode(kaptchaCodeRequest);
        return SysRetCodeEnum.SUCCESS.getCode().equals(kaptchaCodeResponse.getCode()) ? ResponseData.success() : ResponseData.error(kaptchaCodeResponse.getCode().toString());
    }
}
