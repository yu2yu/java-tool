package com.yy.algorithm.BFS;

import com.yy.algorithm.tree.ergodic.OrderTree;
import com.yy.algorithm.tree.struct.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @description: 二叉树最小深度
 * @author: yy
 * @date: 2020/7/14 16:29
 */
public class TreeMinHeight {

    /**
     * 求树的最小深度
     *  结束条件为：curr.left == null & curr.right == null
     * @param root
     * @return
     */
    public int minDepth(TreeNode root){
        if(root == null){ return 0; }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int depth = 1;

        while(!q.isEmpty()){
            int sz = q.size();
            for(int i=0;i<sz;i++){
                TreeNode curr = q.poll();
                if(curr.getLeftNode() == null && curr.getRightNode() == null){
                    return depth;
                }
                if(curr.getLeftNode() != null){
                    q.offer(curr.getLeftNode());
                }
                if(curr.getRightNode() != null){
                    q.offer(curr.getRightNode());
                }
            }
            depth++;
        }

        return depth;

    }


    public static void main(String[] args) {

        TreeNode root = new OrderTree().buildTree();
        System.out.println(new TreeMinHeight().minDepth(root));
    }
}
