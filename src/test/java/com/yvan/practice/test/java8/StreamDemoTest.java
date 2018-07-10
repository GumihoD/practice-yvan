package com.yvan.practice.test.java8;

import org.junit.Test;

import java.io.IOException;

public class StreamDemoTest {
    private static StreamDemo streamDemo;

    static {
        streamDemo = new StreamDemo();
    }

    @Test
    public void test() throws IOException {
        streamDemo.test();
    }
}