package com.yy.algorithm.link;

import sun.awt.image.ImageWatched;

/**
 * @description: 求两个链表的相交节点
 * @author: yy
 * @date: 2020/8/17 14:08
 */
public class LinkNodeCross {

    public static int getLenList(LinkNode head){
        int len = 0;
        while(head != null){
            len++;
            head = head.next;
        }
        return len;
    }

    public static LinkNode removeReduant(LinkNode head,int len){
        while(len>0){
            head = head.next;
            len--;
        }
        return head;
    }


    public static LinkNode linkNodeCross(LinkNode l1,LinkNode l2){

        LinkNode nodeL1 = l1;
        LinkNode nodeL2 = l2;

        int len1 = getLenList(nodeL1);
        int len2 = getLenList(nodeL2);
        // 也就是说去掉多余的节点
        if(len2 > len1){
            LinkNode node2 = l2;
            l2 = l1;
            l1 = node2;

        }
        l1 = removeReduant(l1,Math.abs(len1-len2));
        while(l1 != l2 && l1!=null && l2!=null){
            l1 = l1.next;
            l2 = l2.next;
        }
        if(l1 == null){
            return null;
        }
        return l1;
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

        LinkNode l6 = new LinkNode("2");
        LinkNode l7 = new LinkNode("3");
        LinkNode l8 = new LinkNode("4");
        LinkNode l9 = new LinkNode("5");
        LinkNode l10 = new LinkNode("6");
        l6.next = l7;
        l7.next = l8;
        l8.next = l2;

        System.out.println(linkNodeCross(l1, l6).getValue());
    }

}
