package com.yvan.practice.controller.request;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

@Getter
@Setter
public class BaseObject implements Serializable {
    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        // OR ToStringStyle.SHORT_PREFIX_STYLE
        return ReflectionToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
