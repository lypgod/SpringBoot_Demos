package com.lypgod.springboot.demo.event.simple;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author lypgod
 */
@Component
public class MsgPublisher {
    @Resource
    ApplicationContext applicationContext;

    public void publish(Object source, String receiver, String content) {
        applicationContext.publishEvent(new SendMsgEvent(source, receiver, content));
    }
}