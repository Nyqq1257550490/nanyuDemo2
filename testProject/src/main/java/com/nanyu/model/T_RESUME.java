package com.nanyu.model;

import java.io.Serializable;

/**
 * Created by NCZ on 2018/7/25.
 */
public class T_RESUME implements Serializable{
    private int re_id;
    private String re_title;
    private T_User t_user;
    private String re_name;
    private String re_sex;
    private int re_age;
    private String re_phone;
    private String re_email;
    private String re_address;
    private String re_school;
    private String re_skill;
    private String re_intro;

    public T_RESUME(String re_title, T_User t_user, String re_name, String re_sex, int re_age, String re_phone, String re_email, String re_address, String re_school, String re_skill, String re_intro) {
        this.re_title = re_title;
        this.t_user = t_user;
        this.re_name = re_name;
        this.re_sex = re_sex;
        this.re_age = re_age;
        this.re_phone = re_phone;
        this.re_email = re_email;
        this.re_address = re_address;
        this.re_school = re_school;
        this.re_skill = re_skill;
        this.re_intro = re_intro;
    }

    public T_RESUME() {
    }

    public T_RESUME(int re_id) {
        this.re_id = re_id;
    }

    public int getRe_id() {
        return re_id;
    }

    public void setRe_id(int re_id) {
        this.re_id = re_id;
    }

    public String getRe_title() {
        return re_title;
    }

    public void setRe_title(String re_title) {
        this.re_title = re_title;
    }

    public T_User getT_user() {
        return t_user;
    }

    public void setT_user(T_User t_user) {
        this.t_user = t_user;
    }

    public String getRe_name() {
        return re_name;
    }

    public void setRe_name(String re_name) {
        this.re_name = re_name;
    }

    public String getRe_sex() {
        return re_sex;
    }

    public void setRe_sex(String re_sex) {
        this.re_sex = re_sex;
    }

    public int getRe_age() {
        return re_age;
    }

    public void setRe_age(int re_age) {
        this.re_age = re_age;
    }

    public String getRe_phone() {
        return re_phone;
    }

    public void setRe_phone(String re_phone) {
        this.re_phone = re_phone;
    }

    public String getRe_email() {
        return re_email;
    }

    public void setRe_email(String re_email) {
        this.re_email = re_email;
    }

    public String getRe_address() {
        return re_address;
    }

    public void setRe_address(String re_address) {
        this.re_address = re_address;
    }

    public String getRe_school() {
        return re_school;
    }

    public void setRe_school(String re_school) {
        this.re_school = re_school;
    }

    public String getRe_skill() {
        return re_skill;
    }

    public void setRe_skill(String re_skill) {
        this.re_skill = re_skill;
    }

    public String getRe_intro() {
        return re_intro;
    }

    public void setRe_intro(String re_intro) {
        this.re_intro = re_intro;
    }

    @Override
    public String toString() {
        return "T_RESUME{" +
                "re_id=" + re_id +
                ", re_title='" + re_title + '\'' +
                ", t_user=" + t_user +
                ", re_name=" + re_name +
                ", re_sex='" + re_sex + '\'' +
                ", re_age=" + re_age +
                ", re_phone='" + re_phone + '\'' +
                ", re_email='" + re_email + '\'' +
                ", re_address='" + re_address + '\'' +
                ", re_school='" + re_school + '\'' +
                ", re_skill='" + re_skill + '\'' +
                ", re_intro='" + re_intro + '\'' +
                '}';
    }
}
