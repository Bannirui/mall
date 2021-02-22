package com.example.mall.user.response;

import com.example.mall.common.response.AbstractResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 *@author dingrui
 *@date 2021-02-21
 *@description 用户激活
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class UserVerifyResponse extends AbstractResponse {
    private static final long serialVersionUID = 766932341321998280L;
}
