package com.qh.ruyitakeaway.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qh.ruyitakeaway.common.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * 自定义身份验证失败处理器
 *
 * @author qh
 * @date 2022/10/09 11:49:41
 */

public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {
    @Autowired(required = false)
    private ObjectMapper jsonMapper;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request,
                                        HttpServletResponse response,
                                        AuthenticationException exception)
            throws IOException, ServletException {
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(jsonMapper.writeValueAsString(R.success(exception.getMessage())));
    }
}
