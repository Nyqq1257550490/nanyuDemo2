package com.nanyu.model;

import java.io.Serializable;

/**
 * Created by NCZ on 2018/7/27.
 */
public class T_RE_REC implements Serializable{
    private int re_rec_id;
    private T_RESUME resume;
    private T_RECRUITMENT recruitment;
    private String re_rec_time;
    private String re_rec_facetime;
    private int re_rec_status = 0;//0管理员未回复 1管理员已回复，等待用户确认面试 2管理员拒绝 3用户确认面试 4被用户拒绝
    private String re_rec_intro;//额外消息显示

    public T_RE_REC() {
    }

    public int getRe_rec_id() {
        return re_rec_id;
    }

    public void setRe_rec_id(int re_rec_id) {
        this.re_rec_id = re_rec_id;
    }

    public T_RESUME getResume() {
        return resume;
    }

    public void setResume(T_RESUME resume) {
        this.resume = resume;
    }

    public T_RECRUITMENT getRecruitment() {
        return recruitment;
    }

    public void setRecruitment(T_RECRUITMENT recruitment) {
        this.recruitment = recruitment;
    }

    public String getRe_rec_time() {
        return re_rec_time;
    }

    public void setRe_rec_time(String re_rec_time) {
        this.re_rec_time = re_rec_time;
    }

    public String getRe_rec_facetime() {
        return re_rec_facetime;
    }

    public void setRe_rec_facetime(String re_rec_facetime) {
        this.re_rec_facetime = re_rec_facetime;
    }

    public int getRe_rec_status() {
        return re_rec_status;
    }

    public void setRe_rec_status(int re_rec_status) {
        this.re_rec_status = re_rec_status;
    }

    public String getRe_rec_intro() {
        return re_rec_intro;
    }

    public void setRe_rec_intro(String re_rec_intro) {
        this.re_rec_intro = re_rec_intro;
    }
}
