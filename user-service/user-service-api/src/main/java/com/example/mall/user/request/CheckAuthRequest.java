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
 *@description 用户校验认证
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class CheckAuthRequest extends AbstractRequest {
    private static final long serialVersionUID = -4031986328570580182L;

    /**
     * token
     */
    @NotNull(message = "token不能为空")
    @NotBlank(message = "token不能为空")
    private String token;
}
