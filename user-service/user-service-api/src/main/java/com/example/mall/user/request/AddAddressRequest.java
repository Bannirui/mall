package com.example.mall.user.request;

import com.example.mall.common.request.AbstractRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 *@author dingrui
 *@date 2021-02-21
 *@description 添加地址
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class AddAddressRequest extends AbstractRequest {
    private static final long serialVersionUID = 819236664291056910L;

    /**
     * 用户id
     */
    @NotNull(message = "用户id不能为空")
    @Min(value = 1, message = "用户id不合理")
    private Long userId;

    /**
     * 用户名
     */
    @NotNull(message = "用户名不能为空")
    @NotBlank(message = "用户名不能为空")
    private String userName;

    /**
     * 电话
     */
    @NotNull(message = "电话不能为空")
    @NotBlank(message = "电话不能为空")
    private String tel;

    /**
     * 街道名称
     */
    @NotNull(message = "街道名称不能为空")
    @NotBlank(message = "街道名称不能为空")
    private String streetName;

    /**
     * 默认地址
     */
    private Integer isDefault;
}
