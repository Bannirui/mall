package com.example.mall.user.service;

import com.example.mall.user.request.AvatarUpdateRequest;
import com.example.mall.user.request.QueryMemberRequest;
import com.example.mall.user.request.UpdateMemberRequest;
import com.example.mall.user.response.AvatarUpdateResponse;
import com.example.mall.user.response.QueryMemberResponse;
import com.example.mall.user.response.UpdateMemberResponse;

/**
 *@author dingrui
 *@date 2021-02-21
 *@description 会员服务
 */
public interface IMemberService {

    /**
     * @author dingrui
     * @date 2021/2/21
     * @param request
     * @return
     * @description 根据用户会员id查询用户信息
     */
    QueryMemberResponse queryMemberByUserId(QueryMemberRequest request);

    /**
     * @author dingrui
     * @date 2021/2/21
     * @param request
     * @return
     * @description 修改用户头像
     */
    AvatarUpdateResponse updateAvatar(AvatarUpdateRequest request);

    /**
     * @author dingrui
     * @date 2021/2/21
     * @param request
     * @return
     * @description 更新会员信息
     */
    UpdateMemberResponse updateMember(UpdateMemberRequest request);
}
