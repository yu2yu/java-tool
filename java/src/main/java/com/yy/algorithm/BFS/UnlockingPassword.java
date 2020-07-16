package com.yy.algorithm.BFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * @description: 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为  '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
 *
 * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 *
 * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 * 字符串 target 代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，返回 -1。
 *
 * @author: yy
 * @date: 2020/7/15 9:40
 */
public class UnlockingPassword {

    public String plusOne(String curr,int j){
        char[] c= curr.toCharArray();
        if(c[j]=='9'){
            c[j] = '0';
        }else {
            c[j] = (char) (c[j] + 1);
        }
        return new String(c);
    }

    public String minusOne(String curr,int j){
        char[] c= curr.toCharArray();
        if(c[j]=='0'){
            c[j] = '9';
        }else {
            c[j] = (char) (c[j] - 1);
        }
        return new String(c);
    }


    public int minRotating(String start, String end, List<String> deadends){
        // 需要一个队列储存可能选择的列表
        Queue<String> queue = new LinkedList<>();
        // 需要存储访问过的
        Set<String> visited = new HashSet<>();
        queue.offer(start);
        visited.add(start);
        if(start.equals(end)){
            return 0;
        }
        int step = 0;
        while(!queue.isEmpty()){
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                String curr = queue.poll();
                if(curr.equals(end)){
                    return step;
                }
                //验证当前
                if(deadends.contains(curr) || visited.contains(curr)){
                    continue;
                }
                // 相邻节点添加到队列中
                for (int j = 0; j < 4; j++) {
                    String up = plusOne(curr,j);
                    if (!visited.contains(up)) {
                        queue.offer(up);
                        visited.add(up);
                    }
                    String down = minusOne(curr,j);
                    if (!visited.contains(down)) {
                        queue.offer(down);
                        visited.add(down);
                    }
                }
            }
            step++;
        }
        return step;
    }

}
