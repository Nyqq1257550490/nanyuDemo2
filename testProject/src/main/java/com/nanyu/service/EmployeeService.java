package com.nanyu.service;

import com.nanyu.model.T_Employee;

import java.util.List;

/**
 * Created by NCZ on 2018/7/30.
 */
public interface EmployeeService {
    boolean saveNewEmployee(T_Employee employee);//添加新的员工

    List<T_Employee> findPosEmpty(int dep_id,int pos_id);//查找是否有指定工作的员工
    List<T_Employee> findEmployeeState(int state);//查找指定状态的员工

    List<T_Employee> findDepEmployee(int dep_id);//查找指定部门的员工

    T_Employee employeeLogin(T_Employee employee);//员工登录
}
