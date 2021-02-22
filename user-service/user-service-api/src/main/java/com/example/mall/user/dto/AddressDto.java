package com.example.mall.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 *@author dingrui
 *@date 2021-02-21
 *@description 地址信息
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressDto implements Serializable {
    private static final long serialVersionUID = 3979850363136576123L;

    /**
     * 地址id
     */
    private Long addressId;

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
     * 默认地址
     */
    private Integer isDefault;
}
