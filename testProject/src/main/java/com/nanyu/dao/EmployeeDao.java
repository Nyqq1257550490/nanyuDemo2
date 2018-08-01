package com.nanyu.dao;

import com.nanyu.model.T_Employee;

/**
 * Created by NCZ on 2018/7/30.
 */
public interface EmployeeDao {
    boolean saveNewEmployee(T_Employee employee);//添加新的员工
}
