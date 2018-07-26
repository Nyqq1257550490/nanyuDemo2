package com.nanyu.service.Impl;

import com.nanyu.dao.UserDao;
import com.nanyu.model.T_User;
import com.nanyu.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by NCZ on 2018/7/25.
 */
@Service
public class UserServiceImpl implements UserService{
    @Resource
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    /**
     * 登录
     * @param user
     * @return
     */
    @Override
    public T_User getUserByNameAndPass(T_User user) {
        return userDao.getUserByNameAndPass(user);
    }

    /**
     * 注册
     * @param user
     * @return
     */
    @Override
    public boolean userRes(T_User user) {
        List<T_User> userName = userDao.findUserName(user);
        if (userName.size()==0){
            return userDao.userResDao(user);
        }else {
            for (T_User user1:userName){
                if (user1.getU_name().equals(user.getU_name())){
                    return false;
                }
            }
            return userDao.userResDao(user);
        }
    }
}
