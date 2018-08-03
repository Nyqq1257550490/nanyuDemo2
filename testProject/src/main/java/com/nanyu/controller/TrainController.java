package com.nanyu.controller;

import com.nanyu.model.T_Department;
import com.nanyu.model.T_Employee;
import com.nanyu.model.T_TRAIN;
import com.nanyu.service.Dep_PosService;
import com.nanyu.service.EmployeeService;
import com.nanyu.service.TrainService;
import com.nanyu.tools.TimeTool;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
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

}
