package com.qh.ruyitakeaway.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.qh.ruyitakeaway.dto.UserDto;
import com.qh.ruyitakeaway.entity.Employee;
import com.qh.ruyitakeaway.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.ObjectUtils;


/**
 * Spring Security默认根据用户名查询用户信息实现类
 *
 * @author qh
 * @date 2022/10/09 16:57:01
 */
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LambdaQueryWrapper<Employee> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Employee::getUsername, username);

        Employee loginEmployee = employeeService.getOne(queryWrapper);
        if (ObjectUtils.isEmpty(loginEmployee)) {
            throw new UsernameNotFoundException("用户名密码不存在");
        }

        UserDto userDto = new UserDto(loginEmployee.getUsername(),
                passwordEncoder.encode(loginEmployee.getPassword()),
                loginEmployee.getStatus() != 0,
                true, true, true,
                AuthorityUtils.commaSeparatedStringToAuthorityList("employee," + loginEmployee.getUsername()));
        userDto.setEmployee(loginEmployee);
        return userDto;
    }
}
