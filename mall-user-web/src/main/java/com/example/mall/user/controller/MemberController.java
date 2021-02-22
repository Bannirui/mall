package com.example.mall.user.controller;

import com.example.mall.common.response.ResponseData;
import com.example.mall.user.annotation.Anoymous;
import com.example.mall.user.service.IMemberService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *@author dingrui
 *@date 2021-02-22
 *@description 会员中心
 */
@RestController
@RequestMapping("/user")
public class MemberController {

    @DubboReference(timeout = 30000, check = false)
    private IMemberService iMemberService;

    @Anoymous
    @GetMapping("/member/{id}")
    public ResponseData searchMemberById(@PathVariable(name = "id") String id) {
        return ResponseData.success();
    }
}
