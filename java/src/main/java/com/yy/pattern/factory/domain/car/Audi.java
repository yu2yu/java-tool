package com.yy.pattern.factory.domain.car;

/**
 * @description:
 * @author: yy
 * @date: 2020/7/16 13:43
 */
public class Audi implements Car {

    @Override
    public void getName() {
        System.out.println("audi car……");
    }
}
