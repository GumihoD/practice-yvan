package com.yvan.practice.test.forkjoin;

import java.util.concurrent.RecursiveTask;

/**
 * Fork/Join框架是Java7提供了的一个用于并行执行任务的框架， 是一个把大任务分割成若干个小任务，
 * 最终汇总每个小任务结果后得到大任务结果的框架
 * Created by yvan on 16/8/4.
 */
public class ForkJoinDemo extends RecursiveTask<Integer> {

    private int start;
    private int end;

    public ForkJoinDemo(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        if (start - end < 100) {
            for (int i = start; i < end; i++) {
                sum += i;
            }
        } else {//间隔有100则拆分多个任务计算
            int middle = (start + end) / 2;
            ForkJoinDemo left = new ForkJoinDemo(start, middle);
            ForkJoinDemo right = new ForkJoinDemo(middle + 1, end);
            left.fork();
            right.fork();

            sum = left.join() + right.join();
        }
        return sum;
    }

    public Integer sum() {
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += i;
        }
        return sum;
    }
}
