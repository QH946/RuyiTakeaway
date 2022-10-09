package com.qh.ruyitakeaway.controller;


import com.qh.ruyitakeaway.common.R;
import com.qh.ruyitakeaway.entity.User;
import com.qh.ruyitakeaway.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;


/**
 * <p>
 * 用户信息 前端控制器
 * </p>
 *
 * @author QH
 * @since 2022-09-08
 */
@Api("移动端用户")
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 发送手机短信验证码
     * @param user
     * @param session
     * @return
     */
    @ApiOperation("发送短信接口")
    @PostMapping("/sendMsg")
    public R<String> sendMsg(@RequestBody User user, HttpSession session) {
        return userService.sendMessage(user, session);
    }

    /**
     * 移动端用户登录
     *
     * @param map
     * @param session
     * @return
     */
    @ApiOperation("用户登录接口")
    @PostMapping("/login")
    public R<User> login(@RequestBody Map map, HttpSession session) {
        log.info(map.toString());
        User user = userService.login(map, session);
        return R.success(user);
    }

    /**
     * 用户退出
     *
     * @param request
     * @return
     */
    @ApiOperation("用户登出接口")
    @PostMapping("/logout")
    public R<String> logout(HttpServletRequest request) {
        //清理Session中保存的当前用户登录的id
        request.getSession().removeAttribute("user");
        return R.success("退出成功");
    }
}


