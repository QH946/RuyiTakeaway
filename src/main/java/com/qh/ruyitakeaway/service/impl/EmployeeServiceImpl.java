package com.qh.ruyitakeaway.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qh.ruyitakeaway.entity.Employee;
import com.qh.ruyitakeaway.mapper.EmployeeMapper;
import com.qh.ruyitakeaway.service.EmployeeService;
import org.springframework.stereotype.Service;

/**
 * @Author QH
 * @Date 2022/9/8 19:21
 * @Package: com.qh.ruyitakeaway.service.impl
 * @Version 1.0
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {
}