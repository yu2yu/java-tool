package com.yy.algorithm.backTrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 全排列问题
 *  回溯算法主要是 路径（做出选择）、选择列表、结束条件
 * @author: yy
 * @date: 2020/7/13 10:04
 */
public class BackTrack {

    List<List<Integer>> trackList = new LinkedList<>();

    public void backTrack(int[] nums, List<Integer> track){
        if(nums.length == track.size()){
            trackList.add(new LinkedList<>(track));
            return;
        }
        for(int num:nums){
            if(track.contains(num)){
                continue;
            }
            // 做选择
            track.add(num);
            // 进入下一层决策树
            backTrack(nums,track);
            // 取消选择，回到上一层做选择
            track.remove(track.size()-1);
        }
    }

    public static void main(String[] args) {
        List<Integer> track = new LinkedList<>();
        int[] nums = new int[]{1,2,3};
        BackTrack backTrack = new BackTrack();
        backTrack.backTrack(nums,track);
        backTrack.trackList.forEach(k -> k.forEach(System.out::println));
    }
}
