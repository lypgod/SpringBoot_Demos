package com.lypgod.springboot.demo.async.request.servlet;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.context.request.async.WebAsyncTask;

import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author lypgod
 */
@Log4j2
@RestController
public class ServletController {

    @RequestMapping("/servlet/orig")
    public void todo(HttpServletRequest request,
                     HttpServletResponse response) throws Exception {
        //这里来个休眠
        TimeUnit.MILLISECONDS.sleep(500);

        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().println("这是【正常】的请求返回");
    }

    @RequestMapping("/servlet/async")
    public void todoAsync(HttpServletRequest request,
                          HttpServletResponse response) {
        AsyncContext asyncContext = request.startAsync();
        asyncContext.addListener(new AsyncListener() {
            @Override
            public void onTimeout(AsyncEvent event) {
                log.info("超时了：");
                //做一些超时后的相关操作
            }

            @Override
            public void onStartAsync(AsyncEvent event) {
                log.info("线程开始");
            }

            @Override
            public void onError(AsyncEvent event) {
                log.info("发生错误：", event.getThrowable());
            }

            @Override
            public void onComplete(AsyncEvent event) {
                log.info("执行完成");
                //这里可以做一些清理资源的操作
            }
        });

        //设置超时时间
        asyncContext.setTimeout(200);
        asyncContext.start(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(100);
                log.info("内部线程：" + Thread.currentThread().getName());
                asyncContext.getResponse().setCharacterEncoding("utf-8");
                asyncContext.getResponse().setContentType("text/html;charset=UTF-8");
                asyncContext.getResponse().getWriter().println("这是【异步】的请求返回");
            } catch (Exception e) {
                log.error("异常：", e);
            }
            //异步请求完成通知
            //此时整个请求才完成
            //其实可以利用此特性 进行多条消息的推送 把连接挂起。。
            asyncContext.complete();
        });
        //此时之类 request的线程连接已经释放了
        log.info("线程：" + Thread.currentThread().getName());
    }

    @RequestMapping("/callable")
    public Callable<String> callable() {
        log.info("外部线程：" + Thread.currentThread().getName());
        return () -> {
            log.info("内部线程：" + Thread.currentThread().getName());
            return "callable!";
        };
    }

    /**
     * 线程池
     */
    private static ExecutorService FIXED_THREAD_POOL = Executors.newFixedThreadPool(10);

    @RequestMapping("/deferredresult")
    public DeferredResult<String> deferredResult() {
        log.info("外部线程：" + Thread.currentThread().getName());
        //设置超时时间
        DeferredResult<String> result = new DeferredResult<>(60 * 1000L);
        //处理超时事件 采用委托机制
        result.onTimeout(() -> {
            log.error("DeferredResult超时");
            result.setResult("超时了!");
        });
        result.onCompletion(() -> {
            //完成后
            log.info("调用完成");
        });
        FIXED_THREAD_POOL.execute(() -> {
            //处理业务逻辑
            log.info("内部线程：" + Thread.currentThread().getName());
            //返回结果
            result.setResult("DeferredResult!!");
        });
        return result;
    }

    @RequestMapping("/webAsyncTask")
    public WebAsyncTask<String> webAsyncTask() {
        log.info("外部线程：" + Thread.currentThread().getName());
        WebAsyncTask<String> result = new WebAsyncTask<>(60 * 1000L, () -> {
            log.info("内部线程：" + Thread.currentThread().getName());
            return "WebAsyncTask!!!";
        });
        result.onTimeout(() -> {
            log.info("WebAsyncTask超时!!!");
            return "WebAsyncTask超时!!!";
        });
        result.onCompletion(() -> {
            //超时后 也会执行此方法
            log.info("WebAsyncTask执行结束");
        });
        return result;
    }
}