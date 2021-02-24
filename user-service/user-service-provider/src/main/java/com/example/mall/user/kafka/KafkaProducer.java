package com.example.mall.user.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 *@author dingrui
 *@date 2021-02-24
 *@description kafka生产者
 */
@Component
public class KafkaProducer<T extends KafkaMsgBase> {

    @Autowired
    @Qualifier("customerKafkaTemplate")
    private KafkaTemplate kafkaTemplate;

    private final static String TOPIC = "user-register-topic";

    /**
     * @author dingrui
     * @date 2021/2/24
     * @param msg 要发送的消息
     * @return
     * @description 生产者发送消息
     */
    public void sendMsg(T msg) {
        try {
            kafkaTemplate.send(TOPIC, msg);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
