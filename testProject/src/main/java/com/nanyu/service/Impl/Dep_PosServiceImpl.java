package com.nanyu.service.Impl;

import com.nanyu.dao.Dep_PosDao;
import com.nanyu.model.T_Department;
import com.nanyu.model.T_Position;
import com.nanyu.service.Dep_PosService;
import com.nanyu.tools.TimeTool;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by NCZ on 2018/7/31.
 */
@Service
public class Dep_PosServiceImpl implements Dep_PosService{
    @Resource
    private Dep_PosDao dep_posDao;

    public void setDep_posDao(Dep_PosDao dep_posDao) {
        this.dep_posDao = dep_posDao;
    }

    /**
     * 查找所有部门
     * @return
     */
    @Override
    public List<T_Department> findAllDep() {
        return dep_posDao.findAllDep();
    }

    /**
     * 添加新的部门
     * @param department
     * @return
     */
    @Override
    public boolean addNewDep(T_Department department) {
        String time = TimeTool.getCurrentTime();
        department.setDep_createtime(time);
        return dep_posDao.addNewDep(department);
    }

    /**
     * 添加新的职位
     * @param position
     * @return
     */
    @Override
    public boolean addNewPos(T_Position position) {
        return dep_posDao.addNewPos(position);
    }

    /**
     * 删除职位
     * @param pos_id
     * @return
     */
    @Override
    public boolean deletePos(int pos_id) {
        return dep_posDao.deletePos(pos_id);
    }

    /**
     * 查找指定部门下所有职位
     * @param dep_id
     * @return
     */
    @Override
    public List<T_Position> findCurrentPos(int dep_id) {
        return dep_posDao.findCurrentPos(dep_id);
    }
}
