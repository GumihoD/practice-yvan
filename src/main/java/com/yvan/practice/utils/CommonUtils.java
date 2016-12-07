package com.yvan.practice.utils;

import com.fasterxml.jackson.databind.JsonNode;

import java.lang.reflect.Field;

/**
 * Created by yvan on 16/7/20.
 */
public class CommonUtils {

    /**
     * 自定义jsonNode 转对象方法
     *
     * @param jsonNode
     * @param z
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public static Object transforObject(JsonNode jsonNode, Class<?> z) throws IllegalAccessException, InstantiationException {
        Object obj = z.newInstance();
        Field[] declaredFields = z.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            declaredField.set(obj, jsonNode.get(declaredField.getName()).asText());
        }
        return obj;
    }

//    public static void main(String[] args) {
//        HashMap map = new HashMap();
//        Stack stack = new Stack();
//        stack.push(100);
//        stack.push(200);
//        System.out.println(stack.pop());
//
//        Vector vector = new Vector();
//        vector.add("1");
//        vector.add(1);
//        vector.add(1L);
//        vector.iterator();
//        System.out.println(vector.get(1));
//        System.out.println(vector.get(2));
//        System.out.println(vector.get(0));
//
//    }

}
