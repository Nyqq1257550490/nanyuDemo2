package com.nanyu.dao;

import com.nanyu.model.T_RE_REC;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by NCZ on 2018/7/27.
 */
public interface Rec_ReDao {
    boolean saveNewInfo(@Param("resumeId") int resumeId, @Param("rec_id") int rec_id, @Param("time") String time);//添加新的简历—招聘信息表
    List<T_RE_REC> findNewRE_REC(@Param("status") int status);//查找所有未查看的招聘—简历信息
    List<T_RE_REC> getPageRe_Rec(int status,int startPage,int pageSize);//分页查找不同招聘—简历信息

    T_RE_REC findCurrent(@Param("re_rec_id") int re_rec_id);//查找指定id的简历—招聘信息
    boolean updateRE_RECForFace(T_RE_REC t_re_rec);//更新简历—招聘信息
    boolean updateRE_RECForRefuse(T_RE_REC t_re_rec);//拒绝简历—招聘信息

    List<T_RE_REC> getFeedBackRE_REC(@Param("uid") int uid);//用户查看自己投递的反馈
    boolean changeRE_RECStatus(T_RE_REC re_rec);//用户反馈面试邀请，3同意，4拒绝 5面试通过 6面试不通过


}
