package com.nanyu.dao;

import com.nanyu.model.T_DESERT;

/**
 * Created by NCZ on 2018/8/5.
 */
public interface DesertDao {
    T_DESERT findDesert(T_DESERT desert);//查看当天是否已经生成过加班奖励
    boolean updateNewDesert(T_DESERT desert);//更新奖赏信息的金钱

    boolean saveDesert(T_DESERT desert);//新增奖罚信息的金钱




}
