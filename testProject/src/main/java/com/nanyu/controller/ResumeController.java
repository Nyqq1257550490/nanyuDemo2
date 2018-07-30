package com.nanyu.controller;

import com.nanyu.model.T_RESUME;
import com.nanyu.model.T_User;
import com.nanyu.service.ResumeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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
        return "redirect:/goToUserMenu?startPage=0";
    }

    /**
     * 修改简历
     * @param t_resume
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping("/updateResume")
    public String updateResume(T_RESUME t_resume, HttpSession session, HttpServletRequest request)throws Exception{
        List<T_RESUME> r1 = (List<T_RESUME>) session.getAttribute("resumeDetail");
        int id = r1.get(0).getRe_id();
        t_resume.setRe_id(id);
        resumeService.updateResume(t_resume);
        return "redirect:/goToUserMenu?startPage=0";
    }

    /**
     * 删除简历
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping("/deleteResume")
    public String deleteResume(HttpSession session)throws Exception{
        List<T_RESUME> r1 = (List<T_RESUME>) session.getAttribute("resumeDetail");
        int id = r1.get(0).getRe_id();
        resumeService.deleteResume(id);
        return "redirect:/goToUserMenu?startPage=0";
    }

    /**
     * 选择投递的简历选择
     * @param session
     * @param recruitmentId
     * @return
     * @throws Exception
     */
    @RequestMapping("/sendRecruitment")
    public String sendRecruitment(HttpSession session,int recruitmentId,int startPage,HttpServletRequest request)throws Exception{
        T_User user = (T_User) session.getAttribute("user");
        if(null==user){
            return "userpages/userLogin";
        }else{
            session.setAttribute("sendRecruitmentId",recruitmentId);
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
                List<T_RESUME> resumePageList = resumeService.getPageResume(uid,startPage,pageSize);
                session.setAttribute("resumeDetail",resumePageList);
            }
            return "userpages/sendResume";
        }
    }

    /**
     * 查看所投简历表
     * @return
     * @throws Exception
     */
    @RequestMapping("/checkRe_RecResume")
    public String checkRe_RecResume(int re_id,HttpSession session)throws Exception{
        T_RESUME resume = resumeService.findResume(re_id);
        session.setAttribute("checkResume",resume);
        return "adminpages/adminCheckCurrentResume";
    }
}
