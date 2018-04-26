package com.yvan.practice.test.proxy;

/**
 * Created by yvan on 2016/12/19.
 */
public class PerformanceMonitor {
    private static ThreadLocal<MemthodPerformance> performanceRecord = new ThreadLocal<>();

    public static void begin(String memthod) {
        System.out.println("begin monitor...");
        MemthodPerformance mp = new MemthodPerformance(memthod);
        /** Sets the current thread's copy of this thread-local variable to the specified value.*/
        performanceRecord.set(mp);
    }

    public static void end() {
        System.out.println("end monitor...");
        MemthodPerformance mp = performanceRecord.get();
        mp.printPerformance();
    }

}
