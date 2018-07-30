package com.nanyu.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by NCZ on 2018/7/25.
 */
public class T_User implements Serializable{
    private int u_id;
    private String u_name;
    private String u_pass;


    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    public String getU_pass() {
        return u_pass;
    }

    public void setU_pass(String u_pass) {
        this.u_pass = u_pass;
    }

    public T_User() {

    }

    public T_User(String u_name, String u_pass) {
        this.u_name = u_name;
        this.u_pass = u_pass;
    }

    @Override
    public String toString() {
        return "T_User{" +
                "u_id=" + u_id +
                ", u_name='" + u_name + '\'' +
                ", u_pass='" + u_pass + '\'' +
                '}';
    }
}
