package com.nanyu.controller;

import com.nanyu.model.T_Department;
import com.nanyu.model.T_Employee;
import com.nanyu.model.T_Position;
import com.nanyu.service.EmployeeService;
import com.nanyu.tools.TimeTool;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by NCZ on 2018/7/30.
 */
@Controller
public class EmployeeController {
    @Resource
    private EmployeeService employeeService;

    /**
     * 跳转到员工登录
     * @return
     * @throws Exception
     */
    @RequestMapping("/goEmployeeLoginPage")
    public String goEmployeeLoginPage()throws Exception{
        return "employeepages/employeeLogin";
    }

    /**
     * 添加新员工，返回管理员主界面
     * @param employee
     * @return
     * @throws Exception
     */
    @RequestMapping("/saveNewEmployee")
    public String saveNewEmployee(T_Employee employee,int dep_id,int pos_id)throws Exception{
        T_Department department = new T_Department();
        department.setDep_id(dep_id);
        T_Position position = new T_Position();
        position.setPos_id(pos_id);
        employee.setDepartment(department);
        employee.setPosition(position);
        employeeService.saveNewEmployee(employee);
        return "adminpages/adminMenu";
    }

    /**
     * 查看在职员工
     * @return
     * @throws Exception
     */
    @RequestMapping("/findEmployeeIn")
    @ResponseBody
    public void findEmployeeIn(HttpSession session)throws Exception{
        int state = 1;
        List<T_Employee> employees = employeeService.findEmployeeState(state);
        session.setAttribute("findEmployee",employees);
    }

    /**
     * 查看离职员工
     * @return
     * @throws Exception
     */
    @RequestMapping("/findEmployeeOut")
    @ResponseBody
    public void findEmployeeOut(HttpSession session)throws Exception{
        int state = 0;
        List<T_Employee> employees = employeeService.findEmployeeState(state);
        session.setAttribute("findEmployee",employees);
    }

    /**
     * 查看请假员工
     * @return
     * @throws Exception
     */
    @RequestMapping("/findEmployeeHoliday")
    @ResponseBody
    public void findEmployeeHoliday(HttpSession session)throws Exception{
        int state = 2;
        List<T_Employee> employees = employeeService.findEmployeeState(state);
        session.setAttribute("findEmployee",employees);
    }

    /**
     * 员工登录
     * @return
     * @throws Exception
     */
    @RequestMapping("/employeeLogin")
    public String employeeLogin(T_Employee employee, HttpServletRequest request,HttpSession session)throws Exception{
        T_Employee employee1 = employeeService.employeeLogin(employee);
        if(employee1.getEmp_id()!=0){
            session.setAttribute("employee",employee1);
            return "employeepages/employeepages";
        }else{
            request.setAttribute("employeeLoginStatus","用户名或密码错");
            return "employeepages/employeeLogin";
        }

    }








}
