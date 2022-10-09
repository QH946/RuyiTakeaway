package com.qh.ruyitakeaway.service;

import com.qh.ruyitakeaway.common.R;
import com.qh.ruyitakeaway.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * <p>
 * 用户信息 服务类
 * </p>
 *
 * @author QH
 * @since 2022-09-08
 */
public interface UserService extends IService<User> {


    /**
     * 发送手机短信验证码
     *
     * @param user    用户
     * @param session 会话
     * @return {@link User}
     */
    R<String> sendMessage(User user, HttpSession session);

    /**
     * 用户登录
     *
     * @param map     地图
     * @param session 会话
     * @return {@link User}
     */
    User login(Map map, HttpSession session);
}
