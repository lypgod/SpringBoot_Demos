package com.lypgod.springboot.demo.event;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author lypgod
 */
@SpringBootApplication
@EnableAsync
@Log4j2
public class SpringEventApplication {

    public static void main(String[] args) {
        SpringApplication app =new SpringApplication(SpringEventApplication.class);
        //加入自定义的监听类
        app.addListeners(new MyApplicationStartingEventListener());
        app.run(args);
        log.info("spring-boot-event-listener-chapter32启动!");
    }

}
