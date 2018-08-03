package com.nanyu.service;

import com.nanyu.model.T_Employee;
import com.nanyu.model.T_TRAIN;
import com.nanyu.model.T_TR_EMP;

import java.util.List;

/**
 * Created by NCZ on 2018/8/2.
 */
public interface TrainService {
    List<T_TRAIN> findAllTrain();//查询所有培训
    List<T_TRAIN> findStateTrain(int state);//查看指定状态的培训列表

    boolean saveNewTrain(T_TRAIN t_train );//添加新的培训信息

    boolean addTrain_Emp(T_TRAIN train, T_Employee employee);//添加员工培训中间表

    boolean controlTrainStatus(T_TRAIN train);//修改培训信息状态
    T_TRAIN findCurrentTrainById(int t_id);//查找特定的培训信息

    List<T_TR_EMP> findEmpTrain(int emp_id);//查看指定员工的所有培训信息



}
