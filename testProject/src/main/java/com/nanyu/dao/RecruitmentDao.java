package com.nanyu.dao;

import com.nanyu.model.T_RECRUITMENT;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by NCZ on 2018/7/27.
 */
public interface RecruitmentDao {
    List<T_RECRUITMENT> findAble(@Param("status") int status);//查找所有的招聘信息
    List<T_RECRUITMENT> getPageRecruitment(@Param("status") int status,@Param("startPage") int startPage, @Param("pageSize") int pageSize);//分页查看招聘信息

    boolean saveNewRec(T_RECRUITMENT recruitment);//制作新的招聘信息（未上架）

    List<T_RECRUITMENT> findRecruitment(@Param("status") int status);//查找指定状态的招聘信息
    boolean modifyRecruitment(T_RECRUITMENT recruitment);//修改招聘信息

}
