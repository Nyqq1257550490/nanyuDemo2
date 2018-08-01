package com.nanyu.service.Impl;

import com.nanyu.dao.EmployeeDao;
import com.nanyu.model.T_Employee;
import com.nanyu.service.EmployeeService;
import com.nanyu.tools.TimeTool;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

    /**
     *  查找是否有指定工作的员工
     * @param dep_id
     * @param pos_id
     * @return
     */
    @Override
    public List<T_Employee> findPosEmpty(int dep_id, int pos_id) {
        return employeeDao.findPosEmpty(dep_id,pos_id);
    }

    /**
     * 查找指定状态的员工
     * @param state
     * @return
     */
    @Override
    public List<T_Employee> findEmployeeState(int state) {
        return employeeDao.findEmployeeState(state);
    }
}
