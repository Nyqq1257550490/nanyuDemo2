package com.nanyu.controller;

import com.nanyu.model.T_RESUME;
import com.nanyu.model.T_User;
import com.nanyu.service.ResumeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by NCZ on 2018/7/26.
 */
@Controller
public class ResumeController {

    @Resource
    private ResumeService resumeService;

    /**
     * 跳转新建简历界面
     * @return
     * @throws Exception
     */
    @RequestMapping("/goToCreateResume")
    public String goToCreateResume()throws Exception{
        return "userpages/createResume";
    }

    /**
     * 跳转简历修改界面
     * @return
     * @throws Exception
     */
    @RequestMapping("/goToChangeResume")
    public String goToChangeResume()throws Exception{
        return "userpages/changeResume";
    }

    /**
     * 添加新简历
     * @return
     * @throws Exception
     */
    @RequestMapping("/addNewResume")
    public String addNewResume(T_RESUME t_resume,HttpSession session)throws Exception{
        T_User user  = (T_User) session.getAttribute("user");
        t_resume.setT_user(user);
        resumeService.addResume(t_resume);
        return "userpages/userMenu";
    }

    /**
     * 修改简历
     * @param t_resume
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping("/updateResume")
    public String updateResume(T_RESUME t_resume,HttpSession session)throws Exception{
        List<T_RESUME> r1 = (List<T_RESUME>) session.getAttribute("resumeDetail");
        int id = r1.get(0).getRe_id();
        t_resume.setRe_id(id);
        resumeService.updateResume(t_resume);
        return "userpages/userMenu";
    }
}
