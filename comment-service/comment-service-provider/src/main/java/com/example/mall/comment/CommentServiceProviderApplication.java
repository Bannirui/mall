package com.example.mall.comment;

import com.alibaba.nacos.api.config.annotation.NacosConfigurationProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 *@author dingrui
 *@date 2021-02-24
 *@description 评论相关服务
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@MapperScan(value = "com.example.mall.comment.dal.mapper")
@EnableAspectJAutoProxy
@EnableDiscoveryClient
@NacosConfigurationProperties(dataId = "comment-service-provider", groupId = "mall", autoRefreshed = true)
public class CommentServiceProviderApplication {

    public static void main(String[] args) {

    }
}
