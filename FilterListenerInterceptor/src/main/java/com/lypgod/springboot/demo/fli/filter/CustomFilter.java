package com.lypgod.springboot.demo.fli.filter;

import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import java.io.IOException;

/**
 * 注册器名称为customFilter,拦截的url为所有
 *
 * @author lypgod
 */
@Log4j2
public class CustomFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {
        log.info("filter1 初始化");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        log.info("filter1 请求处理");

        // 对request、response进行一些预处理，比如设置请求编码
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        // 链路 直接传给下一个过滤器
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        log.info("filter1 销毁");
    }
}