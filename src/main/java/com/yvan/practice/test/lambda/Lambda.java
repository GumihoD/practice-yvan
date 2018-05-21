package com.yvan.practice.test.lambda;

import com.google.common.collect.ComparisonChain;
import java.io.File;
import java.io.FileFilter;
import java.util.Collections;
import java.util.List;

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
    }


    public void sortByComparisonChain(List<Integer> list){
        Collections.sort(list, (a, b) -> ComparisonChain.start().compare(a, b).result());
        for (Integer value : list) {
            System.out.println(value);
        }
    }

}
