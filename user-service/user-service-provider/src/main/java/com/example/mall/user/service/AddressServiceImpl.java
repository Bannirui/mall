package com.example.mall.user.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.mall.user.constant.SysRetCodeEnum;
import com.example.mall.user.converter.AddressConverter;
import com.example.mall.user.dal.model.Address;
import com.example.mall.user.dal.service.AddressDalService;
import com.example.mall.user.dto.AddressDto;
import com.example.mall.user.request.*;
import com.example.mall.user.response.*;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 *@author dingrui
 *@date 2021-02-21
 *@description 快递邮寄地址
 */
@DubboService
public class AddressServiceImpl implements IAddressService {

    @Autowired
    private AddressConverter converter;

    @Autowired
    private AddressDalService addressDalService;

    /**
     * @author dingrui
     * @date 2021/2/21
     * @param request
     * @return
     * @description 添加地址
     */
    @Override
    public AddAddressResponse addAddress(AddAddressRequest request) {
        AddAddressResponse response = new AddAddressResponse();
        Address address = converter.request2Model(request);
        if (addressDalService.save(address)) {
            response.setCode(SysRetCodeEnum.SUCCESS.getCode());
            response.setMsg(SysRetCodeEnum.SUCCESS.getMsg());
        } else {
            response.setCode(SysRetCodeEnum.SYSTEM_ERROR.getCode());
            response.setMsg(SysRetCodeEnum.SYSTEM_ERROR.getMsg());
        }
        return response;
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
        DeleteAddressResponse response = new DeleteAddressResponse();
        if (addressDalService.removeById(request.getAddressId())) {
            response.setCode(SysRetCodeEnum.SUCCESS.getCode());
            response.setMsg(SysRetCodeEnum.SUCCESS.getMsg());
        } else {
            response.setCode(SysRetCodeEnum.DATA_NOT_EXIST.getCode());
            response.setMsg(SysRetCodeEnum.DATA_NOT_EXIST.getMsg());
        }
        return response;
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
        UpdateAddressResponse response = new UpdateAddressResponse();
        Address address = converter.request2Model(request);
        if (addressDalService.updateById(address)) {
            response.setCode(SysRetCodeEnum.SUCCESS.getCode());
            response.setMsg(SysRetCodeEnum.SUCCESS.getMsg());
        } else {
            response.setCode(SysRetCodeEnum.SYSTEM_ERROR.getCode());
            response.setMsg(SysRetCodeEnum.SYSTEM_ERROR.getMsg());
        }
        return response;
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
        GetAddressResponse response = new GetAddressResponse();
        Address address = addressDalService.getById(request.getAddressId());
        AddressDto addressDto = converter.model2Dto(address);
        response.setCode(SysRetCodeEnum.SUCCESS.getCode());
        response.setMsg(SysRetCodeEnum.SUCCESS.getMsg());
        response.setAddressDto(addressDto);
        return response;
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
        ListAddressResponse response = new ListAddressResponse();
        List<Address> addressList = addressDalService.list(new LambdaQueryWrapper<Address>().eq(Address::getUserId, request.getUserId()));
        List<AddressDto> addressDtoList = converter.modelList2DtoList(addressList);
        response.setCode(SysRetCodeEnum.SUCCESS.getCode());
        response.setMsg(SysRetCodeEnum.SUCCESS.getMsg());
        response.setAddressDtos(addressDtoList);
        return response;
    }
}
