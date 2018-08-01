package com.nanyu.controller;

import com.nanyu.model.*;
import com.nanyu.service.MainService;
import com.nanyu.service.Rec_ReService;
import com.nanyu.service.RecruitmentService;
import com.nanyu.tools.TimeTool;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * Created by NCZ on 2018/7/27.
 */
@Controller
public class RecruitmentController {
    @Resource
    private MainService mainService;
    @Resource
    private RecruitmentService recruitmentService;
    @Resource
    private Rec_ReService rec_reService;

    /**
     * 跳转到招聘信息界面
     * @param request
     * @param session
     * @param startPage
     * @return
     * @throws Exception
     */
    @RequestMapping("/goToRecruitmentPage")
    public String goToRecruitmentPage(HttpServletRequest request, HttpSession session,int startPage)throws Exception{
//        System.out.println(startPage);
        List<T_RECRUITMENT> recruitmentList = recruitmentService.findAble(1);
        if(recruitmentList==null){
            request.setAttribute("resumeStatus","还没有任何简历");
        }else{
            int status = 1;
            final int pageSize = 3;
            int totalRow = recruitmentList.size();
            int totalPage = totalRow%pageSize==0?totalRow/pageSize:(totalRow/pageSize)+1;
            session.setAttribute("recruitmentTotalPage",totalPage);
            List<T_RECRUITMENT> recruitmentPageList = recruitmentService.getPageRecruitment(status,startPage,pageSize);
            session.setAttribute("recruitmentDetail",recruitmentPageList);
        }
        return "mainpages/recruitmentPage";
    }

    /**
     * 发送简历，生成简历-招聘关系表
     * @param session
     * @param resumeId
     * @return
     * @throws Exception
     */
    @RequestMapping("/creatResumeToRecruitment")
    public String creatResumeToRecruitment(HttpSession session,int resumeId)throws Exception{
        int rec_id = (int) session.getAttribute("sendRecruitmentId");
        String time = TimeTool.getCurrentTime();
        rec_reService.saveNewInfo(resumeId,rec_id,time);
        return "userpages/sendResumeSuccess";
    }

    /**
     * 查看招聘情况
     * @return
     * @throws Exception
     */
    @RequestMapping("/checkResumeSended")
    public String checkResumeSended(int startPage,int status,HttpSession session,HttpServletRequest request)throws Exception{
        List<T_RE_REC> re_recList = rec_reService.findNewRE_REC(status);
        if(re_recList==null){
            request.setAttribute("re_recStatus","还没有任何简历");
        }else{
            final int pageSize = 5;
            int totalRow = re_recList.size();
            int totalPage = totalRow%pageSize==0?totalRow/pageSize:(totalRow/pageSize)+1;
            session.setAttribute("re_recTotalPage",totalPage);
            List<T_RE_REC> resumePageList = rec_reService.getPageRe_Rec(status,startPage,pageSize);
            session.setAttribute("re_recDetail",resumePageList);
        }
        return "adminpages/adminCheckResume";
    }

    /**
     * 发送面试时间
     * @param re_rec_facetime
     * @param re_rec_id
     * @return
     * @throws Exception
     */
    @RequestMapping("/sendFaceRequest")
    public String sendFaceRequest(String re_rec_facetime,int re_rec_id)throws Exception{
        String[] strings = re_rec_facetime.split("T");
        String facetime = strings[0]+" "+strings[1];
        T_RE_REC re_rec = rec_reService.findCurrent(re_rec_id);
        re_rec.setRe_rec_facetime(facetime);
        re_rec.setRe_rec_status(1);
        rec_reService.updateRE_RECForFace(re_rec);
        return "redirect:/checkResumeSended?startPage=0";
    }

