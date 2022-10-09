package com.qh.ruyitakeaway.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qh.ruyitakeaway.common.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * 自定义注销成功处理器
 *
 * @author qh
 * @date 2022/10/09 11:47:22
 */

public class CustomLogoutSuccessHandler implements LogoutSuccessHandler {
    @Autowired(required = false)
    private ObjectMapper jsonMapper;

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(jsonMapper.writeValueAsString(R.success("退出成功")));
    }
}
