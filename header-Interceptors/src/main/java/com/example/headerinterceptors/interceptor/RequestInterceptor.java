package com.example.headerinterceptors.interceptor;

import com.example.headerinterceptors.exception.InvalidHeaderException;
import io.micrometer.common.util.StringUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

public class RequestInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String header = request.getHeader("auth-key");
        if (header == null){
            throw new InvalidHeaderException("Invalid Request");
        }
            return true;
    }


}
