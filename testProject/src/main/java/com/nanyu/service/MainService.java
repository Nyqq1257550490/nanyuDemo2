package com.nanyu.service;

import com.nanyu.model.T_Department;
import com.nanyu.model.T_Position;

import java.util.List;

/**
 * Created by NCZ on 2018/7/25.
 */
public interface MainService {
    List<T_Department> findAllDepartment();//查找所有的部门

    List<T_Position> getPosition(int dep_id);//查找部门对应的职位
}
