package com.yvan.practice.entity.mysql.user;

import com.yvan.practice.entity.mysql.AbstractBaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by yvan on 2016/12/14.
 */
@Entity
@Table(name = "privilege")
public class Privilege extends AbstractBaseEntity<Long> {
    private String priName;

    public String getPriName() {
        return priName;
    }

    public void setPriName(String priName) {
        this.priName = priName;
    }

}
