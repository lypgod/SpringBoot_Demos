package com.lypgod.springboot.demo.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author lypgod
 */
@RestController
@EnableConfigurationProperties({ConfigBean.class, Person.class})
public class TestController {
    @Resource
    ConfigBean configBean;

    @RequestMapping(value = "/aaa")
    public String print() {
        return configBean.getGreeting()
                + " >>>> " + configBean.getName()
                + " >>>> " + configBean.getUuid()
                + " >>>> " + configBean.getMax();
    }

    @Resource
    Person person;

    @RequestMapping(value = "/person")
    public Person person() {
        return person;
    }
}