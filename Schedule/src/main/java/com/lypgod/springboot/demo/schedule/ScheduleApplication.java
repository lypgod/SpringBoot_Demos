package com.lypgod.springboot.demo.schedule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author lypgod
 */
@SpringBootApplication
@EnableScheduling
public class ScheduleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScheduleApplication.class, args);
    }

}
