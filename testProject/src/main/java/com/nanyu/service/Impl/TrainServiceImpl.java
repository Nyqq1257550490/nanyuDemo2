package com.nanyu.service.Impl;

import com.nanyu.dao.TrainDao;
import com.nanyu.model.T_Employee;
import com.nanyu.model.T_TRAIN;
import com.nanyu.service.TrainService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by NCZ on 2018/8/2.
 */
@Service
public class TrainServiceImpl implements TrainService {
    @Resource
    private TrainDao trainDao;

    public void setTrainDao(TrainDao trainDao) {
        this.trainDao = trainDao;
    }

    /**
     * 查询所有培训
     * @return
     */
    @Override
    public List<T_TRAIN> findAllTrain() {
        return trainDao.findAllTrain();
    }

    /**
     * 查看指定状态的培训列表
     * @param state
     * @return
     */
    @Override
    public List<T_TRAIN> findStateTrain(int state) {
        return trainDao.findStateTrain(state);
    }

    /**
     * 添加新的培训信息
     * @param t_train
     * @return
     */
    @Override
    public boolean saveNewTrain(T_TRAIN t_train) {
        return trainDao.saveNewTrain(t_train);
    }

    /**
     * 添加员工培训中间表
     * @param train
     * @param employee
     * @return
     */
    @Override
    public boolean addTrain_Emp(T_TRAIN train, T_Employee employee) {
        int tr_id = train.getT_id();
        int emp_id = employee.getEmp_id();
        return trainDao.addTrain_Emp(tr_id,emp_id);
    }
}
