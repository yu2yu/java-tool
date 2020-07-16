package com.yy.pattern.factory.abstraction;

/**
 * @description:
 * @author: yy
 * @date: 2020/7/16 17:52
 */
public class AbstractFactoryTest {

    public static void main(String[] args) {
        AbstractFactory abstractFactory = new BenzFactory();
        abstractFactory.getCar().getName();
        abstractFactory.getWheels().getName();
    }
}
