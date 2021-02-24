package com.example.mall.user.converter;

import com.example.mall.user.dal.model.Member;
import com.example.mall.user.response.UserLoginResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 *@author dingrui
 *@date 2021-02-23
 *@description 用户 DTO转换
 */
@Mapper(componentModel = "spring")
public interface UserConverter {

    @Mappings({
            @Mapping(target = "userId", source = "id")
    })
    UserLoginResponse model2Response(Member member);
}
