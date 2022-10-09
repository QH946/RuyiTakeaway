package com.qh.ruyitakeaway.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qh.ruyitakeaway.common.BaseContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 登录设置拦截器
 *
 * @author qh
 * @date 2022/10/09 14:55:31
 */
@Slf4j
@Component
public class LoginSettingInterceptor implements HandlerInterceptor {

    @Autowired(required = false)
    private ObjectMapper jsonMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("拦截到的url：{}", request.getRequestURI());
        Object employee = request.getSession().getAttribute("employee");
        // 如果 employee 不为空
        if (!ObjectUtils.isEmpty(employee)) {
            // 添加到 threadLocal中去
            BaseContext.setCurrentId((Long) employee);
            return true;
        }

        Object user = request.getSession().getAttribute("user");
        // 如果 user 不为空
        if (!ObjectUtils.isEmpty(user)) {
            // 添加到 threadLocal中去
            BaseContext.setCurrentId((Long) user);
            return true;
        }
        return true;
    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // 动态的清除
        BaseContext.removeCurrentId();
    }
}