    /**
     * 拒绝投递的简历
     * @return
     * @throws Exception
     */
    @RequestMapping("/refuseRE_REC")
    public String refuseRE_REC(int re_rec_id)throws Exception{
        T_RE_REC re_rec = rec_reService.findCurrent(re_rec_id);
        re_rec.setRe_rec_status(2);
        rec_reService.updateRE_RECForRefuse(re_rec);
        return "redirect:/checkResumeSended?startPage=0";
    }

    /**
     * 用户查看自己投递的反馈
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping("/checkSelfRE_REC")
    public String checkSelfRE_REC(HttpSession session)throws Exception{
        T_User user = (T_User) session.getAttribute("user");
        int uid = user.getU_id();
        List<T_RE_REC> re_recList = rec_reService.getFeedBackRE_REC(uid);
        session.setAttribute("feedBackRE_REC",re_recList);
        return "userpages/userFeedBack";
    }

    /**
     * 用户反馈面试邀请
     * @return
     * @throws Exception
     */
    @RequestMapping("/userAnswerFace")
    public String userAnswerFace(int changeStatus,HttpSession session)throws Exception{
        T_RE_REC re_rec = (T_RE_REC) session.getAttribute("feedBackRE_REC");
        re_rec.setRe_rec_status(changeStatus);
        rec_reService.changeRE_RECStatus(re_rec);
        return "redirect:/checkSelfRE_REC";
    }

    /**
     * 制作新的招聘信息（未上架）
     * @param recruitment
     * @return
     * @throws Exception
     */
    @RequestMapping("/createRecruitment")
    public String createRecruitment(T_RECRUITMENT recruitment)throws Exception{
        recruitment.setRec_status(0);
        recruitmentService.saveNewRec(recruitment);
        return "adminpages/adminMenu";
    }

    /**
     * 去上下架招聘信息页面
     * @return
     * @throws Exception
     */
    @RequestMapping("/goUpDownRecruitment")
    public String goUpDownRecruitment(HttpSession session)throws Exception{
        int status = 1;
        List<T_RECRUITMENT> recruitmentList = recruitmentService.findRecruitment(status);
        session.setAttribute("recruitmentView",recruitmentList);
        return "adminpages/adminUpDownRecruitment";
    }

    /**
     * 修改招聘信息
     * @param recruitment
     * @return
     * @throws Exception
     */
    @RequestMapping("/modifyRecruitment")
    public String modifyRecruitment(T_RECRUITMENT recruitment)throws Exception{
        recruitmentService.modifyRecruitment(recruitment);
        return "redirect:/goUpDownRecruitment";
    }

    /**
     * 查看等待面试结果的信息
     * @return
     * @throws Exception
     */
    @RequestMapping("/inRollFaceTest")
    public String inRollFaceTest(HttpSession session)throws Exception{
        int status = 3;
        List<T_RE_REC> re_recList = rec_reService.findNewRE_REC(status);
        session.setAttribute("re_recForFace",re_recList);
        return "adminpages/adminInRollFace";
    }

    /**
     * 面试遭拒绝
     * @param re_rec_id
     * @param status
     * @return
     * @throws Exception
     */
    @RequestMapping("/changeRE_RECStatus")
    public String changeRE_RECStatus(int re_rec_id,int status)throws Exception{
        T_RE_REC re_rec = new T_RE_REC(re_rec_id,status);
        rec_reService.changeRE_RECStatus(re_rec);
        return "redirect:/inRollFaceTest";
    }

    /**
     * 直接跳转录用员工界面
     * @param session
     * @param fromNum
     * @return
     * @throws Exception
     */
    @RequestMapping("/CreateEmployee")//fromNum = 0面试——录用，1直接录用
    public String createEmployee(HttpSession session,int fromNum,int re_rec_id)throws Exception{
        session.setAttribute("fromNum",fromNum);
        T_RE_REC re_rec = rec_reService.findCurrent(re_rec_id);
        session.setAttribute("inRollRe_Rec",re_rec);
        List<T_Department> departments = mainService.findAllDepartment();
        session.setAttribute("departments",departments);
        return "adminpages/adminAddEmployee";
    }

}
