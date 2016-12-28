package com.yvan.practice.entity.mysql.user;

import com.yvan.practice.entity.mysql.AbstractBaseEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by yvan on 2016/12/14.
 */
@Entity
@Table(name = "privilege")
public class Privilege extends AbstractBaseEntity<Long> {
    private String priName;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getPriName() {
        return priName;
    }

    public void setPriName(String priName) {
        this.priName = priName;
    }

}
