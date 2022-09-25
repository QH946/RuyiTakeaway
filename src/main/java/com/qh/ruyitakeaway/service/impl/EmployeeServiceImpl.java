package com.qh.ruyitakeaway.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qh.ruyitakeaway.common.CustomException;
import com.qh.ruyitakeaway.entity.Employee;
import com.qh.ruyitakeaway.mapper.EmployeeMapper;
import com.qh.ruyitakeaway.service.EmployeeService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpServletRequest;

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

    @Autowired
    private EmployeeService employeeService;


    @Override
    public Employee login(HttpServletRequest request, Employee employee) {
        //1.查询数据库中是否有该用户
        Employee emp = employeeService.getOne(new QueryWrapper<Employee>().eq("username", employee.getUsername()));
        if (emp == null) {
            throw new CustomException("登录失败");
        }

        //2.判断密码是否正确
        String password = employee.getPassword();
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        if (!emp.getPassword().equals(password)) {
            throw new CustomException("登录失败");
        }

        //3.判断员工是否被禁用
        if (emp.getStatus() == 0) {
            throw new CustomException("登录失败");
        }

        //4.将员工id存入Session并返回登录成功结果
        request.getSession().setAttribute("employee", emp.getId());
        return emp;
    }

    /**
     * 获取页面
     *
     * @param page     页面
     * @param pageSize 页面大小
     * @param name     名字
     * @return {@link Page} <{@link Employee}>
     */
    @Override
    public Page<Employee> getPage(int page, int pageSize, String name) {

        //构造分页构造器
        Page<Employee> pageInfo = new Page(page, pageSize);
        //构造条件构造器
        LambdaQueryWrapper<Employee> queryWrapper = new LambdaQueryWrapper();
        //添加过滤条件
        queryWrapper.like(StringUtils.isNotEmpty(name), Employee::getName, name);
        //添加排序条件
        queryWrapper.orderByDesc(Employee::getUpdateTime);
        //执行查询
        page(pageInfo, queryWrapper);

        return pageInfo;
    }

}
