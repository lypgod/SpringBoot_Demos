package com.lypgod.springboot.demo.event.simple;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.ApplicationEvent;

/**
 * @author lypgod
 */
@Log4j2
public class SendMsgEvent extends ApplicationEvent {
    String receiver;
    String content;

    public SendMsgEvent(Object source) {
        super(source);
    }

    SendMsgEvent(Object source, String receiver, String content) {
        super(source);
        this.receiver = receiver;
        this.content = content;
    }

    void output() {
        log.info("I have sent a msg to {}", this.receiver);
    }
}