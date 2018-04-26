package com.yvan.practice.test.multithread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yvan on 2017/3/4.
 */
public class MyThreadPrinter extends Thread {
    private static Logger logger = LoggerFactory.getLogger(MyThreadPrinter.class);

    private String name;
    private Object prev;
    private Object self;

    public MyThreadPrinter(String name, Object prev, Object self) {
        this.name = name;
        this.prev = prev;
        this.self = self;
    }

    @Override
    public void run() {
        int count = 10;
        while (count > 0) {
            synchronized (prev) {
                synchronized (self) {
                    logger.info("this thread name is: " + name);
                    count--;
                    self.notify();
                    try {
                        prev.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}

