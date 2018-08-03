package com.nanyu.dao;

import com.nanyu.model.T_Employee;
import com.nanyu.model.T_TRAIN;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by NCZ on 2018/8/2.
 */
public interface TrainDao {
    List<T_TRAIN> findAllTrain();//查询所有培训
    List<T_TRAIN> findStateTrain(int state);//查看指定状态的培训列表

    boolean saveNewTrain(T_TRAIN t_train );//添加新的培训信息

    boolean addTrain_Emp(@Param("tr_id") int tr_id,@Param("emp_id") int emp_id);//添加员工培训中间表





}
