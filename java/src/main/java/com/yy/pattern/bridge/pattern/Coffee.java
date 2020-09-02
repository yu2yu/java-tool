package com.yy.pattern.bridge.pattern;

/**
 * @description: 使用桥接模式，咖啡有两个扩展模块
 *                  一：就是容量
 *                  二：就是添加剂
 *                  因此这两个独立的模块是可以自己扩展的，因此我们需要使用组合模式来更好的扩展
 * @author: yy
 * @date: 2020/9/2 10:54
 */
public abstract class Coffee {

    protected CoffeeAddictive coffeeAddictive;

    // 组合模式
    public Coffee(CoffeeAddictive coffeeAddictive) {
        this.coffeeAddictive = coffeeAddictive;
    }

    public abstract void orderCoffee(int count);
}
