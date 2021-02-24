package com.example.mall.user.dal.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author dingrui
 * @since 2021-02-20
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TableName(value = "member")
public class Member implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    @TableField(value = "id")
    private Long id;

    /**
     * 用户名
     */
    @TableField(value = "user_name")
    private String userName;

    /**
     * 密码，加密存储
     */
    @TableField(value = "password")
    private String password;

    /**
     * 注册手机号
     */
    @TableField(value = "phone")
    private String phone;

    /**
     * 注册邮箱
     */
    @TableField(value = "email")
    private String email;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    private LocalDateTime updateTime;

    /**
     * 性别
     */
    @TableField(value = "sex")
    private String sex;

    /**
     * 地址
     */
    @TableField(value = "address")
    private String address;

    /**
     * 可用状态 0表示不可用 1表示可用
     */
    @TableField(value = "enabled")
    private Integer enabled;

    /**
     * 头像
     */
    @TableField(value = "avatar_file")
    private String avatarFile;

    /**
     * 描述
     */
    @TableField(value = "description")
    private String description;

    /**
     * 积分
     */
    @TableField(value = "points")
    private Integer points;

    /**
     * 余额
     */
    @TableField(value = "balance")
    private BigDecimal balance;

    /**
     * 管理员已确认 1表示已激活 0表示未激活
     */
    @TableField(value = "is_verified")
    private Boolean isVerified;
}
