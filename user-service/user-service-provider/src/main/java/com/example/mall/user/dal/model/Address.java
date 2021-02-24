package com.example.mall.user.dal.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 地址表
 * </p>
 *
 * @author dingrui
 * @since 2021-02-23
 */
@Data
@TableName("address")
public class Address implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 电话
     */
    private String tel;

    /**
     * 街道名称
     */
    private String streetName;

    /**
     * 是否是默认地址 1表示是 0表示不是
     */
    private Boolean isDefault;
}
