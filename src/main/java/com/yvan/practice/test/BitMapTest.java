package com.yvan.practice.test;

import sun.jvm.hotspot.utilities.BitMap;

/**
 * Bitmap
 * Created by yvan on 2017/8/23.
 */
public class BitMapTest {
    //EWAHCompressedBitmap

    public static void test() {
        BitMap bitMap = new BitMap(10);
        bitMap.atPut(0, true);
        bitMap.atPut(1, true);
        bitMap.atPut(2, true);
        bitMap.atPut(3, true);
        bitMap.atPut(4, true);
        bitMap.atPut(5, true);
        bitMap.atPut(6, true);
        bitMap.atPut(7, true);
        bitMap.atPut(8, true);
        bitMap.atPut(9, false);
        bitMap.atPut(10, true);
        System.out.println(bitMap.at(9));
        bitMap.atPut(11, false);
        System.out.println(bitMap.at(9));
        System.out.println(bitMap.size());
    }

    public static void main(String[] args) {
        test();
        System.out.println(1 << 4);
    }

}
