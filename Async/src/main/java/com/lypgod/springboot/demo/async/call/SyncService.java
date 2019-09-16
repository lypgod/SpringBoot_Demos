package com.lypgod.springboot.demo.async.call;

import lombok.extern.log4j.Log4j2;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author lypgod
 */
@Component
@Log4j2
public class SyncService {
    @Async("asyncThreadPoolTaskExecutor")
    public Future<String> asyncEvent() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(1000);
        log.info("异步方法输出：{}!", System.currentTimeMillis());
        log.info("异步方法内部线程名称：{}!", Thread.currentThread().getName());
        return new AsyncResult<>("异步方法返回值");
    }

    public void syncEvent() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(1000);
        log.info("同步方法输出：{}!", System.currentTimeMillis());
    }
}