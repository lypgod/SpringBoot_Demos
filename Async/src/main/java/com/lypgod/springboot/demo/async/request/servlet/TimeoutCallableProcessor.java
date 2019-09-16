package com.lypgod.springboot.demo.async.request.servlet;

import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.async.CallableProcessingInterceptor;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;
import java.util.concurrent.Callable;

/**
 * @author lypgod
 */
public class TimeoutCallableProcessor implements CallableProcessingInterceptor {
    @Override
    public <T> Object handleTimeout(NativeWebRequest request, Callable<T> task) {
        HttpServletRequest httpRequest = request.getNativeRequest(HttpServletRequest.class);
        //记录超时的url地址
        return new CustomAsyncRequestTimeoutException(Objects.requireNonNull(httpRequest).getRequestURI());
    }
}