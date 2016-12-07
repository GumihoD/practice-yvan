package com.yvan.practice.test;

import javax.xml.bind.SchemaOutputResolver;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by yvan on 2016/11/15.
 */
public class TestExam {

//    public static void main(String[] args) {
//        new TestExam().test2();
//    }


    public void tset0() {
        //四位密码
        //5次 6087 5173 1358 3825 2531
        //

    }
    public void test1() {
        int i, j, m;
        Scanner scanner = new Scanner(System.in);
        System.out.println("shuru 1");
        i = scanner.nextInt();
        System.out.println("shuru 2");
        j = scanner.nextInt();
        m = new TestExam().deff(i, j);
        int n = (i * j) / m;
        System.out.println(m);
        System.out.println(n);
    }

    public void test2() {
        int s = 0;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        char c;
        try {
            c = (char) bufferedReader.read();
            while (c != '#') {
                s++;
                c = (char) bufferedReader.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("字符个数： " + s);
    }

    /**
     * 最大公约数
     * 欧几里得算法
     * 辗转相除法
     *
     * @param x
     * @param y
     * @return
     */
    private int deff(int x, int y) {
        int t;
        //确保（假设） x>y的条件
        if (x < y) {
            t = x;
            x = y;
            y = t;
        }
        //整除为止
        while (y != 0) {
            if (x == y) return x;
            else {
                int k = x % y;
                x = y;
                y = k;
            }
        }
        return x;
    }
}
