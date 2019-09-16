package com.lypgod.springboot.demo.cache;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SimpleServiceTest {
    @Resource
    SimpleService simpleService;

    @Test
    public void getTime() throws InterruptedException {
        long time1 = this.simpleService.getTime();
        TimeUnit.MILLISECONDS.sleep(100);
        long time2 = this.simpleService.getTime();
        Assert.assertEquals(time1, time2);
    }
}