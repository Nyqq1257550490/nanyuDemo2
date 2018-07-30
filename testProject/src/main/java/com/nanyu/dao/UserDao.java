package com.nanyu.dao;

import com.nanyu.model.T_User;

import java.util.List;

/**
 * Created by NCZ on 2018/7/25.
 */
public interface UserDao {
    T_User getUserByNameAndPass(T_User t_user);//登录

    List<T_User> findUserName(T_User user); //查询名字

    boolean userResDao(T_User user); //注册
}
