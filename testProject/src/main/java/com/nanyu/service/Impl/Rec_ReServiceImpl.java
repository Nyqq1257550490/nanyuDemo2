package com.nanyu.service.Impl;

import com.nanyu.dao.Rec_ReDao;
import com.nanyu.model.T_RE_REC;
import com.nanyu.service.Rec_ReService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by NCZ on 2018/7/27.
 */
@Service
public class Rec_ReServiceImpl implements Rec_ReService{
    @Resource
    private Rec_ReDao rec_reDao;

    public void setRec_reDao(Rec_ReDao rec_reDao) {
        this.rec_reDao = rec_reDao;
    }

    @Override
    public boolean saveNewInfo(int resumeId, int rec_id, String time) {
        return rec_reDao.saveNewInfo(resumeId,rec_id,time);
    }

    @Override
    public List<T_RE_REC> findNewRE_REC(int status) {
        return rec_reDao.findNewRE_REC(status);
    }

    /**
     * 分页查找不同招聘—简历信息
     * @param status
     * @param startPage
     * @param pageSize
     * @return
     */
    @Override
    public List<T_RE_REC> getPageRe_Rec(int status, int startPage, int pageSize) {
        return rec_reDao.getPageRe_Rec(status,startPage,pageSize);
    }

    /**
     * 查找指定id的简历—招聘信息
     * @param re_rec_id
     * @return
     */
    @Override
    public T_RE_REC findCurrent(int re_rec_id) {
        return rec_reDao.findCurrent(re_rec_id);
    }

    /**
     * 更新简历—招聘信息
     * @param t_re_rec
     * @return
     */
    @Override
    public boolean updateRE_RECForFace(T_RE_REC t_re_rec) {
        return rec_reDao.updateRE_RECForFace(t_re_rec);
    }

    /**
     * 拒绝简历—招聘信息
     * @param t_re_rec
     * @return
     */
    @Override
    public boolean updateRE_RECForRefuse(T_RE_REC t_re_rec) {
        return rec_reDao.updateRE_RECForRefuse(t_re_rec);
    }

    /**
     * 用户查看自己投递的反馈
     * @param uid
     * @return
     */
    @Override
    public List<T_RE_REC> getFeedBackRE_REC(int uid) {
        return rec_reDao.getFeedBackRE_REC(uid);
    }

    /**
     * 用户反馈面试邀请，3同意，4拒绝
     * @param re_rec
     * @return
     */
    @Override
    public boolean changeUserStatus(T_RE_REC re_rec) {
        return rec_reDao.changeUserStatus(re_rec);
    }
}
