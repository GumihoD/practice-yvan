package com.yvan.practice.controller.response;

import com.yvan.practice.entity.mysql.healthmonitor.BloodOxygen;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class QueryBloodOxygenResponse extends RestResponse {
    @ApiModelProperty("血氧信息列表")
    List<BloodOxygen> bloodOxygenList;
}
