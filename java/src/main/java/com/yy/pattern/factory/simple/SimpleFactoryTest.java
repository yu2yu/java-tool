package com.yy.pattern.factory.simple;

import com.yy.pattern.factory.domain.car.Car;

/**
 * @description:
 * @author: yy
 * @date: 2020/7/16 13:45
 */
public class SimpleFactoryTest {

    public static void main(String[] args) {
        SimpleFactory factory = new SimpleFactory();
        Car car = factory.getCar("Benz");
        car.getName();
    }
}
