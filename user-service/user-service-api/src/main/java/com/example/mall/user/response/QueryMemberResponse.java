package com.example.mall.user.response;

import com.example.mall.common.response.AbstractResponse;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 *@author dingrui
 *@date 2021-02-21
 *@description 查询会员响应
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class QueryMemberResponse extends AbstractResponse {

    private static final long serialVersionUID = 914578920223803701L;
    /**
     * 主键
     */
    private Long id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码，加密存储
     */
    private String password;

    /**
     * 注册手机号
     */
    private String phone;

    /**
     * 注册邮箱
     */
    private String email;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 性别
     */
    private String sex;

    /**
     * 地址
     */
    private String address;

    /**
     * 状态
     */
    private Integer state;

    /**
     * 头像
     */
    private String file;

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
}
