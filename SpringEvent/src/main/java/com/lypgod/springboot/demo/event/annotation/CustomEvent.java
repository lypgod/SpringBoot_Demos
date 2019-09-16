package com.lypgod.springboot.demo.event.annotation;

import org.springframework.context.ApplicationEvent;

/**
 * @author lypgod
 */
public class CustomEvent extends ApplicationEvent {
    private MessageEntity messageEntity;

    public CustomEvent(Object source, MessageEntity messageEntity) {
        super(source);
        this.messageEntity = messageEntity;
    }

    public MessageEntity getMessageEntity() {
        return this.messageEntity;
    }
}