package com.yy.pattern.factory.domain.car;

/**
 * @description:
 * @author: yy
 * @date: 2020/7/16 13:39
 */
public class Benz implements Car {

    @Override
    public void getName() {
        System.out.println("Benz car ……");
    }
}
