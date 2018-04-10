package com.yvan.practice.test.multithread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yvan on 2017/3/4.
 */
public class Thread1 extends Thread {
    private Logger logger = LoggerFactory.getLogger(Thread1.class);

    private String name;

    public Thread1(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            logger.info(name + "运行 :  " + i);
        }
    }
}
