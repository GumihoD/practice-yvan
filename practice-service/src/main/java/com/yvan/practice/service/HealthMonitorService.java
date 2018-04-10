package com.yvan.practice.service;

import com.yvan.practice.entity.mysql.healthmonitor.BloodOxygen;
import com.yvan.practice.reponsetory.HealthMonitorRepostory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HealthMonitorService {

    @Autowired
    HealthMonitorRepostory healthMonitorRepostory;

    public void addBloodOxygen(BloodOxygen bloodOxygen) {
        healthMonitorRepostory.save(bloodOxygen);
    }

    public List<BloodOxygen> listFullwayBloodOxygen(String userId) {
        List<BloodOxygen> result = healthMonitorRepostory.findByUserId(userId);
        return result;
    }
}
