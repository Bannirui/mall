package com.example.mall.user.response;

import com.example.mall.common.response.AbstractResponse;
import com.example.mall.user.dto.AddressDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

/**
 *@author dingrui
 *@date 2021-02-21
 *@description 根据用户id获取地址列表
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class ListAddressResponse extends AbstractResponse {

    private static final long serialVersionUID = -1276589179934751469L;
    /**
     * 地址信息列表
     */
    private List<AddressDto> addressDtos;
}
