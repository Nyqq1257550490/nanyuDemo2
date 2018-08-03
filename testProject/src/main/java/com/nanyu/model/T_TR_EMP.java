package com.nanyu.model;

import java.io.Serializable;

/**
 * Created by NCZ on 2018/8/2.
 */
public class T_TR_EMP implements Serializable{
    private int tr_emp_id;
    private T_TRAIN train;
    private T_Employee employee;

    public T_TR_EMP() {
    }

    public int getTr_emp_id() {
        return tr_emp_id;
    }

    public void setTr_emp_id(int tr_emp_id) {
        this.tr_emp_id = tr_emp_id;
    }

    public T_TRAIN getTrain() {
        return train;
    }

    public void setTrain(T_TRAIN train) {
        this.train = train;
    }

    public T_Employee getEmployee() {
        return employee;
    }

    public void setEmployee(T_Employee employee) {
        this.employee = employee;
    }
}
