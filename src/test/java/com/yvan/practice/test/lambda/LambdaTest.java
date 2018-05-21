package com.yvan.practice.test.lambda;

import com.google.common.collect.Lists;
import java.util.List;
import org.junit.Test;

public class LambdaTest {

    @Test
    public void sortByComparisonChain() {
        Integer i1 = 1;
        Integer i2 = 2;
        Integer i3 = 3;
        List<Integer> list = Lists.newArrayList();
        list.add(i1);
        list.add(i3);
        list.add(i2);
        new Lambda().sortByComparisonChain(list);
    }
}