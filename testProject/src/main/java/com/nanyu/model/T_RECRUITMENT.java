package com.nanyu.model;

import java.io.Serializable;

/**
 * Created by NCZ on 2018/7/26.
 */
public class T_RECRUITMENT implements Serializable{
    private int rec_id;
    private String rec_jobname;
    private String rec_address;
    private int rec_income;
    private String rec_intro;
    private String rec_company;
    private String rec_welfare;
    private int rec_status = 0;//0未发布，1已发布

    public T_RECRUITMENT() {
    }

    public T_RECRUITMENT(int rec_id) {
        this.rec_id = rec_id;
    }

    public int getRec_id() {
        return rec_id;
    }

    public void setRec_id(int rec_id) {
        this.rec_id = rec_id;
    }

    public String getRec_jobname() {
        return rec_jobname;
    }

    public void setRec_jobname(String rec_jobname) {
        this.rec_jobname = rec_jobname;
    }

    public String getRec_address() {
        return rec_address;
    }

    public void setRec_address(String rec_address) {
        this.rec_address = rec_address;
    }

    public int getRec_income() {
        return rec_income;
    }

    public void setRec_income(int rec_income) {
        this.rec_income = rec_income;
    }

    public String getRec_intro() {
        return rec_intro;
    }

    public void setRec_intro(String rec_intro) {
        this.rec_intro = rec_intro;
    }

    public String getRec_company() {
        return rec_company;
    }

    public void setRec_company(String rec_company) {
        this.rec_company = rec_company;
    }

    public String getRec_welfare() {
        return rec_welfare;
    }

    public void setRec_welfare(String rec_welfare) {
        this.rec_welfare = rec_welfare;
    }

    public int getRec_status() {
        return rec_status;
    }

    public void setRec_status(int rec_status) {
        this.rec_status = rec_status;
    }
}
