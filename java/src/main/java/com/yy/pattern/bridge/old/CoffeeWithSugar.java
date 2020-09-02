package com.yy.pattern.bridge.old;

/**
 * @description:
 * @author: yy
 * @date: 2020/9/2 10:52
 */
public class CoffeeWithSugar implements ICoffee {

    @Override
    public void orderCoffee(int count) {
        System.out.println(String.format("加糖咖啡%d杯",count));
    }
}
