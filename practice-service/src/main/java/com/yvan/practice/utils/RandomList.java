package com.yvan.practice.utils;

import java.util.ArrayList;
import java.util.Random;

/**
 * 随机数取对象
 * <p>
 * Created by yvan on 2016/12/15.
 */
public class RandomList<T> {
    public ArrayList<T> storage = new ArrayList<T>();
    private Random random = new Random();

    public void add(T item) {
        storage.add(item);
    }

    public T select() {
        return storage.get(random.nextInt(storage.size()));
    }
}
