package com.nanyu.model;

import java.io.Serializable;

/**
 * Created by NCZ on 2018/8/3.
 */
public class T_DESERT implements Serializable{
    private int de_id;
    private T_Employee employee;
    private String de_time;
    private String de_intro;
    private double de_money;
    private int de_state;//1加班奖励 -1迟到

    public T_DESERT() {
    }

    public int getDe_id() {
        return de_id;
    }

    public void setDe_id(int de_id) {
        this.de_id = de_id;
    }

    public T_Employee getEmployee() {
        return employee;
    }

    public void setEmployee(T_Employee employee) {
        this.employee = employee;
    }

    public String getDe_time() {
        return de_time;
    }

    public void setDe_time(String de_time) {
        this.de_time = de_time;
    }

    public String getDe_intro() {
        return de_intro;
    }

    public void setDe_intro(String de_intro) {
        this.de_intro = de_intro;
    }

    public double getDe_money() {
        return de_money;
    }

    public void setDe_money(double de_money) {
        this.de_money = de_money;
    }

    public int getDe_state() {
        return de_state;
    }

    public void setDe_state(int de_state) {
        this.de_state = de_state;
    }
}
