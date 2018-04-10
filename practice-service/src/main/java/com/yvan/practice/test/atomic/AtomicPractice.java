package com.yvan.practice.test.atomic;

import javax.annotation.concurrent.ThreadSafe;
import java.util.concurrent.atomic.AtomicLong;

@ThreadSafe
public class AtomicPractice {
    private final AtomicLong count = new AtomicLong(0);

    public Long getCount() {
        return count.get();
    }

    public Long incrementAndGet() {
        return count.incrementAndGet();
    }
}
