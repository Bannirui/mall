package com.example.mall.user.request;

import com.example.mall.common.request.AbstractRequest;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 *@author dingrui
 *@date 2021-02-21
 *@description 查询会员请求
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class QueryMemberRequest extends AbstractRequest {

    private static final long serialVersionUID = -3576974375078645268L;

    /**
     * 用户会员id
     */
    @NotNull(message = "用户会员id不能为空")
    @NotBlank(message = "用户会员id不能为空")
    private Long userId;
}
