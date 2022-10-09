package com.qh.ruyitakeaway.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qh.ruyitakeaway.common.R;
import com.qh.ruyitakeaway.common.exception.CustomException;
import com.qh.ruyitakeaway.common.utils.ValidateCodeUtils;
import com.qh.ruyitakeaway.entity.User;
import com.qh.ruyitakeaway.mapper.UserMapper;
import com.qh.ruyitakeaway.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 用户信息 服务实现类
 * </p>
 *
 * @author QH
 * @since 2022-09-08
 */
@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserService userService;
    @Autowired
    private RedisTemplate redisTemplate;


    /**
     * 发送手机短信验证码
     *
     * @param user    用户
     * @param session 会话
     * @return {@link User}
     */
    @Override
    public R<String> sendMessage(User user, HttpSession session) {
        //获取手机号
        String phone = user.getPhone();
        if (StringUtils.isNotEmpty(phone)) {
            //生成随机的4位验证码
            String code = ValidateCodeUtils.generateValidateCode(4).toString();
            log.info("code={}", code);

            //调用阿里云提供的短信服务API完成发送短信
            //smsUtils.sendMessage("如意外卖", "SMS_184825163", code.toString(), phone);

            //将生成的验证码缓存到Redis中，并且设置有效期为5分钟
            redisTemplate.opsForValue().set(phone, code, 5, TimeUnit.MINUTES);

            R<String> result = R.success("发送成功");
            result.add("sendMsg", code);
            return result;
        }
        throw new CustomException("短信发送失败");
    }

    /**
     * 用户登录
     *
     * @param map     地图
     * @param session 会话
     * @return {@link User}
     */
    @Override
    public User login(Map map, HttpSession session) {
        //获取手机号
        String phone = map.get("phone").toString();

        //获取验证码
        String code = map.get("code").toString();

        //从Redis中获取缓存的验证码
        Object codeInSession = redisTemplate.opsForValue().get(phone);

        //进行验证码的比对（页面提交的验证码和Session中保存的验证码比对）
        if (codeInSession != null && codeInSession.equals(code)) {
            //如果能够比对成功，说明登录成功

            LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(User::getPhone, phone);

            User user = userService.getOne(queryWrapper);
            if (user == null) {
                //判断当前手机号对应的用户是否为新用户，如果是新用户就自动完成注册
                user = new User();
                user.setPhone(phone);
                user.setStatus(1);
                user.setName("111");
                userService.save(user);
            }
            session.setAttribute("user", user.getId());

            //如果用户登录成功，删除Redis中缓存的验证码
            redisTemplate.delete(phone);

            return user;
        }
        throw new CustomException("登录失败");
    }
}
