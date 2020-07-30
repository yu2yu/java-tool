package com.yy.algorithm.stack;

import java.util.Queue;
import java.util.Stack;

/**
 * @description: 验证合法输出栈
 * @author: yy
 * @date: 2020/7/29 18:07
 */
public class ValidateOutStack {

    private Stack<Integer> stack = new Stack<>();

    public boolean validateOut(Queue<Integer> nums, int n){
        // 从1到n进栈
        for (int i = 1; i <= n; i++) {
            stack.push(i);
            while(!stack.isEmpty() && stack.peek().equals(nums.peek())){
                stack.pop();
                nums.poll();
            }
        }
        if(stack.size() > 0){
            return false;
        }
        return true;
    }
}
