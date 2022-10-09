package com.qh.ruyitakeaway.interceptor;


import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qh.ruyitakeaway.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户登录检查拦截器
 *
 * @author qh
 * @date 2022/10/09 11:58:47
 */
@Slf4j
@Component
public class UserLoginCheckInterceptor implements HandlerInterceptor {
    @Autowired(required = false)
    private ObjectMapper jsonMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("UserLoginCheckInterceptor ： {}", request.getRequestURI());
        Object user = request.getSession().getAttribute("user");
        // 如果 user 不为空
        if (ObjectUtils.isEmpty(user)) {
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(jsonMapper.writeValueAsString(R.error("NOTLOGIN")));
            return false;
        }
        return true;
    }
}
