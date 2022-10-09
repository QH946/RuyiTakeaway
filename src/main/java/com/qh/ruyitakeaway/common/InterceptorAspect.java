package com.qh.ruyitakeaway.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 拦截器切面
 *
 * @author qh
 * @date 2022/10/09 13:14:23
 */
@Slf4j
@Component("pathReqAspect")
@Aspect
public class InterceptorAspect {

    @Autowired(required = false)
    private ObjectMapper jsonMapper;

    /**
     * 对拦截器的所有的 preHandle 方法进行拦截
     */
    @Pointcut("execution(* *..controller.*.*(..))")
    public void pointcutController() {
    }


    @Around("pointcutController()")
    public Object preHandleAspect(ProceedingJoinPoint joinPoint) throws Throwable {


        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        // 从获取RequestAttributes中获取HttpServletRequest的信息
        HttpServletRequest request = (HttpServletRequest) Objects.requireNonNull(requestAttributes).resolveReference(RequestAttributes.REFERENCE_REQUEST);

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        // 获取controller 名称
        String ControllerName = ((Api) signature.getDeclaringType().getAnnotation(Api.class)).value();
        // 获取 method 上的说明
        String operation = signature.getMethod().getAnnotation(ApiOperation.class).value();
        // 获取参数
        String params = Arrays.toString(joinPoint.getArgs());
        Object result = null;
        try {
            result = joinPoint.proceed();
        } catch (Exception e) {
            log.error("异常信息: {}", e.getMessage());
            throw e;
        } finally {
            if (!request.getRequestURI().equals("/common/download")) {
                log.info("访问路径: {} method : {}", request.getRequestURI(), request.getMethod());
                log.info("执行方法: {}.{}", joinPoint.getTarget().getClass().getName(), signature.getMethod().getName());
                log.info("执行方法说明: {}:{}", ControllerName, operation);
                log.info("参数类型: {}", Arrays.stream(signature.getMethod().getParameters()).map(item -> item.getName()).collect(Collectors.toList()).toString());
                log.info("参数: {}", params);
                log.info("执行结果: {}", jsonMapper.writeValueAsString(result));
            }
        }
        return result;

    }

}
