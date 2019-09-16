package com.lypgod.springboot.demo.fli.listener;

import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * @author lypgod
 */
@WebListener
@Log4j2
public class CustomListener implements ServletRequestListener {

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        log.info("监听器：初始化: {}", servletRequestEvent.getServletContext().getServerInfo());
    }

    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        log.info("监听器：销毁");
    }

}