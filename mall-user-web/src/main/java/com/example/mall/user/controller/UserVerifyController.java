package com.example.mall.user.controller;

import com.example.mall.common.response.ResponseData;
import com.example.mall.user.annotation.Anoymous;
import com.example.mall.user.constant.SysRetCodeEnum;
import com.example.mall.user.request.UserVerifyRequest;
import com.example.mall.user.response.UserVerifyResponse;
import com.example.mall.user.service.IUserVerifyService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 *@author dingrui
 *@date 2021-02-22
 *@description 用户注册激活
 */
@RestController
@RequestMapping("/user")
public class UserVerifyController {

    @DubboReference(timeout = 3000, check = false)
    private IUserVerifyService iUserVerifyService;

    /**
     * @author dingrui
     * @date 2021/2/22
     * @param uuid
     * @param userName
     * @return
     * @description 用户注册激活
     */
    @Anoymous
    @GetMapping("/verify")
    public ResponseData register(@RequestParam @NotNull(message = "注册序号不能为空") @NotBlank(message = "注册序号不能为空") String uuid, @RequestParam @NotNull(message = "用户名不能为空") @NotBlank(message = "用户名不能为空") String userName) {
        UserVerifyRequest userVerifyRequest = new UserVerifyRequest();
        userVerifyRequest.setUserName(userName);
        userVerifyRequest.setUuid(uuid);
        UserVerifyResponse userVerifyResponse = iUserVerifyService.verifyMember(userVerifyRequest);
        return SysRetCodeEnum.SUCCESS.getCode().equals(userVerifyResponse.getCode()) ? ResponseData.success() : ResponseData.error(userVerifyResponse.getMsg());
    }
}
