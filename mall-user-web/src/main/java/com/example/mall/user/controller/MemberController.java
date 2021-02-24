package com.example.mall.user.controller;

import com.example.mall.common.response.ResponseData;
import com.example.mall.user.annotation.Anoymous;
import com.example.mall.user.constant.SysRetCodeEnum;
import com.example.mall.user.request.QueryMemberRequest;
import com.example.mall.user.request.UpdateMemberRequest;
import com.example.mall.user.response.QueryMemberResponse;
import com.example.mall.user.response.UpdateMemberResponse;
import com.example.mall.user.service.IMemberService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

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

    /**
     * @author dingrui
     * @date 2021/2/22
     * @param id
     * @return
     * @description 根据id查询会员信息
     */
    @Anoymous
    @GetMapping("/member/{id}")
    public ResponseData searchMemberById(@PathVariable(name = "id") Long id) {
        QueryMemberRequest queryMemberRequest = new QueryMemberRequest();
        queryMemberRequest.setUserId(id);
        QueryMemberResponse queryMemberResponse = iMemberService.queryMemberByUserId(queryMemberRequest);
        return SysRetCodeEnum.SUCCESS.getCode().equals(queryMemberResponse.getCode()) ? ResponseData.success(queryMemberResponse) : ResponseData.error(queryMemberResponse.getMsg());
    }

    /**
     * @author dingrui
     * @date 2021/2/22
     * @param request
     * @return
     * @description 跟新会员信息
     */
    @PutMapping("/member")
    public ResponseData updateUser(@RequestBody @NotNull @Validated UpdateMemberRequest request) {
        UpdateMemberResponse updateMemberResponse = iMemberService.updateMember(request);
        return SysRetCodeEnum.SUCCESS.getCode().equals(updateMemberResponse.getCode()) ? ResponseData.success() : ResponseData.error(updateMemberResponse.getMsg());
    }
}
