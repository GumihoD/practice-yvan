package com.yvan.practice.controller.response;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class RestResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 自定义状态码.
     */
    private int responseCode;

    /**
     * 自定义状态文本.
     */
    private String responseMessage;
}
