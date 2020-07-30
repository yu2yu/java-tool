package com.yy.algorithm.stack;

import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @description: 栈算法题 one
 * @author: yy
 * @date: 2020/7/29 17:46
 */
public class StackDemo1 {

    public void testMinStack(){
        MinStack minStack = new MinStack();
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.push(-4);
        System.out.println(minStack.getMin());
        minStack.push(4);
        System.out.println(minStack.getMin());
        minStack.push(-5);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }


    public void testValidate(){
        LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);
        if (new ValidateOutStack().validateOut(queue,5)) {
            System.out.println("验证通过1");
        }

        queue.clear();
        queue.offer(1);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);
        queue.offer(2);
        if (new ValidateOutStack().validateOut(queue,5)) {
            System.out.println("验证通过2");
        }

        queue.clear();
        queue.offer(3);
        queue.offer(1);
        queue.offer(4);
        queue.offer(5);
        queue.offer(2);
        if (new ValidateOutStack().validateOut(queue,5)) {
            System.out.println("验证通过3");
        }
    }

    public static void main(String[] args) {
        new StackDemo1().testValidate();
    }

}
