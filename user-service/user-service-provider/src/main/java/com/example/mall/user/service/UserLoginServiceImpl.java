package com.example.mall.user.service;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.mall.common.exception.ProcessException;
import com.example.mall.common.exception.ValidateException;
import com.example.mall.user.annotation.ResponseExceptionHandler;
import com.example.mall.user.constant.SysRetCodeEnum;
import com.example.mall.user.converter.UserConverter;
import com.example.mall.user.dal.model.Member;
import com.example.mall.user.dal.service.MemberDalService;
import com.example.mall.user.request.CheckAuthRequest;
import com.example.mall.user.request.UserLoginRequest;
import com.example.mall.user.response.CheckAuthResponse;
import com.example.mall.user.response.UserLoginResponse;
import com.example.mall.user.utils.JwtTokenUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.List;

/**
 *@author dingrui
 *@date 2021-02-21
 *@description 用户登陆
 */
@DubboService
public class UserLoginServiceImpl implements IUserLoginService {

    @Autowired
    private UserConverter converter;

    @Autowired
    private MemberDalService memberDalService;

    /**
     * @author dingrui
     * @date 2021/2/21
     * @param request
     * @return
     * @description 用户登陆
     */
    @Override
    @ResponseExceptionHandler(returnType = UserLoginResponse.class)
    public UserLoginResponse login(@NotNull @Validated UserLoginRequest request) {
        UserLoginResponse response = new UserLoginResponse();
        // 用户登陆前 验证是否存在该用户
        List<Member> members = memberDalService.list(new LambdaQueryWrapper<Member>().eq(Member::getEnabled, 1).eq(Member::getUserName, request.getUserName()));
        if (members.isEmpty()) {
            response.setCode(SysRetCodeEnum.USER_OR_PASSWORD_ERRROR.getCode());
            response.setMsg(SysRetCodeEnum.USER_OR_PASSWORD_ERRROR.getMsg());
            return response;
        }
        Member member;
        // 是否已经激活
        if (!(member = members.get(0)).getIsVerified()) {
            response.setCode(SysRetCodeEnum.USER_OR_PASSWORD_ERRROR.getCode());
            response.setMsg(SysRetCodeEnum.USER_OR_PASSWORD_ERRROR.getMsg());
            return response;
        }
        // 存在已经激活用户 验证密码
        if (!DigestUtils.md5DigestAsHex(request.getPassword().getBytes()).equals(member.getPassword())) {
            response.setCode(SysRetCodeEnum.USER_OR_PASSWORD_ERRROR.getCode());
            response.setMsg(SysRetCodeEnum.USER_OR_PASSWORD_ERRROR.getMsg());
            return response;
        }
        // 验证通过 可以登陆
        HashMap<String, Object> map = new HashMap<>();
        map.put("uid", member.getId());
        map.put("avatarFile", member.getAvatarFile());
        String token = "";
        try {
            token = JwtTokenUtil.builder().msg(JSON.toJSONString(map)).build().creatJwtToken();
        } catch (Exception e) {
            throw new ProcessException(SysRetCodeEnum.SYSTEM_ERROR.getCode(), SysRetCodeEnum.SYSTEM_ERROR.getMsg(), e);
        }
        response = converter.model2Response(member);
        response.setCode(SysRetCodeEnum.SUCCESS.getCode());
        response.setMsg(SysRetCodeEnum.SUCCESS.getMsg());
        response.setToken(token);
        return response;
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
        CheckAuthResponse response = new CheckAuthResponse();
        String tokenDecode = "";
        try {
            tokenDecode = JwtTokenUtil.builder().token(request.getToken()).build().freeJwt();
        } catch (ValidateException e) {
            throw new ProcessException(e.getCode(), e.getMsg());
        } catch (Exception e) {
            throw new ProcessException(SysRetCodeEnum.SYSTEM_ERROR.getCode(), SysRetCodeEnum.SYSTEM_ERROR.getMsg(), e);
        }
        if (StringUtils.isNotBlank(tokenDecode)) {
            response.setCode(SysRetCodeEnum.SUCCESS.getCode());
            response.setMsg(SysRetCodeEnum.SUCCESS.getMsg());
            response.setUserInfo(tokenDecode);
        } else {
            response.setCode(SysRetCodeEnum.TOKEN_VALID_FAILED.getCode());
            response.setMsg(SysRetCodeEnum.TOKEN_VALID_FAILED.getMsg());
        }
        return response;
    }
}
