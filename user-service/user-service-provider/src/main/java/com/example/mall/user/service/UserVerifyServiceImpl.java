package com.example.mall.user.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.example.mall.common.constant.BaseRetCodeEnum;
import com.example.mall.common.constant.UserRetCodeEnum;
import com.example.mall.user.dal.model.Member;
import com.example.mall.user.dal.model.UserVerify;
import com.example.mall.user.dal.service.MemberDalService;
import com.example.mall.user.dal.service.UserVerifyDalService;
import com.example.mall.user.request.UserVerifyRequest;
import com.example.mall.user.response.UserVerifyResponse;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *@author dingrui
 *@date 2021-02-21
 *@description 用户激活
 */
@DubboService
public class UserVerifyServiceImpl implements IUserVerifyService {

    @Autowired
    private MemberDalService memberDalService;

    @Autowired
    private UserVerifyDalService userVerifyDalService;

    /**
     * @author dingrui
     * @date 2021/2/21
     * @param request
     * @return
     * @description 激活邮件
     */
    @Override
    public UserVerifyResponse verifyMember(UserVerifyRequest request) {
        UserVerifyResponse response = new UserVerifyResponse();
        Member member = memberDalService.getOne(new LambdaQueryWrapper<Member>().eq(Member::getEnabled, 1).eq(Member::getUserName, request.getUserName()));
        if (null == member) {
            response.setCode(UserRetCodeEnum.USER_INFOR_INVALID.getCode());
            response.setMsg(UserRetCodeEnum.USER_INFOR_INVALID.getMsg());
            return response;
        }
        // 是否存在激活信息
        UserVerify userVerify = userVerifyDalService.getOne(new LambdaQueryWrapper<UserVerify>().eq(UserVerify::getUuid, request.getUuid()));
        if (null == userVerify) {
            response.setCode(UserRetCodeEnum.USER_INFOR_INVALID.getCode());
            response.setMsg(UserRetCodeEnum.USER_INFOR_INVALID.getMsg());
            return response;
        }
        // 更新激活信息 未激活->已激活
        userVerifyDalService.update(new LambdaUpdateWrapper<UserVerify>().eq(UserVerify::getId, userVerify.getId()).set(UserVerify::getIsVerify, true));
        // 更新会员表
        memberDalService.update(new LambdaUpdateWrapper<Member>().eq(Member::getId, member.getId()).set(Member::getIsVerified, true));
        response.setCode(BaseRetCodeEnum.SUCCESS.getCode());
        response.setMsg(BaseRetCodeEnum.SUCCESS.getMsg());
        return response;
    }
}
