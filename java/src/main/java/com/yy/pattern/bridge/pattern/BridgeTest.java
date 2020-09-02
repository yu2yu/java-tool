package com.yy.pattern.bridge.pattern;

/**
 * @description:
 * @author: yy
 * @date: 2020/9/2 11:01
 */
public class BridgeTest {

    public static void main(String[] args) {
        CoffeeeMilk milk = new CoffeeeMilk();
        LargeCoffee coffee = new LargeCoffee(milk);
        coffee.orderCoffee(1);
    }
}
