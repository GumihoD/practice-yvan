package com.yvan.practice.test.decorate;

import java.io.BufferedWriter;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

/**
 * Created by yvan on 2017/2/6.
 * 装饰器模式在java中的实现
 */
public class DecorateTest {

    public void println(String str) {
        try {
            FileOutputStream fdOut = new FileOutputStream(FileDescriptor.out);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fdOut);
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
            bufferedWriter.write(str);
            bufferedWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
