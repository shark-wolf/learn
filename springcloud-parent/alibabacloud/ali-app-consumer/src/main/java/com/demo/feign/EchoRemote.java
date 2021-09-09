package com.demo.feign;


import com.demo.fallback.EchoFallBackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 定义feign接口
 *
 * @author: neo
 * @date: 2021/9/7
 * @version: 1.0.0
 */
@FeignClient(name = "${server.provider}", fallbackFactory = EchoFallBackFactory.class)
public interface EchoRemote {

    /**
     * 接口
     *
     * @return
     */
    @GetMapping("/get")
    String get();
}
