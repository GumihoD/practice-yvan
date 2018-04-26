package com.yvan.practice.controller.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QueryBloodOxygenRequest extends BaseObject {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("用户ID")
    private String userId;

    @ApiModelProperty("测量开始时间")
    private String beginTime;

    @ApiModelProperty("测量结束时间")
    private String endTime;
}
