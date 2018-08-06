package com.nanyu.controller;

import com.nanyu.model.T_ATTENDANCE;
import com.nanyu.model.T_DESERT;
import com.nanyu.model.T_Employee;
import com.nanyu.service.AttendanceService;
import com.nanyu.service.DesertService;
import com.nanyu.tools.TimeTool;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.sql.Time;

/**
 * Created by NCZ on 2018/8/3.
 */
@Controller
public class AttendanceController {
    @Resource
    private AttendanceService attendanceService;
    @Resource
    private DesertService desertService;


    /**
     * 跳转员工考勤打卡界面
     * @return
     * @throws Exception
     */
    @RequestMapping("/goEmpClockIn")
    public String goEmpClockIn(HttpSession session)throws Exception{
        T_Employee employee = (T_Employee) session.getAttribute("employee");
        int a_emp_id = employee.getEmp_id();
        String currentDate = TimeTool.getDateTime();
        T_ATTENDANCE attendance = attendanceService.findAttExist(a_emp_id,currentDate);
        session.setAttribute("currentAttendance",attendance);
        return "employeepages/employeeDesert";
    }

    /**
     * 员工上班打卡
     * @return
     * @throws Exception
     */
    @RequestMapping("/morningClockIn")
    public String morningClockIn(HttpSession session)throws Exception{
        String datetime = TimeTool.getDateTime();
        String starttime = TimeTool.getTime();
        T_Employee employee = (T_Employee) session.getAttribute("employee");
        T_ATTENDANCE attendance = new T_ATTENDANCE();
        attendance.setA_starttime(starttime);
        attendance.setEmployee(employee);
        attendance.setA_datetime(datetime);
        attendanceService.saveNewAttendance(attendance);
        return "employeepages/employeepages";
    }

    /**
     * 员工下班打卡
     * @return
     * @throws Exception
     */
    @RequestMapping("/nightClockIn")
    public String nightClockIn(HttpSession session)throws Exception{
        String ruleStart = "9:00:00";
        long ruleStartTime = TimeTool.changeStringTimeToLong(ruleStart);//规定上班时间
        String ruleEnd = "18:00:00";
        long ruleEndTime = TimeTool.changeStringTimeToLong(ruleEnd);//规定下班时间
        T_Employee employee = (T_Employee) session.getAttribute("employee");
        int a_emp_id = employee.getEmp_id();//用户id
        String datetime = TimeTool.getDateTime();//得到当日的日期
        T_ATTENDANCE attendance = attendanceService.findAttExist(a_emp_id,datetime);
        String insideEnd = attendance.getA_endtime();
        if(null!=insideEnd){//之前打过下班卡，执行多次打卡判断
            long insideEndTime = TimeTool.changeStringTimeToLong(insideEnd);//表内记录的下班时间
            long insideDifferentEndTime = insideEndTime-ruleEndTime;
            if(insideDifferentEndTime>=0||insideDifferentEndTime*(-1)<=600){//正常或加班(10分钟缓冲）
                if(insideDifferentEndTime<1800){//30分钟内不算加班，直接更新时间
                    String currentTime = TimeTool.getTime();
                    attendance.setA_endtime(currentTime);
                    attendanceService.updateNewAttendance(attendance);
                }else{//30分钟以上算加班,更新加班费信息并更新时间
                    //查找之前是否有加班信息
                    long overTime = insideDifferentEndTime/3600;
                    if(overTime==0){
                        overTime = 1;
                    }
                    double money = overTime*30;//加班费
                    T_DESERT currentDesert = desertService.findDesert(a_emp_id,datetime,1);
                    if(null!=currentDesert){//之前已经有加班奖励记录
                        currentDesert.setDe_money(money);
                        desertService.updateNewDesert(currentDesert);
                    }else{//之前没有加班奖励记录
                        T_DESERT desert = new T_DESERT();
                        desert.setEmployee(employee);
                        desert.setDe_time(datetime);
                        desert.setDe_intro("加班");
                        desert.setDe_money(money);
                        desert.setDe_state(1);
                        desertService.saveDesert(desert);//新增奖罚记录
                    }
                }
            }else{
                session.setAttribute("clockInStatus","打卡失败");
            }
        }else{//之前没打过下班卡
            //计算上班的状态
            String morningTime = attendance.getA_starttime();
            long startTime = TimeTool.changeStringTimeToLong(morningTime);
            long differentStartTime = startTime - ruleStartTime;
            if(differentStartTime>=600&&differentStartTime<7200){//早上迟到
                T_DESERT desert = new T_DESERT();
                desert.setEmployee(employee);
                desert.setDe_time(datetime);
                desert.setDe_intro("迟到");
                desert.setDe_money(30);
                desert.setDe_state(-1);
                desertService.saveDesert(desert);//新增奖罚记录
            }else if (differentStartTime>=7200){//早上旷工

            }else{//正常打卡

            }
        }



        //计算下班的状态
        String nightTime = TimeTool.getTime();
        attendance.setA_endtime(nightTime);
        long endTime = TimeTool.changeStringTimeToLong(nightTime);




    }


}
