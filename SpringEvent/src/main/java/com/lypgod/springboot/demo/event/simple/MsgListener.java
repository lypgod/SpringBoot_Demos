package com.lypgod.springboot.demo.event.simple;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author lypgod
 */
@Component
@Log4j2
public class MsgListener implements ApplicationListener<SendMsgEvent> {
    @Override
    public void onApplicationEvent(SendMsgEvent sendMsgEvent) {
        sendMsgEvent.output();
        log.info("{} received a msg: {}", sendMsgEvent.receiver, sendMsgEvent.content);
    }
}