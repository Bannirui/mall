package com.example.mall.user.converter;

import com.example.mall.user.dal.model.Member;
import com.example.mall.user.request.UpdateMemberRequest;
import com.example.mall.user.response.QueryMemberResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 *@author dingrui
 *@date 2021-02-23
 *@description 会员信息 DTO转换
 */
@Mapper(componentModel = "spring")
public interface MemberConverter {

    @Mappings({})
    QueryMemberResponse model2Response(Member member);

    @Mappings({
            @Mapping(target = "id", source = "userId")
    })
    Member request2Model(UpdateMemberRequest request);
}
