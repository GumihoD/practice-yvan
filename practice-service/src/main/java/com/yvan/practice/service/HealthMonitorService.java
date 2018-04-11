package com.yvan.practice.service;

import com.yvan.practice.controller.dto.BloodOxygenDto;
import com.yvan.practice.entity.mysql.healthmonitor.BloodOxygen;
import com.yvan.practice.repository.HealthMonitorRepostory;
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

    public List<BloodOxygen> listBloodOxygen(BloodOxygenDto bloodOxygenDto) {
        List<BloodOxygen> result = healthMonitorRepostory.findByUserIdAndTestTimeBetween(bloodOxygenDto.getUserId(),
                bloodOxygenDto.getBeginTime(), bloodOxygenDto.getEndTime());
        return result;
    }
}
