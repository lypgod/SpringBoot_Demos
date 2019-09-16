package com.lypgod.springboot.demo.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;

import static org.junit.Assert.assertArrayEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootConfigApplication.class)
// 由于是Web项目，Junit需要模拟ServletContext，
// 因此我们需要给我们的测试类加上@WebAppConfiguration。
@WebAppConfiguration
public class StudentServiceTest {
    @Resource
    private StudentService studentService;

    @Test
    public void likeName() {
        assertArrayEquals(
                new Object[]{
                        studentService.likeName("小明2").size() > 0,
                        studentService.likeName("坏").size() > 0,
                        studentService.likeName("莉莉").size() > 0
                },
                new Object[]{
                        true,
                        false,
                        true
                }
        );
        //      assertTrue(studentService.likeName("小明2").size() > 0);
    }
}