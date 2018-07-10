package com.yvan.practice.test.java8;

import org.junit.Test;

public class DateTimeDemoTest {
    private static DateTimeDemo dateTimeDemo;

    static {
        dateTimeDemo = new DateTimeDemo();
    }

    @Test
    public void test() {
        dateTimeDemo.test();
    }

    @Test
    public void instantTest() throws InterruptedException {
        dateTimeDemo.instantTest();
    }

    @Test
    public void localDateTest() {
        dateTimeDemo.localDateTest();
    }

    @Test
    public void adjustersTest() {
        dateTimeDemo.adjustersTest();
    }

    @Test
    public void localTimeTest() {
        dateTimeDemo.localTimeTest();
    }

}