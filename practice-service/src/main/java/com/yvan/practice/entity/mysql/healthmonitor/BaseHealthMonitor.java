package com.yvan.practice.entity.mysql.healthmonitor;

import com.yvan.practice.entity.mysql.AbstractBaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * Created by Du on 2015/11/17.
 */

@Getter
@Setter
@MappedSuperclass
public abstract class BaseHealthMonitor extends AbstractBaseEntity<Long> {

    private long primaryKey;

    private String testTime;
    /**
     * 是否上传
     * 0 - 未上传
     * 1 - 已上传
     */
    @Column(columnDefinition="boolean default true")
    private Boolean isUpload;

    private Boolean isAbnormal;

    private String annotation;

    private String userId;
}
