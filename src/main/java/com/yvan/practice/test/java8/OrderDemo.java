package com.yvan.practice.test.java8;

public class OrderDemo {
    public OrderDemo() {
        System.out.println("构造方法");
    }

    {
        System.out.println("动态块");
    }

    static {
        System.out.println("静态块");
    }

    private String variable = "变量";

    private static String staticVariable = "静态变量";

    public void test() {
        String staticLocalVariable = "局部静态变量";
        String localVariable = "局部变量";
    }

}
