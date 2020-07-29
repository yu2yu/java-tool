package com.yy.algorithm.stack;

import java.util.Stack;

/**
 * @description: 最小栈
 * @author: yy
 * @date: 2020/7/29 17:47
 */
public class MinStack {

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    /**
     * push的时候 需要与minStack比较
     * @param num
     */
    public void push(int num){
        int min = num;
        if(!minStack.isEmpty()){
            min = num < minStack.peek()?num:minStack.peek();
        }
        stack.push(num);
        minStack.push(min);
    }

    public int pop(){
        minStack.pop();
        return stack.pop();
    }

    public int top(){
        return stack.peek();
    }

    public int getMin(){
        return minStack.peek();
    }
}
