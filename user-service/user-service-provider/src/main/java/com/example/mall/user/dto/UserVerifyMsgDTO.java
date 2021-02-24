package com.example.mall.user.dto;


import com.example.mall.user.kafka.KafkaMsgBase;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 *@author dingrui
 *@date 2021-02-24
 *@description 用户注册 发送kafka消息体
 */
@Data
@Builder
public class UserVerifyMsgDTO implements Serializable, KafkaMsgBase {
    private static final long serialVersionUID = 1202608638865169181L;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 生成验证码时的uuid
     */
    private String uuid;

    /**
     * 注册邮箱
     */
    private String email;
}
