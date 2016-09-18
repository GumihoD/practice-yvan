package com.yvan.practice.test.demo;

import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

/**
 * Created by yvan on 16/8/4.
 */
public class TestDemo {
    @Test
    public void testDemo() throws InterruptedException, ExecutionException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();//对线程池的扩展
        Future<Integer> result = forkJoinPool.submit(new Demo(1, 10000));
//        System.out.println(result.get());
        forkJoinPool.shutdown();
    }

    @Test
    public void testSum() {
        new Demo(1,10000).sum();
    }
}
