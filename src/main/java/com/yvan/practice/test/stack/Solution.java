package com.yvan.practice.test.stack;

import java.util.Stack;

/**
 *  两个栈做一个队列
 */
public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(Integer node) {
        stack1.add(node);
    }

    public Integer pop() {
        if (!stack2.isEmpty()) {
            return stack2.pop();
        } else {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }
    }

}
