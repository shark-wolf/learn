package com.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author neo
 */
@RestController
public class EchoController {

    @Value("${server.port}")
    String port;

    @GetMapping("/get")
    @ResponseBody
    public String get() {
        return port;
    }


}