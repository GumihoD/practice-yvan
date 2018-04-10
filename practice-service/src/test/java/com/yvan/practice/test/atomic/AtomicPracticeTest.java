package com.yvan.practice.test.atomic;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AtomicPracticeTest {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Test
    public void test() {
        AtomicPractice atomicPractice = new AtomicPractice();
        LOGGER.info(String.valueOf(atomicPractice.getCount()));
        LOGGER.info(String.valueOf(atomicPractice.incrementAndGet()));
    }
}