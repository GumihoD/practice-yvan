package com.yvan.practice.entity.mysql.user;

import com.yvan.practice.entity.mysql.AbstractBaseEntity;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by yvan on 2016/12/14.
 */
@Entity
@Table(name = "role")
public class Role extends AbstractBaseEntity<Long> {
    private String roleName;


    @OneToMany(cascade = CascadeType.ALL)
    private Set<Privilege> privilegeSet;

    public Set<Privilege> getPrivilegeSet() {
        return privilegeSet;
    }

    public void setPrivilegeSet(Set<Privilege> privilegeSet) {
        this.privilegeSet = privilegeSet;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
