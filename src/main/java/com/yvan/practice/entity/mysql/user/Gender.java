package com.yvan.practice.entity.mysql.user;

/**
 * Created by yvan on 16/7/20.
 */
public enum Gender {
    male("男",0),female("女",1);

    private String gender;

    private int index;

    Gender(String gender, int index) {
        this.gender = gender;
        this.index = index;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
