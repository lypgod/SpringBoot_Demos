package com.lypgod.springboot.demo.event.annotation;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author lypgod
 */
@RestController
@RequestMapping("/push")
@Log4j2
public class DemoController {
    /**
     * 注入 事件发布类
     */
    @Resource
    ApplicationEventPublisher eventPublisher;

    @GetMapping
    public String push(String code, String message) {
        log.info("发布applicationEvent事件:{}, {}", code, message);
        eventPublisher.publishEvent(new CustomEvent(this, MessageEntity.builder().code(code).message(message).build()));
        return "事件发布成功!";
    }

    @GetMapping("/obj")
    public String pushObject(String code, String message) {
        log.info("发布对象事件:{}, {}", code, message);
        eventPublisher.publishEvent(MessageEntity.builder().code(code).message(message).build());
        return "对象事件发布成功!";
    }
}