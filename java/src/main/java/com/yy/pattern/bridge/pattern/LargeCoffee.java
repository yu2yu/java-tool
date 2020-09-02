package com.yy.pattern.bridge.pattern;

/**
 * @description:
 * @author: yy
 * @date: 2020/9/2 10:59
 */
public class LargeCoffee extends Coffee{

    public LargeCoffee(CoffeeAddictive coffeeAddictive) {
        super(coffeeAddictive);
    }

    @Override
    public void orderCoffee(int count) {
        System.out.println(String.format("大杯咖啡%d杯",count));
        coffeeAddictive.addSomething();
    }
}
