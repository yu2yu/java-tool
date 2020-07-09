package com.yy.algorithm.tree.struct;

/**
 * @description: 二叉树结构
 * @author: yy
 * @date: 2020/7/8 11:07
 */
public class TreeNode {

    private String val;
    private TreeNode leftNode;
    private TreeNode rightNode;

    public TreeNode(String val) {
        this.val = val;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public TreeNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(TreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public TreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(TreeNode rightNode) {
        this.rightNode = rightNode;
    }
}
