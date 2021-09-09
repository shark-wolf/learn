package com.demo.config;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClients;
import org.springframework.cloud.loadbalancer.core.RandomLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ReactorLoadBalancer;
import org.springframework.cloud.loadbalancer.core.RoundRobinLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.cloud.loadbalancer.support.LoadBalancerClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

/**
 * 负载均衡配置类
 *
 * @author: neo
 * @date: 2021/9/2
 * @version: 1.0.0
 */
@Configuration
@LoadBalancerClients(defaultConfiguration = Config.LoadBalancerConfig.class)
public class Config {

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    class LoadBalancerConfig {

        /**
         * 自定义负载均衡器
         *
         * */
        @Bean
        public ReactorLoadBalancer<ServiceInstance> rr(Environment environment, LoadBalancerClientFactory loadBalancerClientFactory) {
            String name = environment.getProperty(LoadBalancerClientFactory.PROPERTY_NAME);
            ObjectProvider<ServiceInstanceListSupplier> lazyProvider = loadBalancerClientFactory.getLazyProvider(name, ServiceInstanceListSupplier.class);
            ReactorLoadBalancer randomLoadBalancer;
            //随机
//            randomLoadBalancer = new RandomLoadBalancer(lazyProvider, name);
            //轮询
            randomLoadBalancer = new RoundRobinLoadBalancer(lazyProvider, name);
            //自定义
//            randomLoadBalancer = new MyLoadBalancer(lazyProvider, name);
            return randomLoadBalancer;
        }
    }
}
