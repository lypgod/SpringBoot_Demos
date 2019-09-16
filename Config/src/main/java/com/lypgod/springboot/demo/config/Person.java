package com.lypgod.springboot.demo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author lypgod
 */
@Component
@PropertySource(value = "classpath:person.properties")
@ConfigurationProperties(prefix = "person1")
@Data
public class Person {
  private String name;
  private int age;
}