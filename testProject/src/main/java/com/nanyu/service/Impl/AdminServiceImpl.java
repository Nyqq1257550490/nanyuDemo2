package com.nanyu.service.Impl;

import com.nanyu.dao.AdminDao;
import com.nanyu.model.T_Admin;
import com.nanyu.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by NCZ on 2018/7/28.
 */
@Service
public class AdminServiceImpl implements AdminService{
    @Resource
    private AdminDao adminDao;

    public void setAdminDao(AdminDao adminDao) {
        this.adminDao = adminDao;
    }

    /**
     * 管理员登录
     * @param admin
     * @return
     */
    @Override
    public T_Admin adminLogin(T_Admin admin) {
        return adminDao.adminLogin(admin);
    }
}
