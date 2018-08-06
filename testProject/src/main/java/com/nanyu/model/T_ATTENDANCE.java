package com.nanyu.model;

import java.io.Serializable;

/**
 * Created by NCZ on 2018/8/3.
 */
public class T_ATTENDANCE implements Serializable{
    private int a_id;
    private String a_datetime;
    private String a_starttime;
    private String a_endtime;
    private int a_state = -1;//-1旷工 1早迟 2晚迟 3早晚迟
    private T_Employee employee;

    public T_ATTENDANCE() {
    }

    public int getA_id() {
        return a_id;
    }

    public void setA_id(int a_id) {
        this.a_id = a_id;
    }

    public String getA_datetime() {
        return a_datetime;
    }

    public void setA_datetime(String a_datetime) {
        this.a_datetime = a_datetime;
    }

    public String getA_starttime() {
        return a_starttime;
    }

    public void setA_starttime(String a_starttime) {
        this.a_starttime = a_starttime;
    }

    public String getA_endtime() {
        return a_endtime;
    }

    public void setA_endtime(String a_endtime) {
        this.a_endtime = a_endtime;
    }

    public int getA_state() {
        return a_state;
    }

    public void setA_state(int a_state) {
        this.a_state = a_state;
    }

    public T_Employee getEmployee() {
        return employee;
    }

    public void setEmployee(T_Employee employee) {
        this.employee = employee;
    }
}
