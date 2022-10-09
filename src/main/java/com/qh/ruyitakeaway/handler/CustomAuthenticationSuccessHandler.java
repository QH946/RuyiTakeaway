package com.qh.ruyitakeaway.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qh.ruyitakeaway.common.R;
import com.qh.ruyitakeaway.dto.UserDto;
import com.qh.ruyitakeaway.entity.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * 自定义身份验证成功处理器
 *
 * @author qh
 * @date 2022/10/09 11:49:20
 */
@Slf4j

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired(required = false)
    private ObjectMapper jsonMapper;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        // 获取用户信息
        UserDto user = (UserDto) authentication.getPrincipal();
        Employee employee = user.getEmployee();
        request.getSession().setAttribute("employee",employee.getId());
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(jsonMapper.writeValueAsString(R.success(user.getEmployee())));

    }
}
