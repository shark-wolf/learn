package com.demo.controller;

import com.demo.feign.EchoRemote;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: neo
 * @date: 2021/9/7
 * @version: 1.0.0
 */
@RestController
public class EchoController {

    @Resource
    private EchoRemote echoRemote;


    @GetMapping("/call")
    @ResponseBody
    public String call() {
        return echoRemote.get();
    }

}
