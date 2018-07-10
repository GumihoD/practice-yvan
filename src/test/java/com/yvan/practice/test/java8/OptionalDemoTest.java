package com.yvan.practice.test.java8;

import org.junit.Test;

public class OptionalDemoTest {
    private static OptionalDemo optionalDemo;

    static {
        optionalDemo = new OptionalDemo();
    }

    @Test
    public void test() {
        optionalDemo.test();
    }
}