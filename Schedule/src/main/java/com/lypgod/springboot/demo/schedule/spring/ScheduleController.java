package com.lypgod.springboot.demo.schedule.spring;

import lombok.extern.log4j.Log4j2;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.Instant;

/**
 * @author lypgod
 */
@RestController
@Log4j2
public class ScheduleController {
    @Resource
    TaskScheduler taskScheduler;

    @GetMapping("/poolTask")
    public String threadPoolTaskScheduler() {
        //每3秒执行一次
        taskScheduler.schedule(() -> log.info("ThreadPoolTaskScheduler定时任务：" + Instant.now()), new CronTrigger("0/3 * * * * ?"));
        return "ThreadPoolTaskScheduler!";
    }
}
