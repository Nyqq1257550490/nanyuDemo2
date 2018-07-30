package com.nanyu.dao;

import com.nanyu.model.T_RESUME;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by NCZ on 2018/7/26.
 */
public interface ResumeDao {
    boolean addResume(T_RESUME resume);//添加新简历
    List<T_RESUME> getAllResume(int uid);//查找用户所有的简历
    List<T_RESUME> getPageResume(@Param("uid") int uid,@Param("startPage") int startPage,@Param("pageSize") int pageSize);//查找用户简历 分页

    boolean updateResume(T_RESUME resume);//修改简历
    boolean deleteResume(@Param("re_id") int re_id);//删除简历

    T_RESUME findResume(@Param("re_id") int re_id);//通过id查找指定简历表


}
