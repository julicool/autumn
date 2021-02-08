package com.example.autumn.utils;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.boot.configurationprocessor.json.JSONObject;
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
        log.info("=============== 打印前端请求 ===============");
        log.info("URL:[{}]",request.getRequestURL().toString() + "?" + request.getQueryString());
        log.info("Class_Method：[{}]",joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());

    }

    @AfterReturning(returning = "object",pointcut = "methods()")
    public void doAfter(Object object){
        log.info("=============== 打印后端返回 ===============");
        log.info("Response:[{}]", JSON.toJSONString(object));
    }


}
