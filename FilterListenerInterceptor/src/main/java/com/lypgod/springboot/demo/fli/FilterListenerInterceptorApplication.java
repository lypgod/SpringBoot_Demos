package com.lypgod.springboot.demo.fli;

import com.lypgod.springboot.demo.fli.filter.CustomFilter;
import com.lypgod.springboot.demo.fli.filter.CustomFilter2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;

import javax.servlet.Filter;

/**
 * @author lypgod
 */
@SpringBootApplication
@ServletComponentScan
public class FilterListenerInterceptorApplication {

    public static void main(String[] args) {
        SpringApplication.run(FilterListenerInterceptorApplication.class, args);
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBeanForCustomFilter1() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        //当过滤器有注入其他bean类时，可直接通过@bean的方式进行实体类过滤器，这样不可自动注入过滤器使用的其他bean类。
        //当然，若无其他bean需要获取时，可直接new CustomFilter()，也可使用getBean的方式。
        registration.setFilter(customFilter1());
        //过滤器名称
        registration.setName("customFilter1");
        //拦截路径
        registration.addUrlPatterns("/*");
        //设置顺序
        registration.setOrder(3);
        return registration;
    }

    @Bean
    public Filter customFilter1() {
        return new CustomFilter();
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBeanForCustomFilter2() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new CustomFilter2());
        registration.setName("customFilter2");
        registration.addUrlPatterns("/*");
        registration.setOrder(2);
        return registration;
    }
}
