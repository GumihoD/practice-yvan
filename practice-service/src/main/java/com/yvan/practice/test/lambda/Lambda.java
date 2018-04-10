package com.yvan.practice.test.lambda;

import java.io.File;
import java.io.FileFilter;

/**
 * Created by yvan on 2017/1/11.
 */
public class Lambda {

    public void testLambda() {
        File dir = new File("/Users/yvan/project/practice-yvan/dir");
        FileFilter fileFilter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory();
            }
        };
        FileFilter fileFilter1 = (File f) -> f.isDirectory();
//        File[]
    }
}
