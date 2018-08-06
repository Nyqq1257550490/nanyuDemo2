package com.nanyu.service;

import com.nanyu.model.T_DESERT;

/**
 * Created by NCZ on 2018/8/5.
 */
public interface DesertService {
    T_DESERT findDesert(int a_emp_id,String datetime,int de_state);//查看当天是否已经生成过加班奖励
    boolean updateNewDesert(T_DESERT desert);//更新加班奖赏信息的金钱
    boolean saveDesert(T_DESERT desert);//新增奖罚信息的金钱



}
