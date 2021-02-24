package com.example.mall.user.service;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.example.mall.common.constant.BaseRetCodeEnum;
import com.example.mall.user.converter.MemberConverter;
import com.example.mall.user.dal.model.Member;
import com.example.mall.user.dal.service.MemberDalService;
import com.example.mall.user.request.AvatarUpdateRequest;
import com.example.mall.user.request.CheckAuthRequest;
import com.example.mall.user.request.QueryMemberRequest;
import com.example.mall.user.request.UpdateMemberRequest;
import com.example.mall.user.response.AvatarUpdateResponse;
import com.example.mall.user.response.CheckAuthResponse;
import com.example.mall.user.response.QueryMemberResponse;
import com.example.mall.user.response.UpdateMemberResponse;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *@author dingrui
 *@date 2021-02-21
 *@description 会员服务
 */
@DubboService
public class MemberServiceImpl implements IMemberService {

    @Autowired
    private MemberConverter converter;

    @Autowired
    private MemberDalService memberDalService;

    @Autowired
    private IUserLoginService iUserLoginService;

    /**
     * @author dingrui
     * @date 2021/2/21
     * @param request
     * @return
     * @description 根据用户会员id查询用户信息
     */
    @Override
    public QueryMemberResponse queryMemberByUserId(QueryMemberRequest request) {
        QueryMemberResponse response = new QueryMemberResponse();
        Member member = memberDalService.getById(request.getUserId());
        if (null == member) {
            response.setCode(BaseRetCodeEnum.DATA_NOT_EXIST.getCode());
            response.setMsg(BaseRetCodeEnum.DATA_NOT_EXIST.getMsg());
        } else {
            response = converter.model2Response(member);
            response.setCode(BaseRetCodeEnum.SUCCESS.getCode());
            response.setMsg(BaseRetCodeEnum.SUCCESS.getMsg());
        }
        return response;
    }

    /**
     * @author dingrui
     * @date 2021/2/21
     * @param request
     * @return
     * @description 修改用户头像
     */
    @Override
    public AvatarUpdateResponse updateAvatar(AvatarUpdateRequest request) {
        AvatarUpdateResponse response = new AvatarUpdateResponse();
        if (memberDalService.update(new LambdaUpdateWrapper<Member>().eq(Member::getId, request.getUserId()).set(Member::getAvatarFile, request.getAvatarFile()))) {
            response.setCode(BaseRetCodeEnum.SUCCESS.getCode());
            response.setMsg(BaseRetCodeEnum.SUCCESS.getMsg());
        } else {
            response.setCode(BaseRetCodeEnum.SYSTEM_ERROR.getCode());
            response.setMsg(BaseRetCodeEnum.SYSTEM_ERROR.getMsg());
        }
        return response;
    }

    /**
     * @author dingrui
     * @date 2021/2/21
     * @param request
     * @return
     * @description 更新会员信息
     */
    @Override
    public UpdateMemberResponse updateMember(UpdateMemberRequest request) {
        UpdateMemberResponse response = new UpdateMemberResponse();
        CheckAuthRequest checkAuthRequest = new CheckAuthRequest();
        checkAuthRequest.setToken(request.getToken());
        CheckAuthResponse checkAuthResponse = iUserLoginService.validToken(checkAuthRequest);
        if (!BaseRetCodeEnum.SUCCESS.getCode().equals(checkAuthResponse.getCode())) {
            response.setCode(checkAuthResponse.getCode());
            response.setMsg(checkAuthResponse.getMsg());
            return response;
        }
        Member member = converter.request2Model(request);
        if (memberDalService.updateById(member)) {
            response.setCode(BaseRetCodeEnum.SUCCESS.getCode());
            response.setMsg(BaseRetCodeEnum.SUCCESS.getMsg());
            return response;
        }
        response.setCode(BaseRetCodeEnum.SYSTEM_ERROR.getCode());
        response.setMsg(BaseRetCodeEnum.SYSTEM_ERROR.getMsg());
        return response;
    }
}
