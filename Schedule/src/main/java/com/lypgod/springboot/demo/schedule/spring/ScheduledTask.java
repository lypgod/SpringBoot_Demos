package com.lypgod.springboot.demo.schedule.spring;

import lombok.extern.log4j.Log4j2;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Instant;

/**
 * @author lypgod
 */
@Component
@Log4j2
public class ScheduledTask {
    /**
     * 自动扫描，启动时间点之后5秒执行一次
     */
    @Async("scheduledPoolTaskExecutor")
    @Scheduled(fixedRate = 5000)
    public void getCurrentDate() {
        log.info("Scheduled定时任务执行：" + Instant.now());
    }
}