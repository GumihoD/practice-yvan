package com.yvan.practice.controller.response;

import com.yvan.practice.entity.mysql.healthmonitor.BloodOxygen;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AddBloodOxygenResponse extends RestResponse {
    @ApiModelProperty("血氧信息")
    List<BloodOxygen> bloodOxygenList;
}
