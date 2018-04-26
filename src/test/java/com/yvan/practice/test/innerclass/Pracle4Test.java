package com.yvan.practice.test.innerclass;

import org.junit.Test;

/**
 * Created by yvan on 2016/12/22.
 */
public class Pracle4Test {

    @Test
    void test() {
        /** private 内部类给类的设计者提供了一种途径通过这种方式可以完全阻止任何依赖于类型的编码
         *  并且完全隐藏了实现的细节。
         *  此外 从客户端程序员的角度来看，由于不能访问任何新增的、原本不属于公共接口的方法，
         *  所以扩展接口是没有价值的，这也给java编译器提供了生成更高效代码的机会
         */
        Pracle4 p = new Pracle4();
        Contents c = p.contents();
        Destination d = p.destination("Tasmania");
        Pracle4.PDestination pp = p.new PDestination("s");
    }

}