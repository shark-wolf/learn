package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 启动类
 * @author neo
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AppProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppProviderApplication.class, args);
    }

}