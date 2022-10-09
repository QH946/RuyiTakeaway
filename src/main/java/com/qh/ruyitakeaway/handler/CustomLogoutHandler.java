package com.qh.ruyitakeaway.handler;

/**
 * @author 头发又黑又长
 * @Date 2022/7/24 20:56
 * @email zwb15083976291@163.com
 */

import lombok.SneakyThrows;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 自定义注销处理器
 *
 * @author qh
 * @date 2022/10/09 11:48:15
 */

public class CustomLogoutHandler implements LogoutHandler {


    @SneakyThrows
    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        request.getSession().removeAttribute("employee");
    }
}
