package com.yy.pattern.factory.domain.wheel;

/**
 * @description:
 * @author: yy
 * @date: 2020/7/16 17:46
 */
public class BenzWheels implements Wheels {

    @Override
    public void getName() {
        System.out.println("benz wheels……");
    }
}
