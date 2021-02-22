package com.example.mall.user.service;

import com.example.mall.user.request.*;
import com.example.mall.user.response.*;

/**
 *@author dingrui
 *@date 2021-02-21
 *@description 快递邮寄地址
 */
public interface IAddressService {

    /**
     * @author dingrui
     * @date 2021/2/21
     * @param request
     * @return
     * @description 添加地址
     */
    AddAddressResponse addAddress(AddAddressRequest request);

    /**
     * @author dingrui
     * @date 2021/2/21
     * @param request
     * @return
     * @description 删除地址
     */
    DeleteAddressResponse deleteAddress(DeleteAddressRequest request);

    /**
     * @author dingrui
     * @date 2021/2/21
     * @param request
     * @return
     * @description 修改地址信息
     */
    UpdateAddressResponse updateAddress(UpdateAddressRequest request);

    /**
     * @author dingrui
     * @date 2021/2/21
     * @param request
     * @return
     * @description 根据用户id获取地址
     */
    GetAddressResponse getAddress(GetAddressRequest request);

    /**
     * @author dingrui
     * @date 2021/2/21
     * @param request
     * @return
     * @description 根据用户id获取地址列表
     */
    ListAddressResponse listAddress(ListAddressRequest request);
}
