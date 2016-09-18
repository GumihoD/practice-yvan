package com.yvan.practice.dto;

import java.util.Collections;

/**
 * Created by lixuanwu on 15/10/12.
 */
public class ControllerResult<RESULTOBJECT> {
    /** 返回编码（0、正确返回， -1、内部错误） */
    private Integer ret_code;
    /** 编码返回描述（泛型返回对象） */
    private RESULTOBJECT ret_values;

    private String message;

    public Integer getRet_code() {
        return ret_code;
    }
    public ControllerResult<RESULTOBJECT> setRet_code(Integer ret_code) {
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
        return  this;
    }

//    public static String defaultFailResultToString(String messages) {
//        return defaultResultToString(-1, messages);
//    }

//    public static String defaultResultToString(int code, String messages) {
//        SimpleFilterProvider provider = new SimpleFilterProvider().setFailOnUnknownId(false);
//        provider.addFilter(ControllerResult.class.getName(), SimpleBeanPropertyFilter.serializeAllExcept("ret_values"));
//        return Jacksons.getInstance().filterProvider(provider).writeAsString(new ControllerResult<>().setRet_code(code).setMessage(messages));
//    }

    public static ControllerResult<?> defaultFailResult(String messages) {
        return defaultResult(-1, messages);
    }

    public static ControllerResult<?> defaultResult(int code, String messages) {
        return new ControllerResult<>().setRet_code(code).setRet_values(Collections.EMPTY_MAP).setMessage(messages);
    }

    public static <T> ControllerResult<T> defaultResult(int code, T body, String messages) {
        return new ControllerResult<T>().setRet_code(code).setRet_values(body).setMessage(messages);
    }

    public static <T> ControllerResult<T> defaultResult(T body) {
        return new ControllerResult<T>().setRet_values(body);
    }


}
