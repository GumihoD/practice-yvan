package com.yvan.practice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yvan.practice.controller.request.AddBloodOxygenRequest;
import com.yvan.practice.controller.response.AddBloodOxygenResponse;
import com.yvan.practice.dto.ControllerResult;
import com.yvan.practice.entity.mysql.healthmonitor.BloodOxygen;
import com.yvan.practice.service.HealthMonitorService;
import com.yvan.practice.service.MessageService;
import com.yvan.practice.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by yvan on 16/7/20.
 */
@RestController
@RequestMapping("/healthMonitor")
@Api(value = "/healthMonitor",description = "体征监测")
public class HealthMonitorController {
    Logger logger = LoggerFactory.getLogger(HealthMonitorController.class);

    @Autowired
    UserService userService;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    MessageService messageService;

    @Autowired
    HealthMonitorService healthMonitorService;

    /**
     * 记录血氧信息
     *
     * @return
     */
    @RequestMapping(value = "addBloodOxygen", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "记录血氧信息", response = AddBloodOxygenResponse.class)
    public AddBloodOxygenResponse addBloodOxygen(@RequestBody AddBloodOxygenRequest request) {
        BloodOxygen bloodOxygen = new BloodOxygen();
        bloodOxygen.setUserId(request.getUserId());
        bloodOxygen.setOgpr(request.getOgpr());
        bloodOxygen.setSpo2(request.getSpo2());
        bloodOxygen.setTestTime(request.getTestTime());
        bloodOxygen.setIsAbnormal(request.isAbnormal());
        healthMonitorService.addBloodOxygen(bloodOxygen);
        AddBloodOxygenResponse addBloodOxygenResponse = new AddBloodOxygenResponse();
        addBloodOxygenResponse.setResponseMessage("记录血氧信息,操作成功！");
        return addBloodOxygenResponse;
    }

    /**
     * 获取用户血氧信息
     *
     * @return
     */
    @RequestMapping(value = "listFullwayBloodOxygen", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "获取用户血氧信息", response = BloodOxygen.class)
    public ControllerResult<?> listFullwayBloodOxygen(@RequestParam("userId") String userId) {
        logger.info(userId);
        List<BloodOxygen> bloodOxygenList = healthMonitorService.listFullwayBloodOxygen(userId);
        return new ControllerResult<>().setRet_code(0).setRet_values(bloodOxygenList).setMessage("获取用户血氧信息成功");
    }

}