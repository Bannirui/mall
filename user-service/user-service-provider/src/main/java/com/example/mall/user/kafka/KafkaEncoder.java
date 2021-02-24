package com.example.mall.user.kafka;

import org.apache.kafka.common.serialization.Serializer;

/**
 *@author dingrui
 *@date 2021-02-24
 *@description 自定义kafka消息编码器
 */
public class KafkaEncoder implements Serializer<Object> {
    @Override
    public byte[] serialize(String s, Object o) {
        return new byte[0];
    }
}
