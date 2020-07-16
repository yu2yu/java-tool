package com.yy.pattern.factory.domain.wheel;

/**
 * @description:
 * @author: yy
 * @date: 2020/7/16 17:47
 */
public class AudiWheels implements Wheels {

    @Override
    public void getName() {
        System.out.println("audi wheels……");
    }
}
