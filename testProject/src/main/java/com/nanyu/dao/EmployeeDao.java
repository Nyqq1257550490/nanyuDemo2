package com.nanyu.dao;

import com.nanyu.model.T_Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by NCZ on 2018/7/30.
 */
public interface EmployeeDao {
    boolean saveNewEmployee(T_Employee employee);//添加新的员工

    List<T_Employee> findPosEmpty(int dep_id, int pos_id);//查找是否有指定工作的员工
    List<T_Employee> findEmployeeState(@Param("state") int state);//查找指定状态的员工

    List<T_Employee> findDepEmployee(int dep_id);//查找指定部门的员工




}
