package com.example.mall.user.config.kafka;

import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.util.Map;

/**
 *@author dingrui
 *@date 2021-02-24
 *@description 消费者工厂
 */
public class KafkaConsumerFactory extends DefaultKafkaConsumerFactory {

    public KafkaConsumerFactory(Map configs) {
        super(configs);
    }
}
