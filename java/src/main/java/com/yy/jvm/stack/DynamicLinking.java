package com.yy.jvm.stack;

/**
 * @description:
 * @author: yy
 * @date: 2020/7/14 12:21
 */
public class DynamicLinking {

    int num = 1;

    public void methodA(){
        System.out.println("methodA");
    }
    public void methodB(){
        System.out.println("methodB");
        methodA();
        num++;
    }
}
