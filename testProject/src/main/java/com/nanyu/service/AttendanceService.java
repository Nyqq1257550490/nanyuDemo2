package com.nanyu.service;

import com.nanyu.model.T_ATTENDANCE;

/**
 * Created by NCZ on 2018/8/3.
 */
public interface AttendanceService {
    T_ATTENDANCE findAttExist(int a_emp_id,String currentDate);//查看当天用户是否打过卡
    boolean saveNewAttendance(T_ATTENDANCE attendance);//早上打卡添加新的打卡信息

    boolean updateNewAttendance(T_ATTENDANCE attendance);//更新下班时间



}
