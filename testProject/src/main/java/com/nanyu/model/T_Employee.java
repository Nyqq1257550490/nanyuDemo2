package com.nanyu.model;

/**
 * Created by NCZ on 2018/7/30.
 */
public class T_Employee {
    private int emp_id;
    private String emp_code;
    private String emp_pass;
    private String emp_name;
    private int emp_age;
    private String emp_sex;
    private String emp_hiredate;
    private int emp_dep_id;
    private int emp_pos_id;
    private int emp_status = 1;//默认到岗
    private String emp_company;
    private String emp_phone;
    private String emp_email;

    public T_Employee() {
    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public String getEmp_code() {
        return emp_code;
    }

    public void setEmp_code(String emp_code) {
        this.emp_code = emp_code;
    }

    public String getEmp_pass() {
        return emp_pass;
    }

    public void setEmp_pass(String emp_pass) {
        this.emp_pass = emp_pass;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public int getEmp_age() {
        return emp_age;
    }

    public void setEmp_age(int emp_age) {
        this.emp_age = emp_age;
    }

    public String getEmp_sex() {
        return emp_sex;
    }

    public void setEmp_sex(String emp_sex) {
        this.emp_sex = emp_sex;
    }

    public String getEmp_hiredate() {
        return emp_hiredate;
    }

    public void setEmp_hiredate(String emp_hiredate) {
        this.emp_hiredate = emp_hiredate;
    }

    public int getEmp_dep_id() {
        return emp_dep_id;
    }

    public void setEmp_dep_id(int emp_dep_id) {
        this.emp_dep_id = emp_dep_id;
    }

    public int getEmp_pos_id() {
        return emp_pos_id;
    }

    public void setEmp_pos_id(int emp_pos_id) {
        this.emp_pos_id = emp_pos_id;
    }

    public int getEmp_status() {
        return emp_status;
    }

    public void setEmp_status(int emp_status) {
        this.emp_status = emp_status;
    }

    public String getEmp_company() {
        return emp_company;
    }

    public void setEmp_company(String emp_company) {
        this.emp_company = emp_company;
    }

    public String getEmp_phone() {
        return emp_phone;
    }

    public void setEmp_phone(String emp_phone) {
        this.emp_phone = emp_phone;
    }

    public String getEmp_email() {
        return emp_email;
    }

    public void setEmp_email(String emp_email) {
        this.emp_email = emp_email;
    }
}
