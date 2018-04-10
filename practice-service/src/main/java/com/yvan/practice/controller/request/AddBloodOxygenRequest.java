package com.yvan.practice.controller.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddBloodOxygenRequest extends BaseObject {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("用户ID")
    private String userId;

    @ApiModelProperty("血氧脉率")
    private String ogpr;

    @ApiModelProperty("血氧")
    private String spo2;

    @ApiModelProperty("是否异常")
    private boolean isAbnormal;

    @ApiModelProperty("测量时间")
    private String testTime;
}
