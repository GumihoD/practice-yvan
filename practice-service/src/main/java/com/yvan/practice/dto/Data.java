package com.yvan.practice.dto;

/**
 * Created by yvan on 16/8/6.
 */
public class Data {
    private String fullName;
    private String mobile;
    private int temp_id;


    public int getTemp_id() {
        return temp_id;
    }

    public void setTemp_id(int temp_id) {
        this.temp_id = temp_id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
