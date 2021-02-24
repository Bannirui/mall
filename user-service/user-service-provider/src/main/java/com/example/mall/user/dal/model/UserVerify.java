package com.example.mall.user.dal.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 用户验证表
 * </p>
 *
 * @author dingrui
 * @since 2021-02-20
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TableName(value = "user_verify")
public class UserVerify implements Serializable {

    private static final long serialVersionUID=1L;

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
     * 注册日期
     */
    @TableField(value = "register_date")
    private LocalDateTime registerDate;

    /**
     * uuid
     */
    @TableField(value = "uuid")
    private String uuid;

    /**
     * 是否验证：1已验证，0未验证
     */
    @TableField(value = "is_verify")
    private Boolean isVerify;

    /**
     * 是否过期：1已过期，0为过期
     */
    @TableField(value = "is_expire")
    private Boolean isExpire;
}
