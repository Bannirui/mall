package com.example.mall.user.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 *@author dingrui
 *@date 2021-02-22
 *@description 用户登陆
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginRequest implements Serializable {
    private static final long serialVersionUID = -286849637996887937L;

    /**
     * 用户名
     */
    @NotNull(message = "用户名不能为空")
    @NotBlank(message = "用户名不能为空")
    private String userName;

    /**
     * 密码
     */
    @NotNull(message = "密码不能为空")
    @NotBlank(message = "密码不能为空")
    private String password;

    /**
     * 验证码
     */
    @NotNull(message = "验证码不能为空")
    @NotBlank(message = "验证码不能为空")
    private String kaptcha;
}
