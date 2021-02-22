package com.example.mall.user.response;

import com.example.mall.common.response.AbstractResponse;
import com.example.mall.user.dto.AddressDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 *@author dingrui
 *@date 2021-02-21
 *@description 根据用户id获取地址
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class GetAddressResponse extends AbstractResponse {
    private static final long serialVersionUID = 8489350866547192798L;

    /**
     * 地址信息
     */
    private AddressDto addressDto;
}
