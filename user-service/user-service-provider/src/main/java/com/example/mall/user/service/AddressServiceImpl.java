package com.example.mall.user.service;

import com.example.mall.user.request.*;
import com.example.mall.user.response.*;
import org.apache.dubbo.config.annotation.DubboService;

/**
 *@author dingrui
 *@date 2021-02-21
 *@description 快递邮寄地址
 */
@DubboService
public class AddressServiceImpl implements IAddressService {
    /**
     * @author dingrui
     * @date 2021/2/21
     * @param request
     * @return
     * @description 添加地址
     */
    @Override
    public AddAddressResponse addAddress(AddAddressRequest request) {
        return null;
    }

    /**
     * @author dingrui
     * @date 2021/2/21
     * @param request
     * @return
     * @description 删除地址
     */
    @Override
    public DeleteAddressResponse deleteAddress(DeleteAddressRequest request) {
        return null;
    }

    /**
     * @author dingrui
     * @date 2021/2/21
     * @param request
     * @return
     * @description 修改地址信息
     */
    @Override
    public UpdateAddressResponse updateAddress(UpdateAddressRequest request) {
        return null;
    }

    /**
     * @author dingrui
     * @date 2021/2/21
     * @param request
     * @return
     * @description 根据用户id获取地址
     */
    @Override
    public GetAddressResponse getAddress(GetAddressRequest request) {
        return null;
    }

    /**
     * @author dingrui
     * @date 2021/2/21
     * @param request
     * @return
     * @description 根据用户id获取地址列表
     */
    @Override
    public ListAddressResponse listAddress(ListAddressRequest request) {
        return null;
    }
}
