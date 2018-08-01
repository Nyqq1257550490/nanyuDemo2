package com.nanyu.service.Impl;

import com.nanyu.dao.MainDao;
import com.nanyu.model.T_Department;
import com.nanyu.model.T_Position;
import com.nanyu.service.MainService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by NCZ on 2018/7/25.
 */
@Service
public class MainServiceImpl implements MainService{
    @Resource
    private MainDao mainDao;

    /**
     * 查找所有的部门
     * @return
     */
    @Override
    public List<T_Department> findAllDepartment() {
        return mainDao.findAllDepartment();
    }

    /**
     * 查找部门对应的职位
     * @param dep_id
     * @return
     */
    @Override
    public List<T_Position> getPosition(int dep_id) {
        return mainDao.getPosition(dep_id);
    }
}
