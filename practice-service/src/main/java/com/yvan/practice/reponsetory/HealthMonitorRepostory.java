package com.yvan.practice.reponsetory;

import com.yvan.practice.entity.mysql.healthmonitor.BloodOxygen;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HealthMonitorRepostory extends JpaRepository<BloodOxygen, Long> {

    List<BloodOxygen> findByUserId(String userId);
}
