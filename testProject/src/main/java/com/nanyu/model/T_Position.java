package com.nanyu.model;

/**
 * Created by NCZ on 2018/7/30.
 */
public class T_Position {
    private int pos_id;
    private String pos_name;
    private double pos_income;
    private T_Department department;

    public T_Position() {
    }

    public int getPos_id() {
        return pos_id;
    }

    public void setPos_id(int pos_id) {
        this.pos_id = pos_id;
    }

    public String getPos_name() {
        return pos_name;
    }

    public void setPos_name(String pos_name) {
        this.pos_name = pos_name;
    }

    public double getPos_income() {
        return pos_income;
    }

    public void setPos_income(double pos_income) {
        this.pos_income = pos_income;
    }

    public T_Department getDepartment() {
        return department;
    }

    public void setDepartment(T_Department department) {
        this.department = department;
    }
}
