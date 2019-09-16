package com.lypgod.springboot.demo.config;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lypgod
 */
@RestController
public class HelloController {
    @RequestMapping(value = "/hello")
    public String hello() {
        return "Hello World!";
    }
}