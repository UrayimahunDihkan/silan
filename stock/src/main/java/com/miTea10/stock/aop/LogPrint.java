package com.miTea10.stock.aop;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @Description: 日志打印AOP实现
 * @author: miTea
 * @date: 2022/2/19 8:50 下午
 **/
@Component
@Aspect
@Slf4j
@RequiredArgsConstructor
public class LogPrint {

    private static final String REQUEST_START = "请求开始";
    private static final String REQUEST_END = "请求结束";
    private static final String PRINT_LEFT = "<------------------------------< {} >------------------------------>";
    private static final String REQUEST_RESPONSE = "<------------------------------< 响应 >------------------------------>";
    private static final String REQUEST_RESPONSE_NULL = "返回值为null";
    private static final String REQUEST_RESPONSE_BODY = "响应体：{}";
    private static final String TARGET_START = "<--- 目标为：{} --->";
    private static final String REQUEST_INTERFACE = "  请求接口：{}";
    private static final String REQUEST_ADDRESS= "  请求地址：{}";
    private static final String REQUEST_TYPE = "  请求类型：{}";
    private static final String REQUEST_METHOD = "  请求方法：{}";
    private static final String REQUEST_PARAM = "  请求参数：{}";
    private static final String NULL = "";

    private final HttpServletRequest request;

    /**
     * 切面，
     * 需要排除：定时任务、用户行为数据监控
     */
    @Pointcut("(execution(* com.miTea10.stock.controller.*.*(..)))")
    public void webLog() {
        // 拦截接口的切面
    }

    /**
     * 前置通知
     * @param point 切点
     */
    @Before("webLog()")
    public void before(JoinPoint point) {
        logPrintCommon(point, REQUEST_START);
    }

    /**
     * 后置通知
     * @param point 切点
     */
    @After("webLog()")
    public void after(JoinPoint point) {
        logPrintCommon(point, REQUEST_END);
    }

    /**
     *  返回前的通知
     * @param res 响应体
     */
    @AfterReturning(returning = "res", pointcut = "webLog()")
    public void doAfterReturning(Object res) {
        log.info(REQUEST_RESPONSE);
        String result = res != null ? res.toString() : REQUEST_RESPONSE_NULL;
        log.info(REQUEST_RESPONSE_BODY, result);
        log.info(NULL);
    }

    /**
     * 通知体
     * @param point 切点
     * @param title 标题
     */
    private void logPrintCommon(JoinPoint point, String title) {
        log.info(PRINT_LEFT, title);
        log.info(TARGET_START, point.getSignature().getDeclaringTypeName());
        log.info(REQUEST_INTERFACE, (request.getRequestURL() == null ? "" : request.getRequestURL().toString()));
        log.info(REQUEST_ADDRESS, request.getRemoteAddr());
        log.info(REQUEST_TYPE, request.getMethod());
        log.info(REQUEST_METHOD, point.getSignature().getName());
        log.info(REQUEST_PARAM, Arrays.toString(point.getArgs()));
        log.info(NULL);
    }
}

