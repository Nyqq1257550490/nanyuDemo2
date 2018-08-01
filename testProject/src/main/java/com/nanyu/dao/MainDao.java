package com.nanyu.dao;

import com.nanyu.model.T_Department;
import com.nanyu.model.T_Position;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by NCZ on 2018/7/25.
 */
public interface MainDao {
    List<T_Department> findAllDepartment();//查找所有的部门

    List<T_Position> getPosition(@Param("dep_id") int dep_id);//查找部门对应的职位


}
