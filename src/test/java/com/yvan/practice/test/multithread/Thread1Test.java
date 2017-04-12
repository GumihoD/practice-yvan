package com.yvan.practice.test.multithread;

import com.yvan.practice.PracticeYvanApplicationTests;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by yvan on 2017/3/4.
 */
public class Thread1Test {

    @Test
    public void testThread1() throws Exception {
        Thread1 t1 = new Thread1("A");
        Thread1 t2 = new Thread1("B");

        t1.start();
        t2.start();
    }

    @Test
    public void testMyThreadPrinter() throws Exception {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();

        MyThreadPrinter tA = new MyThreadPrinter("A", c, a);
        tA.sleep(100);
        MyThreadPrinter tB = new MyThreadPrinter("B", a, b);
        tA.sleep(100);
        MyThreadPrinter tC = new MyThreadPrinter("C", b, c);
        tA.sleep(100);

    }


}