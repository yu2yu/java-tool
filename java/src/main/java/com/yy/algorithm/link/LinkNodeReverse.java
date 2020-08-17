package com.yy.algorithm.link;

import sun.awt.image.ImageWatched;

/**
 * @description: 链表逆序
 * @author: yy
 * @date: 2020/8/14 10:18
 */
public class LinkNodeReverse {

    private static class LinkNode{
        private String value;
        private LinkNode next;

        public LinkNode(String value) {
            this.value = value;
        }
    }

    /**
     * 整个表逆序
     * @param head
     * @return
     */
    public static LinkNode linkReverse(LinkNode head){
        // 首先先定义一个new_head然后滑动
        LinkNode new_head = null;
        while(head!= null){
            LinkNode n1 = head.next;
            head.next = new_head;
            new_head = head;
            head = n1;
        }
        return new_head;
    }

    /**
     * 部分链表逆序
     * @param head
     * @param start
     * @param end
     * @return
     */
    public static LinkNode linkReverse(LinkNode head,int start,int end){
        int num=0;
        LinkNode node1 = head;
        LinkNode prev = null;
        LinkNode tail = null;

        while(node1!=null){
            num++;
            prev = num==start-1?node1:prev;
            tail = num==end+1?node1:tail;
            node1 = node1.next;
        }

        node1 = prev==null?head:prev.next;
        LinkNode curr =node1.next;
        node1.next = tail;
        LinkNode next = null;
        while (curr != tail){
            next = curr.next;
            curr.next = node1;
            node1 = curr;
            curr = next;
        }
        if (prev != null) {
            prev.next = node1;
            return head;
        }
        return node1;
    }

    public static void main(String[] args) {
        LinkNode l1 = new LinkNode("2");
        LinkNode l2 = new LinkNode("3");
        LinkNode l3 = new LinkNode("4");
        LinkNode l4 = new LinkNode("5");
        LinkNode l5 = new LinkNode("6");
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        LinkNode reverseNode = linkReverse(l1);
        while(reverseNode != null){
            System.out.print(reverseNode.value);
            reverseNode = reverseNode.next;
        }

        LinkNode reverseNode2 = linkReverse(l1,2,4);
        while(reverseNode2 != null){
            System.out.print(reverseNode2.value);
            reverseNode2 = reverseNode2.next;
        }
    }

}
