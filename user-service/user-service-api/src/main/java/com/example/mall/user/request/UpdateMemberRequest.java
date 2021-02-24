package com.example.mall.user.request;

import com.example.mall.common.request.AbstractRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 *@author dingrui
 *@date 2021-02-21
 *@description 更新会员信息
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class UpdateMemberRequest extends AbstractRequest {
    private static final long serialVersionUID = 7502418817378161040L;

    /**
     * 主键
     */
    @NotNull(message = "用户id不能为空")
    @Min(value = 1, message = "用户id无效")
    private Long userId;

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
