package com.example.mall.user.response;

import com.example.mall.common.response.AbstractResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 *@author dingrui
 *@date 2021-02-21
 *@description 添加地址
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class AddAddressResponse extends AbstractResponse {
    private static final long serialVersionUID = -2047299774226161008L;
}
