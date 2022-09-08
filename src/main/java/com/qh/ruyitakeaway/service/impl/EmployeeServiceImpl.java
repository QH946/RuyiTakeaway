package com.qh.ruyitakeaway.service.impl;

import com.qh.ruyitakeaway.entity.Employee;
import com.qh.ruyitakeaway.mapper.EmployeeMapper;
import com.qh.ruyitakeaway.service.EmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 员工信息 服务实现类
 * </p>
 *
 * @author QH
 * @since 2022-09-08
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

}
