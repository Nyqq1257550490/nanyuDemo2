package com.nanyu.controller;

import com.nanyu.model.T_Department;
import com.nanyu.model.T_Employee;
import com.nanyu.model.T_Position;
import com.nanyu.service.Dep_PosService;
import com.nanyu.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by NCZ on 2018/7/31.
 */
@Controller
public class Dep_PosController {
    @Resource
    private Dep_PosService dep_posService;
    @Resource
    private EmployeeService employeeService;

    /**
     * 跳转部门职位控制界面，查找所有部门
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping("/goToDep_PosControl")
    public String goToDep_PosControl(HttpSession session)throws Exception{
        List<T_Department> departments = dep_posService.findAllDep();
        session.setAttribute("allDepartment",departments);
        return "adminpages/adminDep_PosControl";
    }

    /**
     * 部门名判重
     * @param session
     * @param dep_name
     * @return
     * @throws Exception
     */
    @RequestMapping("/checkDepOnly")
    @ResponseBody
    public Object checkDepOnly(HttpSession session,String dep_name)throws Exception{
        List<T_Department> departments = (List<T_Department>) session.getAttribute("allDepartment");
        for(T_Department d:departments){
            if(d.getDep_name().equals(dep_name)){
                return false;
            }
        }
        return true;
    }

    /**
     * 职位名
     * @param session
     * @param pos_name
     * @return
     * @throws Exception
     */
    @RequestMapping("/checkPosOnly")
    @ResponseBody
    public Object checkPosOnly(HttpSession session,String pos_name)throws Exception{
        List<T_Position> positions = (List<T_Position>) session.getAttribute("currentPos");
        for(T_Position p:positions){
            if(p.getPos_name().equals(pos_name)){
                return false;
            }
        }
        return true;
    }

    /**
     * 添加新的部门
     * @return
     * @throws Exception
     */
    @RequestMapping("/addNewDep")
    public String addNewDep(String dep_name)throws Exception{
        T_Department department = new T_Department();
        department.setDep_name(dep_name);
        dep_posService.addNewDep(department);
        return "redirect:/goToDep_PosControl";
    }

    /**
     * 查看指定部门下所有职位
     * @param dep_id
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping("/checkPosInDep")
    public String checkPosInDep(int dep_id,HttpSession session)throws Exception{
        session.setAttribute("currentDep_ID",dep_id);
        List<T_Position> positions = dep_posService.findCurrentPos(dep_id);
        session.setAttribute("currentPos",positions);
        return "adminpages/adminControlPos";
    }

    /**
     * 添加新部门
     * @param position
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping("/addNewPos")
    public String addNewPos(T_Position position,HttpSession session)throws Exception{
        int dep_id = (int) session.getAttribute("currentDep_ID");
        T_Department d = new T_Department();
        d.setDep_id(dep_id);
        position.setDepartment(d);
        dep_posService.addNewPos(position);
        return "redirect:/checkPosInDep?dep_id=dep_id";
    }

    /**
     * 判断职位下是否有所属员工
     * @param pos_id
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping("/checkPosEmpty")
    @ResponseBody
    public Object checkPosEmpty(int pos_id,HttpSession session)throws Exception{
        int dep_id = (int) session.getAttribute("currentDep_ID");
        List<T_Employee> employees = employeeService.findPosEmpty(dep_id,pos_id);
        if(employees.size()==0){
            dep_posService.deletePos(pos_id);
            return true;
        }else{
            return false;
        }
    }

}
