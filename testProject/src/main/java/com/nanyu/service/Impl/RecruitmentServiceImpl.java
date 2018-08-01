package com.nanyu.service.Impl;

import com.nanyu.dao.RecruitmentDao;
import com.nanyu.model.T_RECRUITMENT;
import com.nanyu.service.RecruitmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by NCZ on 2018/7/27.
 */
@Service
public class RecruitmentServiceImpl implements RecruitmentService{
    @Resource
    private RecruitmentDao recruitmentDao;

    public void setRecruitmentDao(RecruitmentDao recruitmentDao) {
        this.recruitmentDao = recruitmentDao;
    }

    /**
     * 查找所有的招聘信息
     * @return
     */
    @Override
    public List<T_RECRUITMENT> findAble(int status) {
        return recruitmentDao.findAble(status);
    }

    /**
     * 分页查看招聘信息
     * @param startPage
     * @param pageSize
     * @return
     */
    @Override
    public List<T_RECRUITMENT> getPageRecruitment(int status,int startPage, int pageSize) {
        return recruitmentDao.getPageRecruitment(status,startPage,pageSize);
    }

    /**
     * 制作新的招聘信息（未上架）
     * @param recruitment
     * @return
     */
    @Override
    public boolean saveNewRec(T_RECRUITMENT recruitment) {
        return recruitmentDao.saveNewRec(recruitment);
    }

    /**
     * 查找指定状态的招聘信息
     * @param status
     * @return
     */
    @Override
    public List<T_RECRUITMENT> findRecruitment(int status) {
        return recruitmentDao.findRecruitment(status);
    }

    /**
     * 修改招聘信息
     * @param recruitment
     * @return
     */
    @Override
    public boolean modifyRecruitment(T_RECRUITMENT recruitment) {
        return recruitmentDao.modifyRecruitment(recruitment);
    }
}
