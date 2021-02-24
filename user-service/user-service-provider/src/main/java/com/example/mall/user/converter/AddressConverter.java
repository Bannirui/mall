package com.example.mall.user.converter;

import com.example.mall.user.dal.model.Address;
import com.example.mall.user.dto.AddressDto;
import com.example.mall.user.request.AddAddressRequest;
import com.example.mall.user.request.UpdateAddressRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

/**
 *@author dingrui
 *@date 2021-02-23
 *@description 地址信息 DTO转换
 */
@Mapper(componentModel = "spring")
public interface AddressConverter {

    @Mappings({
            @Mapping(target = "addressId", source = "id")
    })
    AddressDto model2Dto(Address address);

    List<AddressDto> modelList2DtoList(List<Address> addressList);

    @Mappings({})
    Address request2Model(AddAddressRequest request);

    @Mappings({
            @Mapping(target = "id", source = "addressId")
    })
    Address request2Model(UpdateAddressRequest request);
}
