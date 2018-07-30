package com.nanyu.model;

import java.io.Serializable;

/**
 * Created by NCZ on 2018/7/28.
 */
public class T_Admin implements Serializable{
    private int m_id;
    private String m_name;
    private String m_pass;

    public T_Admin() {
    }

    public int getM_id() {
        return m_id;
    }

    public void setM_id(int m_id) {
        this.m_id = m_id;
    }

    public String getM_name() {
        return m_name;
    }

    public void setM_name(String m_name) {
        this.m_name = m_name;
    }

    public String getM_pass() {
        return m_pass;
    }

    public void setM_pass(String m_pass) {
        this.m_pass = m_pass;
    }
}
