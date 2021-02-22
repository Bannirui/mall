package com.example.mall.user.response;

import com.example.mall.common.response.AbstractResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 *@author dingrui
 *@date 2021-02-21
 *@description 用户校验认证
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class CheckAuthResponse extends AbstractResponse {
    private static final long serialVersionUID = 9062980787208727669L;

    /**
     * 用户信息
     */
    private String userInfo;
}
