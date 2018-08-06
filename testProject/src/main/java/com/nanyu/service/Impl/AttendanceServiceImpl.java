package com.nanyu.service.Impl;

import com.nanyu.dao.AttendanceDao;
import com.nanyu.model.T_ATTENDANCE;
import com.nanyu.model.T_Employee;
import com.nanyu.service.AttendanceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by NCZ on 2018/8/3.
 */
@Service
public class AttendanceServiceImpl implements AttendanceService{
    @Resource
    private AttendanceDao attendanceDao;

    public void setAttendanceDao(AttendanceDao attendanceDao) {
        this.attendanceDao = attendanceDao;
    }

    /**
     * 查看当天用户是否打过卡
     * @param a_emp_id
     * @param currentDate
     * @return
     */
    @Override
    public T_ATTENDANCE findAttExist(int a_emp_id, String currentDate) {
        T_ATTENDANCE attendance = new T_ATTENDANCE();
        T_Employee employee = new T_Employee();
        employee.setEmp_id(a_emp_id);
        attendance.setA_datetime(currentDate);
        attendance.setEmployee(employee);
        return attendanceDao.findAttExist(attendance);
    }

    /**
     * 早上打卡添加新的打卡信息
     * @param attendance
     * @return
     */
    @Override
    public boolean saveNewAttendance(T_ATTENDANCE attendance) {
        return attendanceDao.saveNewAttendance(attendance);
    }

    /**
     * 更新下班时间
     * @param attendance
     * @return
     */
    @Override
    public boolean updateNewAttendance(T_ATTENDANCE attendance) {
        return attendanceDao.updateNewAttendance(attendance);
    }
}
