package com.yvan.practice.entity.mysql.user;

import com.yvan.practice.entity.mysql.AbstractBaseEntity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by yvan on 2016/12/14.
 */
@Entity
@Table(name = "role")
public class Role extends AbstractBaseEntity<Long> {
    private String roleName;

    @ManyToMany(mappedBy = "roleList")
    private List<User> userList;

    @OneToMany(mappedBy = "role",fetch = FetchType.EAGER)
    private List<Privilege> privilegeSet;

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public List<Privilege> getPrivilegeSet() {
        return privilegeSet;
    }

    public void setPrivilegeSet(List<Privilege> privilegeSet) {
        this.privilegeSet = privilegeSet;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
