package com.nanyu.model;

/**
 * Created by NCZ on 2018/7/30.
 */
public class T_Department {
    private int dep_id;
    private String dep_name;
    private String dep_createtime;

    public T_Department() {
    }

    public int getDep_id() {
        return dep_id;
    }

    public void setDep_id(int dep_id) {
        this.dep_id = dep_id;
    }

    public String getDep_name() {
        return dep_name;
    }

    public void setDep_name(String dep_name) {
        this.dep_name = dep_name;
    }

    public String getDep_createtime() {
        return dep_createtime;
    }

    public void setDep_createtime(String dep_createtime) {
        this.dep_createtime = dep_createtime;
    }
}
