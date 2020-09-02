package com.yy.pattern.bridge.pattern;

/**
 * @description:
 * @author: yy
 * @date: 2020/9/2 10:58
 */
public class CoffeeeMilk implements CoffeeAddictive {

    @Override
    public void addSomething() {
        System.out.println("加糖");
    }
}
