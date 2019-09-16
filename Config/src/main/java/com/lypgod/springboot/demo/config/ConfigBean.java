package com.lypgod.springboot.demo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author lypgod
 */
@ConfigurationProperties(prefix = "my")
@Component
@Data
public class ConfigBean {
   private String name;
   private int age;
   private int number;
   private String uuid;
   private int max;
   private String value;
   private String greeting;
}