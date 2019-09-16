package com.lypgod.springboot.demo.schedule.java;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author lypgod
 */
@RestController
@Log4j2
public class TimerController {
    @GetMapping("/timer")
    public String doTimer() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                log.info("Timer定时任务启动：" + new Date());
            }
            //延迟1秒启动，每1秒执行一次
        }, 1000, 1000);
        return "timer";
    }

    @GetMapping("/executor")
    public String scheduledExecutorService() {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(10);
        //首次延迟1秒，之后每1秒执行一次
        service.scheduleAtFixedRate(() -> log.info("ScheduledExecutorService定时任务执行：" + new Date()), 1, 1, TimeUnit.SECONDS);
        log.info("ScheduledExecutorService定时任务启动：" + new Date());
        return "ScheduledExecutorService!";
    }
}
