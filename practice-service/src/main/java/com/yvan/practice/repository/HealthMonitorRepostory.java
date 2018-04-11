package com.yvan.practice.repository;

import com.yvan.practice.entity.mysql.healthmonitor.BloodOxygen;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HealthMonitorRepostory extends JpaRepository<BloodOxygen, Long> {

    List<BloodOxygen> findByUserId(String userId);

    List<BloodOxygen> findByUserIdAndTestTimeBetween(String userId, String beginTime, String endTime);

}
