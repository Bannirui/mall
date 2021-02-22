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
 *@description 用户激活
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class UserVerifyRequest extends AbstractRequest {
    private static final long serialVersionUID = 7805787368690414927L;

    /**
     * 用户名
     */
    @NotNull(message = "用户名不能为空")
    @NotBlank(message = "用户名不能为空")
    private String userName;

    /**
     * uuid 用户注册时产生的唯一序号
     */
    @NotNull(message = "uuid不能为空")
    @NotBlank(message = "uuid不能为空")
    private String uuid;
}
