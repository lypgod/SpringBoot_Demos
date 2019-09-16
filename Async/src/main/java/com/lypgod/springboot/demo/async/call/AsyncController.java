package com.lypgod.springboot.demo.async.call;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author lypgod
 */
@RestController
@Log4j2
public class AsyncController {
    @Resource
    SyncService syncService;

    @GetMapping("/async")
    public String doAsync() throws InterruptedException, ExecutionException, TimeoutException {
        long start = System.currentTimeMillis();
        log.info("方法执行开始：{}", start);

        //调用同步方法
        syncService.syncEvent();
        long syncTime = System.currentTimeMillis();
        log.info("同步方法用时：{}", syncTime - start);

        //调用异步方法
        Future<String> doFutrue = syncService.asyncEvent();
        //get方法会一直堵塞，直到等待执行完成才返回
        //get(long timeout, TimeUnit unit) 在设置时间类未返回结果，会直接排除异常TimeoutException，messages为null
        //2s
        log.info("回调结果：{}", doFutrue.get(2, TimeUnit.SECONDS));

        long asyncTime = System.currentTimeMillis();
        log.info("异步方法用时：{}", asyncTime - syncTime);
        log.info("方法执行完成：{}!", asyncTime);
        return "async!!!";
    }
}