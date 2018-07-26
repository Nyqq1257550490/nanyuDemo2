package com.nanyu.service;

import com.nanyu.model.T_User;

/**
 * Created by NCZ on 2018/7/25.
 */
public interface UserService {
    T_User getUserByNameAndPass(T_User user);//登录
    boolean userRes(T_User user);//注册
}
