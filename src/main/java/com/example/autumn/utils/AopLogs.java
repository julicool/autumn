package com.example.autumn.utils;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Jagi
 * @Date 2021/2/8
 */

@Aspect
@Component
@Slf4j
@Order(1)
public class AopLogs {
    @Pointcut("execution(public * com.example.autumn.controller..*.*(..))")
    public void methods(){}

    @Before("methods()")
    public void doBefore(JoinPoint joinPoint){
        // 获取前端的请求数据
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 打印请求数据
        log.info("=============== 接收到前端请求，开始打印日志 ===============");
        log.info("URL:[{}]",request.getRequestURL().toString() + "?" + request.getQueryString());
        log.info("Class_Method：[{}]",joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());

        log.info("====================== 日志打印完毕 ======================");
    }


}
