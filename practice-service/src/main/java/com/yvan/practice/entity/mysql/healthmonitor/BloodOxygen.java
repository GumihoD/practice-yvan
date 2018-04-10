package com.yvan.practice.entity.mysql.healthmonitor;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Du on 2015/11/17.
 */
@Getter
@Setter
@Entity
@Table(name = "blood_oxygen")
public class BloodOxygen extends BaseHealthMonitor {

    /**
     * 血氧脉率
     */
    private String ogpr;

    /**
     * 血氧
     */
    private String spo2;
}
