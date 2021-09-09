package com.demo.fallback;


import com.demo.feign.EchoRemote;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * 熔断工厂类
 * @author: neo
 * @date: 2021/9/7
 * @version: 1.0.0
 */
@Component
public class EchoFallBackFactory implements FallbackFactory<EchoRemote> {

    /**
     * Returns an instance of the fallback appropriate for the given cause.
     *
     * @param cause cause of an exception.
     * @return fallback
     */
    @Override
    public EchoRemote create(Throwable cause) {
        System.out.printf("异常：%s", cause.getMessage());
        return () -> "熔断";
    }
}
