package com.nanyu.service.Impl;

import com.nanyu.dao.EmployeeDao;
import com.nanyu.model.T_Employee;
import com.nanyu.service.EmployeeService;
import com.nanyu.tools.TimeTool;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by NCZ on 2018/7/30.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Resource
    private EmployeeDao employeeDao;

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    /**
     * 添加新的员工
     * @param employee
     * @return
     */
    @Override
    public boolean saveNewEmployee(T_Employee employee) {
        String time = TimeTool.getCurrentTime();
        employee.setEmp_hiredate(time);
        return employeeDao.saveNewEmployee(employee);
    }
}
