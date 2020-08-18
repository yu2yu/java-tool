package com.yy.algorithm.heap;

import io.swagger.models.auth.In;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

/**
 * @description: 数组中的第K个最大元素
 * @author: yy
 * @date: 2020/8/17 17:00
 */
public class KMostHeap {

    /**
     * 找到K个最大元素
     * @param nums
     * @param k
     */
    public static void findKthLargest(int[] nums,int k){
        if(nums.length < k){
            return;
        }
        // 采用小顶堆
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            minHeap.offer(nums[i]);
            // 如果大小超过K则弹出队列最小值
            if(minHeap.size()>k){
                minHeap.poll();
            }
        }
        // 输出
        Integer[] kMost = new Integer[k];
        kMost = minHeap.<Integer>toArray(kMost);
        Arrays.stream(kMost).forEach(System.out::println);
    }

    public static void main(String[] args) {
        int[] nums= new int[]{1,2,3,4,5,6,7,7};
        findKthLargest(nums,2);
     }
}
