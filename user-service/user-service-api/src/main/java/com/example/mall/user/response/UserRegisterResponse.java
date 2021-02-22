package com.example.mall.user.response;

import com.example.mall.common.response.AbstractResponse;
import lombok.*;

/**
 *@author dingrui
 *@date 2021-02-20
 *@description 用户注册响应
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class UserRegisterResponse extends AbstractResponse {
    private static final long serialVersionUID = -3256753250710287459L;
}
