package com.example.mall.user.service;

import com.example.mall.user.dal.service.MemberDalService;
import com.example.mall.user.request.AvatarUpdateRequest;
import com.example.mall.user.request.QueryMemberRequest;
import com.example.mall.user.request.UpdateMemberRequest;
import com.example.mall.user.response.AvatarUpdateResponse;
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
    private MemberDalService memberDalService;

    /**
     * @author dingrui
     * @date 2021/2/21
     * @param request
     * @return
     * @description 根据用户会员id查询用户信息
     */
    @Override
    public QueryMemberResponse queryMemberByUserId(QueryMemberRequest request) {
        return null;
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
        return null;
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
        return null;
    }
}
