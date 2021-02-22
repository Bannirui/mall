package com.example.mall.user.response;

import com.example.mall.common.response.AbstractResponse;
import lombok.*;

/**
 *@author dingrui
 *@date 2021-02-21
 *@description 修改用户头像
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class AvatarUpdateResponse extends AbstractResponse {
    private static final long serialVersionUID = -2948417414822033322L;
}
