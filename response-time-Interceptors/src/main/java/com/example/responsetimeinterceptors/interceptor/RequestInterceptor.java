package com.example.responsetimeinterceptors.interceptor;

import com.example.responsetimeinterceptors.exception.InvalidHeaderException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;
@Slf4j
public class RequestInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        UUID requestId = UUID.randomUUID();
        request.setAttribute("start",System.currentTimeMillis());
        request.setAttribute("request-id",requestId);
        log.info("{} - işlenen istek {}" ,requestId,request.getRequestURI());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("{} - response in {} ms" , request.getAttribute("request-id"),System.currentTimeMillis() - (long) request.getAttribute("start"));
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("{} - completed in {} ms" , request.getAttribute("request-id"),System.currentTimeMillis() - (long) request.getAttribute("start"));

    }
}
