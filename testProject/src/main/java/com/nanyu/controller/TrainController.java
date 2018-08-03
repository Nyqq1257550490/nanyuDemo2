package com.nanyu.controller;

import com.nanyu.model.T_Department;
import com.nanyu.model.T_Employee;
import com.nanyu.model.T_TRAIN;
import com.nanyu.model.T_TR_EMP;
import com.nanyu.service.Dep_PosService;
import com.nanyu.service.EmployeeService;
import com.nanyu.service.TrainService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by NCZ on 2018/8/2.
 */
@Controller
public class TrainController {
    @Resource
    private TrainService trainService;
    @Resource
    private Dep_PosService dep_posService;
    @Resource
    private EmployeeService employeeService;

    /**
     * 跳转到培训界面
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping("/goToTrainPage")
    public String goToTrainPage(HttpSession session)throws Exception{
        List<T_TRAIN> trains = trainService.findAllTrain();
        session.setAttribute("allTrain",trains);
        return "adminpages/adminTrain";
    }

    /**
     * 跳转到创建培训界面
     * @return
     * @throws Exception
     */
    @RequestMapping("/goToCreateTrain")
    public String goToCreateTrain(HttpSession session)throws Exception{
        List<T_Department> departments = dep_posService.findAllDep();
        session.setAttribute("allDep",departments);
        return "adminpages/adminCreateTrain";
    }

    /**
     * 查找不同状态的培训
     * @param state
     * @param session
     * @throws Exception
     */
    @RequestMapping("/findStateTrain")
    @ResponseBody
    public void findStateTrain(int state,HttpSession session)throws Exception{
        List<T_TRAIN> trains = trainService.findStateTrain(state);
        session.setAttribute("allTrain",trains);
    }

    /**
     * 创建培训
     * @return
     * @throws Exception
     */
    @RequestMapping("/createTrain")
    public String createTrain(T_TRAIN t_train,int selectTarget)throws Exception{
        trainService.saveNewTrain(t_train);
//        int t_id = t_train.getT_id();
        List<T_Employee> employees = null;
        if(selectTarget==0){
            employees = employeeService.findEmployeeState(selectTarget);
        }else{
            employees = employeeService.findDepEmployee(selectTarget);
        }
        for(T_Employee e:employees){
            trainService.addTrain_Emp(t_train,e);
        }
        return "redirect:/goToTrainPage";
    }

    /**
     * 管理员修改培训信息状态，发布,撤回
     * @param t_id
     * @param t_state
     * @return
     * @throws Exception
     */
    @RequestMapping("/adminControlTrainStatus")
    public String adminControlTrainStatus(int t_id, int t_state, HttpSession session)throws Exception{
        if(t_state==0){
            T_TRAIN train = new T_TRAIN();
            train.setT_id(t_id);
            train.setT_state(1);
            trainService.controlTrainStatus(train);
        }else{
            T_TRAIN train = trainService.findCurrentTrainById(t_id);
            String time = train.getT_issuetime();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date issuetime = sdf.parse(time);
            long issue = issuetime.getTime();
            long current = System.currentTimeMillis();
            if(current-issue<=600000){
                train.setT_state(0);
                trainService.controlTrainStatus(train);
            }else{
                session.setAttribute("controlTrainStatus","超过时间，修改失败");
            }

        }
        return "redirect:/goToTrainPage";

    }

    /**
     * 员工查看培训
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping("/empCheckTrain")
    public String empCheckTrain(HttpSession session)throws Exception{
        T_Employee employee = (T_Employee) session.getAttribute("employee");
        int emp_id = employee.getEmp_id();
        List<T_TR_EMP> tr_emp = trainService.findEmpTrain(emp_id);
        session.setAttribute("emp_TrainInfo",tr_emp);
        return "employeepages/employeeTrain";
    }


}
