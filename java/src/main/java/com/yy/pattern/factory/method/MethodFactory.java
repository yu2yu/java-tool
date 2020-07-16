package com.yy.pattern.factory.method;

import com.yy.pattern.factory.domain.car.Car;

/**
 * @description:
 * @author: yy
 * @date: 2020/7/16 13:50
 */
public class MethodFactory {

    public static void main(String[] args) {
        CarFactory carFactory = new BenzFactory();
        Car car = carFactory.getCar();
        car.getName();
    }
}
