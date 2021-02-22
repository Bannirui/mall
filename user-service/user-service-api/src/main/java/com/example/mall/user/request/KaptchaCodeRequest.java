package com.example.mall.user.request;

import com.example.mall.common.request.AbstractRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 *@author dingrui
 *@date 2021-02-21
 *@description 图形验证码
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class KaptchaCodeRequest extends AbstractRequest {

    private static final long serialVersionUID = -7774853100250874455L;

    /**
     * uuid
     */
    @NotNull(message = "uuid不能为空")
    @NotBlank(message = "uuid不能为空")
    private String uuid;

    /**
     * 编码
     */
    @NotNull(message = "编码不能为空")
    @NotBlank(message = "编码不能为空")
    private String code;
}
