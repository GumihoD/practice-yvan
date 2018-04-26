package com.yvan.practice.controller.dto;

import com.yvan.practice.controller.request.BaseObject;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BloodOxygenDto extends BaseObject {
    @ApiModelProperty("用户ID")
    private String userId;

    @ApiModelProperty("测量开始时间")
    private String beginTime;

    @ApiModelProperty("测量结束时间")
    private String endTime;
}
