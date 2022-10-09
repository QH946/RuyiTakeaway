package com.qh.ruyitakeaway.config;


import com.qh.ruyitakeaway.filter.JwtAuthenticationTokenFilter;
import com.qh.ruyitakeaway.handler.*;
import com.qh.ruyitakeaway.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


/**
 * 安全配置
 *
 * @author qh
 * @date 2022/10/09 12:05:56
 */
@Configuration
public class SecurityConfig {

    /**
     * 获取身份验证管理器
     */
    @Autowired(required = false)
    private AuthenticationConfiguration authenticationConfiguration;


    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    UserDetailsServiceImpl userDetailsService() {
        return new UserDetailsServiceImpl();
    }

    /**
     * 身份验证管理器
     *
     * @return
     * @throws Exception
     */
    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }


    /**
     * 登录失败
     *
     * @return
     */
    @Bean
    CustomAuthenticationFailureHandler customAuthenticationFailureHandler() {
        return new CustomAuthenticationFailureHandler();
    }

    /**
     * 登录成功
     *
     * @return
     */
    @Bean
    CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler() {
        return new CustomAuthenticationSuccessHandler();
    }

    /**
     * 未登录
     *
     * @return
     */
    @Bean
    CustomAuthenticationEntryPoint customAuthenticationEntryPoint() {
        return new CustomAuthenticationEntryPoint();
    }

    /**
     * 没有权限
     *
     * @return
     */
    @Bean
    CustomAccessDeniedHandler customAccessDeniedHandler() {
        return new CustomAccessDeniedHandler();
    }


    /**
     * 退出
     *
     * @return
     */
    @Bean
    CustomLogoutHandler customLogoutHandler() {
        return new CustomLogoutHandler();
    }

    /**
     * 退出成功
     *
     * @return
     */
    @Bean
    CustomLogoutSuccessHandler customLogoutSuccessHandler() {
        return new CustomLogoutSuccessHandler();
    }

    /**
     * 自定义 认证过滤器
     *
     * @return
     * @throws Exception
     */
    @Bean
    JwtAuthenticationTokenFilter jwtAuthenticationFilter() throws Exception {
        JwtAuthenticationTokenFilter jwtAuthenticationFilter = new JwtAuthenticationTokenFilter();
        // 登录请求的接口
        jwtAuthenticationFilter.setFilterProcessesUrl("/employee/login");
        //  获取身份验证管理器
        jwtAuthenticationFilter.setAuthenticationManager(authenticationManager());
        // 登录失败
        jwtAuthenticationFilter.setAuthenticationFailureHandler(customAuthenticationFailureHandler());
        // 登录成功
        jwtAuthenticationFilter.setAuthenticationSuccessHandler(customAuthenticationSuccessHandler());
        return jwtAuthenticationFilter;
    }

    @Bean
    @Autowired(required = false)
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {


        http.exceptionHandling()
                // 未登录情况
                .authenticationEntryPoint(customAuthenticationEntryPoint())
                // 缺少权限情况
                .accessDeniedHandler(customAccessDeniedHandler())
                .and()
                // 退出登录
                .logout().logoutUrl("/employee/logout")
                // 退出处理器
                .addLogoutHandler(customLogoutHandler())
                // 退出成功处理器
                .logoutSuccessHandler(customLogoutSuccessHandler())
//                .deleteCookies("employee","user")
                .and()
                // 设置权限
                .authorizeRequests()
                // 放行
                .antMatchers("/backend/**", "/employee/login", "/front/**", "/error").permitAll()
                .antMatchers("/csrf", "/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui.html/**","doc.html").permitAll()
                .antMatchers("/user/sendMsg", "/user/login").permitAll()
                .antMatchers(HttpMethod.GET, "/category/list", "/dish/list", "/common/download").permitAll()
                .antMatchers("/shoppingCart/**", "/setmeal/**", "/order/**", "/addressBook/**").permitAll()
                // 其他的所有接口都需要 employee 权限
                .anyRequest().hasAnyAuthority("employee")
                .and()
                // 关闭 csrf
                .csrf().disable()
                // 使用iframe的内嵌页面
                .headers().frameOptions().disable();
        // 替换 原来的逻辑
        http.addFilterAt(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
        return http.build();

    }


}
