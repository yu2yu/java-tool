package com.yy.pattern.factory.abstraction;

import com.yy.pattern.factory.domain.car.Benz;
import com.yy.pattern.factory.domain.car.Car;
import com.yy.pattern.factory.domain.wheel.BenzWheels;
import com.yy.pattern.factory.domain.wheel.Wheels;

/**
 * @description:
 * @author: yy
 * @date: 2020/7/16 17:49
 */
public class BenzFactory implements  AbstractFactory{

    @Override
    public Car getCar() {
        return new Benz();
    }

    @Override
    public Wheels getWheels() {
        return new BenzWheels();
    }
}
