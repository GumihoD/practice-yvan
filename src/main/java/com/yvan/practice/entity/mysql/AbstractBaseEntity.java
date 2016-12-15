package com.yvan.practice.entity.mysql;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.AbstractPersistable;
<<<<<<< HEAD
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
=======

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
>>>>>>> feature/first
import java.io.Serializable;
import java.util.Date;

/**
 * Created by yvan on 16/7/20.
 */
<<<<<<< HEAD
@MappedSuperclass
@EntityListeners({AuditingEntityListener.class})
=======
>>>>>>> feature/first
@JsonIgnoreProperties({"new"})
public abstract class AbstractBaseEntity<PK extends Serializable> extends AbstractPersistable<PK> {

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    private Date createDate;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}
