package com.qh.ruyitakeaway.service.impl;

import com.qh.ruyitakeaway.entity.User;
import com.qh.ruyitakeaway.mapper.UserMapper;
import com.qh.ruyitakeaway.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息 服务实现类
 * </p>
 *
 * @author QH
 * @since 2022-09-08
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
