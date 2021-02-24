package com.example.mall.user.config.kafka;

import com.example.mall.user.kafka.KafkaDecoder;
import com.example.mall.user.kafka.KafkaEncoder;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.listener.ContainerProperties;

import java.util.Map;

/**
 *@author dingrui
 *@date 2021-02-24
 *@description kafka
 */
@Configuration
public class KafkaConfig {

    /**
     * 该类是在spring boot autoconfig 中就初始化了
     */
    @Autowired
    private KafkaProperties kafkaProperties;

    /**
     * @author dingrui
     * @date 2021/2/24
     * @return
     * @description kafka生产者工厂
     */
    @Bean
    public KafkaProducerFactory kafkaProducerFactory() {
        Map<String, Object> producerProperties = kafkaProperties.buildProducerProperties();
        producerProperties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers());
        producerProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        // producerProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        // 自定义消息序列化
        producerProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaEncoder.class);
        producerProperties.put(ProducerConfig.ACKS_CONFIG, "-1");
        return new KafkaProducerFactory(producerProperties);
    }

    /**
     * @author dingrui
     * @date 2021/2/24
     * @return
     * @description kafka消费者工厂
     */
    @Bean
    public KafkaConsumerFactory kafkaConsumerFactory() {
        Map<String, Object> consumerProperties = kafkaProperties.buildProducerProperties();
        consumerProperties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers());
        consumerProperties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        // consumerProperties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        // 自定义消息反序列化
        consumerProperties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, KafkaDecoder.class);
        consumerProperties.put(ConsumerConfig.GROUP_ID_CONFIG, "default");
        // 消费者的自动提交方式关闭
        consumerProperties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
        consumerProperties.put("spring.json.trusted.packages", "com.gpmall.user.dal.entitys,com.gpmall.user.dal.*");
        /**
         * earliest:当各分区下有已提交的offset时，从提交的offset开始消费；无提交的offset时，从头开始消费
         * latest: 当各分区下有已提交的offset时，从提交的offset开始消费；无提交的offset时，消费新产生的该分区下的数据
         * none: topic各分区都存在已提交的offset时，从offset后开始消费；只要有一个分区不存在已提交的offset，则抛出异常
         */
        consumerProperties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        return new KafkaConsumerFactory(consumerProperties);
    }

    /**
     * @author dingrui
     * @date 2021/2/24
     * @return
     * @description kafka消费者监听者工厂
     */
    @Bean
    public KafkaListenerContainerFactory kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory conFactory = new ConcurrentKafkaListenerContainerFactory<>();
        conFactory.setConsumerFactory(kafkaConsumerFactory());
        // 设置消费者消费消息后的提交方式为手动提交
        conFactory.getContainerProperties().setAckMode(ContainerProperties.AckMode.MANUAL);
        return conFactory;
    }

    /**
     * @author dingrui
     * @date 2021/2/24
     * @return
     * @description kafka模板方法 自定义
     */
    @Bean(name = "customerKafkaTemplate")
    public KafkaTemplate customerKafkaTemplate() {
        KafkaTemplate template = new KafkaTemplate<>(kafkaProducerFactory());
        return template;
    }
}
