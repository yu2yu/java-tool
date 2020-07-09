package com.yy.algorithm.dp;

import cn.hutool.core.date.DateUtil;

import java.lang.reflect.Array;
import java.util.Vector;

/**
 * @description: 斐波那契数列
 *  通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 *      F(0) = 0,   F(1) = 1 , F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * @author: yy
 * @date: 2020/7/9 10:58
 */
public class FibNaChi {

    /**
     * <p>最糟糕的写法</p>
     * 首先看一下自顶向下递归的n-1和n-2的时间复杂度为 O(2^n)
     * @param n
     * @return int
     */
    public int fiBo(int n){
        if(n == 1|| n == 2){return 1;}
        return fiBo(n-1)+fiBo(n-2);
    }

    /**
     * 属于动态规划问题,带备忘录的递归算法.也就是加一个空间存储之前计算的数据
     * @param n
     * @return
     */
    public int fiBo2(int n){
        if(n < 1){return 0;}
        int[] memo = new int[n+1];
        return helper(memo,n);
    }

    private int helper(int[] memo, int n) {
        if(n == 1 || n == 2) {return 1;}
        if(memo[n] != 0){ return memo[n];}
        memo[n] = helper(memo,n-1) + helper(memo,n-2);
        return memo[n];
    }

    /**
     * 自底向上
     * @param n
     * @return
     */
    public int fiBo3(int n){
        if(n == 1 || n == 2) {return 1;}
        int pre = 1,curr = 1;
        int sum = 0;
        for(int i = 3;i<=n;i++){
            sum = pre + curr;
            pre = curr;
            curr = sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        FibNaChi fibNaChi = new FibNaChi();
        long startTime = System.currentTimeMillis();
        System.out.println(fibNaChi.fiBo(30));
        System.out.println("消耗:" + String.valueOf(System.currentTimeMillis() - startTime));
        startTime = System.currentTimeMillis();
        System.out.println(fibNaChi.fiBo2(30));
        System.out.println("消耗:" + (System.currentTimeMillis() - startTime));
        startTime = System.currentTimeMillis();
        System.out.println(fibNaChi.fiBo3(30));
        System.out.println("消耗:" + String.valueOf(System.currentTimeMillis() - startTime));
    }
}
