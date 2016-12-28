package com.yvan.practice.dto;

import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.yvan.practice.utils.Jacksons;

import java.util.Collections;

/**
 * Created by yvan on 16/8/3.
 */
public class ControllerResult<RESULTOBJECT> {

    /**
     * 返回编码（200-正确返回， 500-内部错误）
     */
    private int ret_code = 200;
    /**
     * 编码返回描述（泛型返回对象）
     */
    private RESULTOBJECT ret_values;
    /**
     * 返回信息描述
     */
    private String message;

    public int getRet_code() {
        return ret_code;
    }

    public ControllerResult<RESULTOBJECT> setRet_code(int ret_code) {
        this.ret_code = ret_code;
        return this;
    }

    public RESULTOBJECT getRet_values() {
        return ret_values;
    }

    public ControllerResult<RESULTOBJECT> setRet_values(RESULTOBJECT ret_values) {
        this.ret_values = ret_values;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ControllerResult<RESULTOBJECT> setMessage(String message) {
        this.message = message;
        return this;
    }

    public static <T> ControllerResult<T> defaultSuccessResult(T ret_values) {
        return new ControllerResult().setRet_code(200).setRet_values(ret_values);
    }

    public static <T> ControllerResult<T> defaultNullSuccessResult(String message) {
        return new ControllerResult().setRet_values("").setMessage(message);
    }

    public static String defaultResultToString(int code, String messages) {
        SimpleFilterProvider provider = new SimpleFilterProvider().setFailOnUnknownId(false);
        provider.addFilter(ControllerResult.class.getName(), SimpleBeanPropertyFilter.serializeAllExcept("ret_values"));
        return Jacksons.getInstance().filterProvider(provider).writeAsString(new ControllerResult<>().setRet_code(code).setMessage(messages));
    }

    public static ControllerResult<?> defaultFailResult(String messages) {
        return defaultResult(-1, messages);
    }

    public static ControllerResult<?> defaultResult(int code, String messages) {
        return new ControllerResult<>().setRet_code(code).setRet_values(Collections.EMPTY_MAP).setMessage(messages);
    }

    public static <T> ControllerResult<T> defaultResult(int code, T body, String messages) {
        return new ControllerResult<T>().setRet_code(code).setRet_values(body).setMessage(messages);

    }

}
