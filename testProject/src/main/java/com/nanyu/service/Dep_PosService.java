package com.nanyu.service;

import com.nanyu.model.T_Department;
import com.nanyu.model.T_Position;

import java.util.List;

/**
 * Created by NCZ on 2018/7/31.
 */
public interface Dep_PosService {
    List<T_Department> findAllDep();//查找所有部门
    boolean addNewDep(T_Department department);//添加新的部门
    boolean addNewPos(T_Position position);//添加新的职位
    boolean deletePos(int pos_id);//删除职位

    List<T_Position> findCurrentPos(int dep_id);//查找指定部门下所有职位

}
