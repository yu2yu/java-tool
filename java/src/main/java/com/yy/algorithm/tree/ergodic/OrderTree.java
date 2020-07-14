package com.yy.algorithm.tree.ergodic;

import com.yy.algorithm.tree.struct.TreeNode;

/**
 * @description: 前序遍历： 根、左、右
 * @author: yy
 * @date: 2020/7/8 11:09
 */
public class OrderTree {

    public TreeNode buildTree(){
        // 首先建立一棵树
        TreeNode treeNode1 = new TreeNode("A");
        TreeNode treeNode2 = new TreeNode("B");
        TreeNode treeNode3 = new TreeNode("C");
        TreeNode treeNode4 = new TreeNode("D");
        TreeNode treeNode5 = new TreeNode("E");
        TreeNode treeNode6 = new TreeNode("F");
        TreeNode treeNode7 = new TreeNode("G");
        TreeNode treeNode8 = new TreeNode("H");
        TreeNode treeNode9 = new TreeNode("I");

        treeNode1.setLeftNode(treeNode2);
        treeNode1.setRightNode(treeNode3);

        treeNode2.setLeftNode(treeNode4);
        treeNode2.setRightNode(treeNode5);

        treeNode3.setLeftNode(treeNode6);

        treeNode6.setLeftNode(treeNode8);
        treeNode6.setRightNode(treeNode9);

        return treeNode1;
    }

    public void preOrder(TreeNode root){
        if(root == null) {return;}
        System.out.print(root.getVal() + "——》");
        preOrder(root.getLeftNode());
        preOrder(root.getRightNode());
    }

    public void middleOrder(TreeNode root){
        if(root == null) {return;}
        middleOrder(root.getLeftNode());
        System.out.print(root.getVal() + "——》");
        middleOrder(root.getRightNode());
    }

    public void afterOrder(TreeNode root){
        if(root == null) {return;}
        afterOrder(root.getLeftNode());
        afterOrder(root.getRightNode());
        System.out.print(root.getVal() + "——》");
    }

    public static void main(String[] args) {
        OrderTree orderTree = new OrderTree();
        TreeNode root = orderTree.buildTree();
        System.out.println("前序遍历------------");
        orderTree.preOrder(root);
        System.out.println();
        System.out.println("中序遍历------------");
        orderTree.middleOrder(root);
        System.out.println();
        System.out.println("后序遍历------------");
        orderTree.afterOrder(root);
    }

}
