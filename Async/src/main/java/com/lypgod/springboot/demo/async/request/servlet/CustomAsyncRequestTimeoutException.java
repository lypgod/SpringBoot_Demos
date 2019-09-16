package com.lypgod.springboot.demo.async.request.servlet;

/**
 * @author lypgod
 */
public class CustomAsyncRequestTimeoutException extends RuntimeException {
    public CustomAsyncRequestTimeoutException(String uri){
        super(uri);
    }
}