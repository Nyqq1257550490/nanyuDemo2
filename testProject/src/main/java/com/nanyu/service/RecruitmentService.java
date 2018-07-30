package com.nanyu.service;

import com.nanyu.model.T_RECRUITMENT;

import java.util.List;

/**
 * Created by NCZ on 2018/7/27.
 */
public interface RecruitmentService {
    List<T_RECRUITMENT> findAble(int status);//查找所有的招聘信息
    List<T_RECRUITMENT> getPageRecruitment(int status,int startPage,int pageSize);//分页查看招聘信息

    boolean saveNewRec(T_RECRUITMENT recruitment);//制作新的招聘信息（未上架）

    List<T_RECRUITMENT> findRecruitment(int status);//查找指定状态的招聘信息
}
