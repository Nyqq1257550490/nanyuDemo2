package com.nanyu.dao;

import com.nanyu.model.T_ATTENDANCE;

/**
 * Created by NCZ on 2018/8/3.
 */
public interface AttendanceDao {
    T_ATTENDANCE findAttExist(T_ATTENDANCE attendance);//查看当天用户是否打过卡

    boolean saveNewAttendance(T_ATTENDANCE attendance);//早上打卡添加新的打卡信息

    boolean updateNewAttendance(T_ATTENDANCE attendance);//更新下班时间




}
