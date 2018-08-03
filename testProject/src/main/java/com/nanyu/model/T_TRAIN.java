package com.nanyu.model;

import java.io.Serializable;

/**
 * Created by NCZ on 2018/8/2.
 */
public class T_TRAIN implements Serializable{
    private int t_id;
    private String t_title;
    private String t_content;
    private String t_starttime;
    private String t_endtime;
    private String t_issuetime;
    private String t_address;
    private int t_state = 0;//0 未发布，1已发布

    public T_TRAIN() {
    }

    public int getT_id() {
        return t_id;
    }

    public void setT_id(int t_id) {
        this.t_id = t_id;
    }

    public String getT_title() {
        return t_title;
    }

    public void setT_title(String t_title) {
        this.t_title = t_title;
    }

    public String getT_content() {
        return t_content;
    }

    public void setT_content(String t_content) {
        this.t_content = t_content;
    }

    public String getT_starttime() {
        return t_starttime;
    }

    public void setT_starttime(String t_starttime) {
        this.t_starttime = t_starttime;
    }

    public String getT_endtime() {
        return t_endtime;
    }

    public void setT_endtime(String t_endtime) {
        this.t_endtime = t_endtime;
    }

    public String getT_issuetime() {
        return t_issuetime;
    }

    public void setT_issuetime(String t_issuetime) {
        this.t_issuetime = t_issuetime;
    }

    public String getT_address() {
        return t_address;
    }

    public void setT_address(String t_address) {
        this.t_address = t_address;
    }

    public int getT_state() {
        return t_state;
    }

    public void setT_state(int t_state) {
        this.t_state = t_state;
    }
}
