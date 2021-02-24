package com.example.mall.user.request;

import com.example.mall.common.request.AbstractRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 *@author dingrui
 *@date 2021-02-21
 *@description 根据用户id获取地址
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class GetAddressRequest extends AbstractRequest {
    private static final long serialVersionUID = 7601658902425423409L;

    /**
     * 用户id
     */
    @NotNull(message = "地址id不能为空")
    @Min(value = 1, message = "地址id无效")
    private Long addressId;
}
