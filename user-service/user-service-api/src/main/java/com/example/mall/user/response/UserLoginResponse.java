package com.example.mall.user.response;

import com.example.mall.common.response.AbstractResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.math.BigDecimal;

/**
 *@author dingrui
 *@date 2021-02-21
 *@description 用户登陆
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class UserLoginResponse extends AbstractResponse {

    private static final long serialVersionUID = -5121674737483144785L;

    /**
     * 主键
     */
    private Long userId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 注册手机号
     */
    private String phone;

    /**
     * 注册邮箱
     */
    private String email;

    /**
     * 性别
     */
    private String sex;

    /**
     * 地址
     */
    private String address;

    /**
     * 可用状态 0表示不可用 1表示可用
     */
    private Boolean enabled;

    /**
     * 头像
     */
    private String avatarFile;

    /**
     * 描述
     */
    private String description;

    /**
     * 积分
     */
    private Integer points;

    /**
     * 余额
     */
    private BigDecimal balance;

    /**
     * token
     */
    private String token;
}
