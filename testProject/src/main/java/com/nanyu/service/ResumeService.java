package com.nanyu.service;

import com.nanyu.model.T_RESUME;

import java.util.List;

/**
 * Created by NCZ on 2018/7/26.
 */
public interface ResumeService {
    boolean addResume(T_RESUME resume);//添加新简历
    List<T_RESUME> getAllResume(int uid);//查找用户所有的简历
    List<T_RESUME> getPageResume(int uid,int startPage,int pageSize);//查找用户简历 分页

    boolean updateResume(T_RESUME resume);//修改简历
}
