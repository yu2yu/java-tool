package com.yy.algorithm.link;

import sun.awt.image.ImageWatched;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 合并k个有序链表
 * @author: yy
 * @date: 2020/8/20 14:04
 */
public class LinkNodeMergeK {

    public static LinkNode mergeTwoLinkNode(LinkNode node1,LinkNode node2){

        // 首先新建一个新表头节点
        LinkNode newHead = new LinkNode("0");
        LinkNode pre = newHead;

        while(node1 != null && node2 != null){
            if(Integer.parseInt(node1.getValue()) < Integer.parseInt(node2.getValue())){
                pre.next = node1;
                node1 = node1.next;
            }else{
                pre.next = node2;
                node2 = node2.next;
            }
            pre = pre.next;
        }
        pre.next = node1 == null?node2:node1;
        return newHead.next;
    }

    public static LinkNode mergeKLinkNode(List<LinkNode> nodes){
        // 合并k个链表 归并排序 也就是递归
        return partion(nodes,0,nodes.size()-1);
    }

    public static LinkNode partion(List<LinkNode> lists,int start,int end){
        //终止条件
        if (start == end) {
            return lists.get(start);
        }
        int mid = start + ((end - start) >> 1);
        LinkNode l1 = partion(lists, start, mid);
        LinkNode l2 = partion(lists, mid + 1, end);
        return mergeTwoLinkNode(l1, l2);
    }

    public static void main(String[] args) {
        LinkNode l1 = new LinkNode("1");
        LinkNode l2 = new LinkNode("3");
        LinkNode l3 = new LinkNode("6");
        LinkNode l4 = new LinkNode("9");

        LinkNode l5 = new LinkNode("2");
        LinkNode l6 = new LinkNode("3");
        LinkNode l7 = new LinkNode("5");
        LinkNode l8 = new LinkNode("8");

        LinkNode l9 = new LinkNode("1");
        LinkNode l10 = new LinkNode("4");
        LinkNode l11 = new LinkNode("7");
        LinkNode l12 = new LinkNode("8");

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        l5.next = l6;
        l6.next = l7;
        l7.next = l8;

        l9.next = l10;
        l10.next = l11;
        l11.next = l12;

        ArrayList<LinkNode> nodes = new ArrayList<>();
        nodes.add(l1);
        nodes.add(l5);
        nodes.add(l9);

        LinkNode result = mergeKLinkNode(nodes);

        while(result !=null){
            System.out.print(result.getValue() + "->");
            result = result.next;
        }
    }

}
