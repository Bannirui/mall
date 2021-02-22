package com.example.mall.user.response;

import com.example.mall.common.response.AbstractResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 *@author dingrui
 *@date 2021-02-21
 *@description 图形验证码
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class KaptchaCodeResponse extends AbstractResponse {
    private static final long serialVersionUID = -2048559621873084211L;

    /**
     * 验证码
     */
    private String imageCode;

    /**
     * uuid
     */
    private String uuid;
}
