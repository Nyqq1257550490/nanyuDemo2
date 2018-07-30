package com.nanyu.service.Impl;

import com.nanyu.dao.ResumeDao;
import com.nanyu.model.T_RESUME;
import com.nanyu.service.ResumeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by NCZ on 2018/7/26.
 */
@Service
public class ResumeServiceImpl implements ResumeService{
    @Resource
    private ResumeDao resumeDao;

    public void setResumeDao(ResumeDao resumeDao) {
        this.resumeDao = resumeDao;
    }

    /**
     * 添加新简历
     * @param resume
     * @return
     */
    @Override
    public boolean addResume(T_RESUME resume) {
        return resumeDao.addResume(resume);
    }

    /**
     * 查找用户所有的简历
     * @return
     */
    @Override
    public List<T_RESUME> getAllResume(int uid) {
        return resumeDao.getAllResume(uid);
    }

    /**
     * 查找用户简历 分页
     * @param uid
     * @param startPage
     * @param pageSize
     * @return
     */
    @Override
    public List<T_RESUME> getPageResume(int uid, int startPage, int pageSize) {
        return resumeDao.getPageResume(uid,startPage,pageSize);
    }

    /**
     * 修改简历
     * @param resume
     * @return
     */
    @Override
    public boolean updateResume(T_RESUME resume) {
        return resumeDao.updateResume(resume);
    }

    /**
     * 删除简历
     * @param re_id
     * @return
     */
    @Override
    public boolean deleteResume(int re_id) {
        return resumeDao.deleteResume(re_id);
    }

    /**
     * 通过id查找指定简历表
     * @param re_id
     * @return
     */
    @Override
    public T_RESUME findResume(int re_id) {
        return resumeDao.findResume(re_id);
    }
}
