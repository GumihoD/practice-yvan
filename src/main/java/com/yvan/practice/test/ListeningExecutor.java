package com.yvan.practice.test;

import com.google.common.collect.Lists;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * 多线程并发处理任务
 * google 带返回值
 *
 * @author yvan
 */
public class ListeningExecutor {

    public void excute(String[] args) throws InterruptedException {
        ListeningExecutorService listeningExecutorService = MoreExecutors.newDirectExecutorService();
        List<Callable<Date>> allThread = new ArrayList<>();
        List<String> TIME_SERVER = Lists.newArrayList();
        for (String timeServer : TIME_SERVER) {
            Callable<Date> callable = createCallable(timeServer);
            allThread.add(callable);
        }

        listeningExecutorService.invokeAll(allThread, 100, TimeUnit.MILLISECONDS);
    }

    /**
     * 返回时间
     */
    private static Callable<Date> createCallable(final String server) {
        return new Callable<Date>() {
            @Override
            public Date call() throws Exception {
                Date date = new Date();
                return date;
            }
        };
    }
}
