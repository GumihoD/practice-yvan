package com.yvan.practice.dto;

/**
 * Created by yvan on 16/8/3.
 */
public class Result<RESULTOBJECT> {

    private RESULTOBJECT data;

    public RESULTOBJECT getData() {
        return data;
    }

    public Result<RESULTOBJECT> setData(RESULTOBJECT data) {
        this.data = data;
        return this;
    }

    public static <T> Result<T> commonResult(T data) {
        return new Result<T>().setData(data);
    }

}
