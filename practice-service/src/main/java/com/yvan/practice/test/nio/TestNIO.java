package com.yvan.practice.test.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by yvan on 16/9/1.
 */
public class TestNIO {

//    public static void main(String[] args) {
//        try {
//            // intBufferDemo();
////            wirteToBuffer();
//            readFromBuffer();
//            proptiesView();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    public static void intBufferDemo() {
        IntBuffer buffer = IntBuffer.allocate(8);

        for (int i = 0; i < buffer.capacity(); ++i) {
            int j = 2 * (i + 1);
            // 将给定整数写入此缓冲区的当前位置，当前位置递增
            buffer.put(j);
        }
        // 重设此缓冲区，将限制设置为当前位置，然后将当前位置设置为0
        buffer.flip();

        // 查看在当前位置和限制位置之间是否有元素
        while (buffer.hasRemaining()) {
            // 读取此缓冲区当前位置的整数，然后当前位置递增
            int j = buffer.get();
            System.out.print(j + "  ");
        }
    }

    /**
     * 任何时候读取数据，都不是直接从通道读取，而是从通道读取到缓冲区
     * 从FileInputStream获取Channel
     * 创建Buffer
     * 将数据从Channel读取到Buffer中
     *
     * @throws IOException
     */
    public static void readFromBuffer() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("/Users/yvan/Downloads/1.sql");
        FileChannel fileChannel = fileInputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        fileChannel.read(byteBuffer);
        // 重设此缓冲区，将限制设置为当前位置，然后将当前位置设置为0
        byteBuffer.flip();
        while (byteBuffer.remaining() > 0) {
            byte b = byteBuffer.get();
            System.out.print((char) b);
            System.out.println();
        }
        fileInputStream.close();
    }

    /**
     * 使用NIO写入数据与读取数据的过程类似，同样数据不是直接写入通道，而是写入缓冲区
     * 从FileInputStream获取Channel
     * 创建Buffer
     * 将数据从Channel写入到Buffer中
     *
     * @throws IOException
     */
    public static void wirteToBuffer() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("/Users/yvan/Downloads/1.sql");
        FileChannel fileChannel = fileOutputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        String info = "Time to study";
        byteBuffer.put(info.getBytes());
        fileChannel.write(byteBuffer);
    }

    /**
     * position：指定了下一个将要被写入或者读取的元素索引，它的值由get()/put()方法自动更新，在新创建一个Buffer对象时，position被初始化为0。
     * limit：指定还有多少数据需要取出(在从缓冲区写入通道时)，或者还有多少空间可以放入数据(在从通道读入缓冲区时)。
     * capacity：指定了可以存储在缓冲区中的最大数据容量，实际上，它指定了底层数组的大小，或者至少是指定了准许我们使用的底层数组的容量。
     */
    public static void proptiesView() {
        IntBuffer buffer = IntBuffer.allocate(8);
        System.out.println("position: "+buffer.position());
        System.out.println("limit: "+buffer.limit());
        System.out.println("capacity: "+buffer.capacity());
    }


}

