package com.lypgod.springboot.demo.event;

import com.lypgod.springboot.demo.event.simple.MsgPublisher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringEventApplicationTests {
    @Resource
    private MsgPublisher msgPublisher;

    @Test
    public void contextLoads() {
        msgPublisher.publish("Some Source", "lypgod", "I Love U");
    }

}
