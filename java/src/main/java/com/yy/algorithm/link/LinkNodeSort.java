package com.yy.algorithm.link;



/**
 * @description: 将链表中的根据num进行排序但是链表的原先顺序不变
 * @author: yy
 * @date: 2020/8/19 10:17
 */
public class LinkNodeSort {

    public static LinkNode sortedLinked(LinkNode head, int num){

        //利用两个临时节点
        LinkNode min = new LinkNode(null);
        LinkNode max = new LinkNode(null);
        LinkNode max_head = max;
        LinkNode min_head = min;

        while(head!=null){
            if(Integer.parseInt(head.getValue()) < num){
                min.next = head;
                min = head;
            }else{
                max.next = head;
                max = head;
            }
            head = head.next;
        }

        //min的头结点接入
        min.next = max_head.next;
        return min_head.next;
    }

    public static void main(String[] args) {
        LinkNode l1 = new LinkNode("1");
        LinkNode l2 = new LinkNode("5");
        LinkNode l3 = new LinkNode("7");
        LinkNode l4 = new LinkNode("3");
        LinkNode l5 = new LinkNode("4");
        LinkNode l6 = new LinkNode("2");
        LinkNode l7 = new LinkNode("6");
        LinkNode l8 = new LinkNode("9");
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        l7.next = l8;

        LinkNode result = sortedLinked(l1,6);

        while(result !=null){
            System.out.print(result.getValue() + "->");
            result = result.next;
        }
    }
}
