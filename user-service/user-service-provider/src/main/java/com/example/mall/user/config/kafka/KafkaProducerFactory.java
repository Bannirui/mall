package com.example.mall.user.config.kafka;

import org.springframework.kafka.core.DefaultKafkaProducerFactory;

import java.util.Map;

/**
 *@author dingrui
 *@date 2021-02-24
 *@description 生产者工厂
 */
public class KafkaProducerFactory extends DefaultKafkaProducerFactory {

    public KafkaProducerFactory(Map configs) {
        super(configs);
    }
}
