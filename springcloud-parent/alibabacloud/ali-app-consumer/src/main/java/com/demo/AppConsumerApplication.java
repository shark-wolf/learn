package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 启动类
 * @EnableDiscoveryClient 开启nacos 服务发现
 * @EnableFeignClients 开启feign
 * @author neo
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class AppConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppConsumerApplication.class, args);
    }

}