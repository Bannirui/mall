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
 *@description 删除地址
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class DeleteAddressRequest extends AbstractRequest {
    private static final long serialVersionUID = -6349575158070496285L;

    /**
     * 地址id
     */
    @NotNull(message = "地址id不能为空")
    @Min(value = 1, message = "地址id无效")
    private Long addressId;
}
