package com.example.mall.user;

import com.alibaba.nacos.api.config.annotation.NacosConfigurationProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 *@author dingrui
 *@date 2021-02-21
 *@description
 */
@SpringBootApplication
@EnableDiscoveryClient
@NacosConfigurationProperties(dataId = "mall-user-web", groupId = "mall", autoRefreshed = true)
public class MallUserWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(MallUserWebApplication.class, args);
    }
}
