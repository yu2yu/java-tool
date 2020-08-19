package com.yy.algorithm.link;

/**
 * @description: 寻找闭环的起点 快慢指针
 * @author: yy
 * @date: 2020/8/18 11:18
 */
public class LinkNodeCycle {

    public static LinkNode decticeCycle(LinkNode head){

        LinkNode slow = head;
        LinkNode quick = head;
        LinkNode meet = null;

        if(quick == null){
            return null;
        }

        while(quick != null){
            // slow走一步，quick走两步
            slow = slow.next;
            quick = quick.next.next;
            if(quick == slow){
                meet = quick;
                break;
            }
        }
        if(meet == null){
            return null;
        }
        while(head != meet){
            head = head.next;
            meet = meet.next;
        }
        return meet;
    }


    public static void main(String[] args) {
        LinkNode l1 = new LinkNode("2");
        LinkNode l2 = new LinkNode("3");
        LinkNode l3 = new LinkNode("4");
        LinkNode l4 = new LinkNode("5");
        LinkNode l5 = new LinkNode("6");
        LinkNode l6 = new LinkNode("7");
        LinkNode l7 = new LinkNode("8");
        LinkNode l8 = new LinkNode("9");
        LinkNode l9 = new LinkNode("10");
        LinkNode l10 = new LinkNode("11");

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        l7.next = l8;
        l8.next = l3;

        System.out.println(decticeCycle(l1).getValue());
    }

}
