package com.yy.pattern.bridge.old;

/**
 * @description: 原味咖啡
 * @author: yy
 * @date: 2020/9/2 10:51
 */
public class CoffeeOriginal implements ICoffee {

    @Override
    public void orderCoffee(int count) {
        System.out.println(String.format("原味咖啡%d杯",count));
    }
}
