package com.yy.pattern.bridge.pattern;

/**
 * @description:
 * @author: yy
 * @date: 2020/9/2 10:57
 */
public class CoffeeSugar implements CoffeeAddictive {

    @Override
    public void addSomething() {
        System.out.println("加糖");
    }
}
