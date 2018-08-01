package com.nanyu.controller;

import com.nanyu.model.T_Admin;
import com.nanyu.model.T_RECRUITMENT;
import com.nanyu.model.T_RE_REC;
import com.nanyu.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by NCZ on 2018/7/28.
 */
@Controller
public class AdminController {
    @Resource
    private AdminService adminService;

    /**
     * 跳转到管理员登录路界面
     * @return
     * @throws Exception
     */
    @RequestMapping("/goAdminLoginPage")
    public String goAdminLoginPage()throws Exception{
        return "adminpages/adminpages";
    }

    /**
     * 管理员登录
     * @param admin
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/adminLogin")
    public String adminLogin(T_Admin admin, HttpServletRequest request, HttpSession session)throws Exception{
        T_Admin currentAdmin = adminService.adminLogin(admin);
        if(null!=currentAdmin){
            session.setAttribute("admin",currentAdmin);
            return "adminpages/adminMenu";
        }else{
            request.setAttribute("error","用户名密码错误");
            return "adminpages/adminpages";
        }
    }

    /**
     * 跳转查找员工界面
     * @return
     * @throws Exception
     */
    @RequestMapping("/goToEmployeeFinder")
    public String goToEmployeeFinder()throws Exception{
        return "adminpages/adminFindEmployee";
    }


}
