package com.nanyu.service.Impl;

import com.nanyu.dao.DesertDao;
import com.nanyu.model.T_DESERT;
import com.nanyu.model.T_Employee;
import com.nanyu.service.DesertService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by NCZ on 2018/8/5.
 */
@Service
public class DesertServiceImpl implements DesertService{
    @Resource
    private DesertDao desertDao;

    public void setDesertDao(DesertDao desertDao) {
        this.desertDao = desertDao;
    }

    /**
     * 查看当天是否已经生成过加班奖励
     * @param a_emp_id
     * @param datetime
     * @param de_state
     * @return
     */
    @Override
    public T_DESERT findDesert(int a_emp_id, String datetime, int de_state) {
        T_DESERT desert = new T_DESERT();
        T_Employee employee = new T_Employee();
        employee.setEmp_id(a_emp_id);
        desert.setDe_time(datetime);
        desert.setEmployee(employee);
        desert.setDe_state(de_state);
        return desertDao.findDesert(desert);
    }

    /**
     * 更新奖赏信息的金钱
     * @param desert
     * @return
     */
    @Override
    public boolean updateNewDesert(T_DESERT desert) {
        return desertDao.updateNewDesert(desert);
    }

    /**
     * 新增奖罚信息的金钱
     * @param desert
     * @return
     */
    @Override
    public boolean saveDesert(T_DESERT desert) {
        return desertDao.saveDesert(desert);
    }
}
