package com.yvan.practice.test.proxy;

/**
 * Created by yvan on 2016/12/19.
 */
public class MemthodPerformance {
    private long begin;
    private long end;
    private String serviceMethod;

    public MemthodPerformance(String serviceMethod) {
        this.serviceMethod = serviceMethod;
        this.begin = System.currentTimeMillis();
    }

    public void printPerformance() {
        end = System.currentTimeMillis();
        long elapse = end - begin;
        System.out.println(serviceMethod + "花费" + elapse + "毫秒。");
    }
}
