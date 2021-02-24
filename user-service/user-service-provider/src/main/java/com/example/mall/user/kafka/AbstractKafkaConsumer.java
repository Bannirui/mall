package com.example.mall.user.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;

/**
 * @author dingrui
 * @date 2021-02-24
 * @description kafka生产者
 */
public abstract class AbstractKafkaConsumer {

    final String topic;

    String groupId;

    public AbstractKafkaConsumer(String topic, String groupId) {
        this.topic = topic;
        this.groupId = groupId;
    }

    /**
     * @author dingrui
     * @date 2021/2/24
     * @param msg
     * @return
     * @description 对消息的处理
     */
    protected abstract void msgHandler(Object msg);

    /**
     * @author dingrui
     * @date 2021/2/24
     * @param msg
     * @param acknowledgment
     * @return
     * @description 指定消费某一个分区
     * topic = "user-register-succ-topic"
     * group_id = "mail-group-id"
     *
     * @KafkaListener(id = "",topicPartitions ={@TopicPartition(topic=topic,partitions = {"1"})},containerFactory = "userRegisterSuccKafkaListenerContainerFactory",groupId = group_id)
     */
    @KafkaListener(id = "", topics = "user-register-topic", containerFactory = "userRegisterSuccKafkaListenerContainerFactory", groupId = "mail-group")
    public void receiveInfo(Object msg, @Autowired Acknowledgment acknowledgment) {
        try {
            // 自定的消息处理
            msgHandler(msg);
            // 手动提交消息
            acknowledgment.acknowledge();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
