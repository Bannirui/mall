package com.example.mall.user.kafka;

import org.apache.kafka.common.serialization.Deserializer;

/**
 *@author dingrui
 *@date 2021-02-24
 *@description 自定义kafka消息解码器
 */
public class KafkaDecoder implements Deserializer<Object> {
    @Override
    public Object deserialize(String s, byte[] bytes) {
        return null;
    }
}
