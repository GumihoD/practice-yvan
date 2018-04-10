package com.yvan.practice.utils;

import org.junit.Test;

/**
 * Created by yvan on 2016/12/15.
 */
public class RandomListTest {

    /**
     * 利用范型 随机从一个不明类型的容器中取一个对象
     *
     * @throws Exception
     */
    @Test
    public void select() throws Exception {
        RandomList<String> randomList = new RandomList<String>();
        for (String s : (" the litter small big color like love gg").split(" ")) randomList.add(s);
        for (int i = 0; i < randomList.storage.size(); i++) {
            System.out.println(randomList.select() + " ");
        }

        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        RandomList<Integer> randomIntList = new RandomList<Integer>();
        for (Integer s : a) randomIntList.add(s);
        for (int i = 0; i < randomIntList.storage.size(); i++) {
            System.out.println(randomIntList.select() + " ");
        }
    }
}