package com.yvan.practice.test.java8;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.function.Consumer;

public class OptionalDemo {

    public void test(){
        Optional<BigDecimal> optional = Optional.of(new BigDecimal(10));
        optional.ifPresent((Consumer) System.out::println);
    }
}
