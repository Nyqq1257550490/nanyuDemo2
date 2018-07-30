package com.nanyu.controller;

import com.nanyu.model.T_RESUME;
import com.nanyu.model.T_User;
import com.nanyu.service.ResumeService;
import com.nanyu.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by NCZ on 2018/7/25.
 */
@Controller
public class UserController {
    @Resource
    private UserService userService;
    @Resource
    private ResumeService resumeService;


    /**
     * 跳转到用户登录
     * @return
     * @throws Exception
     */
    @RequestMapping("/goToLoginPage")
    public String goToLoginPage()throws Exception{
        return "userpages/userLogin";
    }

    /**
     * 跳转到用户注册
     * @return
     * @throws Exception
     */
    @RequestMapping("/goToPage")
    public String goToPage()throws Exception{
        return "userpages/userRegiste";
    }

    /**
     * 跳转到用户界面
     * @return
     * @throws Exception
     */
    @RequestMapping("/goToUserMenu")
    public String goToUserMenu(HttpSession session,HttpServletRequest request,int startPage)throws Exception{
        T_User user = (T_User) session.getAttribute("user");
//        System.out.println(startPage);
        int uid = user.getU_id();
//        System.out.println(uid);
        List<T_RESUME> resumeList = resumeService.getAllResume(uid);
        if(resumeList==null){
            request.setAttribute("resumeStatus","还没有任何简历");
        }else{
            final int pageSize = 1;
            int totalRow = resumeList.size();
            int totalPage = totalRow%pageSize==0?totalRow/pageSize:(totalRow/pageSize)+1;
            session.setAttribute("resumeTotalPage",totalPage);
            startPage -= 1;
            System.out.println(startPage);
            List<T_RESUME> resumePageList = resumeService.getPageResume(uid,startPage,pageSize);
            System.out.println(resumePageList);
            session.setAttribute("resumeDetail",resumePageList);
        }
        return "userpages/userMenu";
    }


    /**
     * 用户登录
     * @return
     * @throws Exception
     */
    @RequestMapping("/userLogin")
    public String userLogin(T_User user, HttpSession session, HttpServletRequest request)throws Exception{
        T_User user1 = userService.getUserByNameAndPass(user);
        if(user1!=null){
            session.setAttribute("user",user1);
//            System.out.println(user1);
            return "mainpages/mainPage";
        }else {
            request.setAttribute("error","用户名密码错误");
            return "userpages/userLogin";
        }
    }

    /**
     * 用户注册
     * @param user
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping("/userRegiste")
    public String userRegiste(T_User user, HttpSession session)throws Exception{
        if (userService.userRes(user)){
            session.setAttribute("uerRes", user);
            return "userpages/userLogin";
        }else {
            session.setAttribute("error","用户名重复");
            return "userpages/userRegiste";
        }
    }


}
