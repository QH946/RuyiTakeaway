package com.qh.ruyitakeaway.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.session.NullAuthenticatedSessionStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
import org.springframework.util.DigestUtils;
import org.springframework.util.ObjectUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * 自定义身份验证过滤器
 *
 * @author qh
 * @date 2022/10/09 10:11:52
 */
public class JwtAuthenticationTokenFilter extends UsernamePasswordAuthenticationFilter {
    @Autowired(required = false)
    private ObjectMapper jsonMapper;

    private ThreadLocal<Map<String, String>> threadLocal = new ThreadLocal<>();

    private SessionAuthenticationStrategy sessionStrategy = new NullAuthenticatedSessionStrategy();
    private boolean continueChainBeforeSuccessfulAuthentication = false;


    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        Authentication authentication = super.attemptAuthentication(request, response);
        // 清除掉 threadLocal 中的内容
        threadLocal.remove();
        return authentication;
    }

    /**
     * 重写 obtainPassword 从 json中获取
     *
     * @param request
     * @return
     */
    @Override
    protected String obtainPassword(HttpServletRequest request) {
        String password = this.getBodyParams(request).get(SPRING_SECURITY_FORM_PASSWORD_KEY);
        if (!ObjectUtils.isEmpty(password)) {
            // md5 加密
            password = DigestUtils.md5DigestAsHex(password.getBytes());
        }
        return password;
    }

    /**
     * 重写 obtainUsername 从 json中获取
     *
     * @param request
     * @return
     */
    @Override
    protected String obtainUsername(HttpServletRequest request) {
        return this.getBodyParams(request).get(SPRING_SECURITY_FORM_USERNAME_KEY);
    }


    /**
     * 获取 request body 中的数据，封装成 map
     *
     * @param request
     * @return
     */
    @SuppressWarnings("unchecked")
    private Map<String, String> getBodyParams(HttpServletRequest request) {
        Map<String, String> bodyParams = this.threadLocal.get();

        if (ObjectUtils.isEmpty(bodyParams)) {
            try (InputStream is = request.getInputStream()) {
                bodyParams = jsonMapper.readValue(is, Map.class);
            } catch (IOException e) {
            }
            if (ObjectUtils.isEmpty(bodyParams)) {
                bodyParams = new HashMap<String, String>();
            }
            this.threadLocal.set(bodyParams);
        }

        return bodyParams;
    }
}
