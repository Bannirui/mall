package com.example.mall.user.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 腾讯课堂搜索【咕泡学院】
 * 官网：www.gupaoedu.com
 * 风骚的Mic 老师
 * create-date: 2019/7/31-19:34
 */
/**
 * @author dingrui
 * @date 2021-02-23
 * @description
 */
@Data
public class AddressDTO implements Serializable {

    private static final long serialVersionUID = 4784148368771527798L;

    /**
     * 主键
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
     * 是否是默认地址 1表示是 0表示不是
     */
    private Boolean isDefault;
}
