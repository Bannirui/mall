package com.example.mall.user.request;

import com.example.mall.common.request.AbstractRequest;
import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 *@author dingrui
 *@date 2021-02-21
 *@description 修改用户头像
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class AvatarUpdateRequest extends AbstractRequest {
    private static final long serialVersionUID = 8996509167311477748L;

    /**
     * 会员id
     */
    @NotNull(message = "会员id不能为空")
    @Min(value = 1, message = "会员id无效")
    private Long userId;

    /**
     * 头像地址
     */
    @NotNull(message = "头像地址不能为空")
    @NotBlank(message = "头像地址不能为空")
    private String avatarFile;
}
