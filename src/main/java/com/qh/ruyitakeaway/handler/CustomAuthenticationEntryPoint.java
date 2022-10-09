package com.qh.ruyitakeaway.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qh.ruyitakeaway.common.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;


/**
 * 自定义身份验证入口处理器
 *
 * @author qh
 * @date 2022/10/09 11:49:28
 */

public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Autowired(required = false)
    private ObjectMapper jsonMapper;


    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        HashMap<String, Object> result = new HashMap<>();

        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(jsonMapper.writeValueAsString( R.error("NOTLOGIN")));
    }
}
