package com.qh.ruyitakeaway.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.qh.ruyitakeaway.common.R;
import com.qh.ruyitakeaway.entity.Employee;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 员工信息 服务类
 * </p>
 *
 * @author QH
 * @since 2022-09-08
 */
public interface EmployeeService extends IService<Employee> {


    /**
     * 登录
     *
     * @param request  请求
     * @param employee 员工
     * @return {@link Employee}
     */
    Employee login(HttpServletRequest request, Employee employee);


    /**
     * 获取页面
     *
     * @param page     页面
     * @param pageSize 页面大小
     * @param name     名字
     * @return {@link R}<{@link Employee}>
     */
    Page<Employee> getPage(int page, int pageSize, String name);
}
