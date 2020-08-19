package com.yy.algorithm.link;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

/**
 * @description: 链表带有随机指针的深拷贝
 * @author: yy
 * @date: 2020/8/19 11:10
 */
public class LinkNodeCopy {

    static class LinkNodeDeep{
        private String value;
        LinkNodeDeep next;
        LinkNodeDeep random;

        public LinkNodeDeep(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    public static LinkNodeDeep LinkNodeDeepCopy(LinkNodeDeep head){
        // 生成一个hashMap
        Map<LinkNodeDeep,LinkNodeDeep> map = new HashMap<>();
        LinkNodeDeep node = head;
        // 遍历存储
        while(node != null){
            LinkNodeDeep newNode = new LinkNodeDeep(node.getValue());
            map.put(node,newNode);
            node = node.next;
        }
        node = head;
        // 指针连接 next和random
        while(node != null){
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
            node = node.next;
        }
        return map.get(head);
    }

    public static void main(String[] args) {
        LinkNodeDeep l1 = new LinkNodeDeep("1");
        LinkNodeDeep l2 = new LinkNodeDeep("5");
        LinkNodeDeep l3 = new LinkNodeDeep("7");
        LinkNodeDeep l4 = new LinkNodeDeep("3");
        LinkNodeDeep l5 = new LinkNodeDeep("4");
        l1.next = l2;
        l1.random = l5;
        l2.next = l3;
        l2.random = l2;
        l3.next = l4;
        l3.random = null;
        l4.next = l5;

        LinkNodeDeep result = LinkNodeDeepCopy(l1);

        l1.random = l4;
        l2.setValue("00");

        while(result !=null){
            System.out.print(result.getValue());
            if(result.next != null) {
                System.out.print(":next(");
                System.out.print(result.next.getValue()+")");
            }
            if(result.random != null) {
                System.out.print(":random(");
                System.out.print(result.random.getValue()+")");
            }
            System.out.println();
            result = result.next;
        }


        while(l1 !=null){
            System.out.print(l1.getValue());
            if(l1.next != null) {
                System.out.print(":next(");
                System.out.print(l1.next.getValue()+")");
            }
            if(l1.random != null) {
                System.out.print(":random(");
                System.out.print(l1.random.getValue()+")");
            }
            System.out.println();
            l1 = l1.next;
        }
    }

}
