package com.nanyu.controller;

import com.nanyu.model.T_Employee;
import com.nanyu.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by NCZ on 2018/7/30.
 */
@Controller
public class EmployeeController {
    @Resource
    private EmployeeService employeeService;

    /**
     * 添加新员工，返回管理员主界面
     * @param employee
     * @return
     * @throws Exception
     */
    @RequestMapping("/saveNewEmployee")
    public String saveNewEmployee(T_Employee employee)throws Exception{
        employeeService.saveNewEmployee(employee);
        return "adminpages/adminMenu";
    }


}
