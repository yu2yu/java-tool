package com.yy.pattern.factory.abstraction;

import com.yy.pattern.factory.domain.car.Car;
import com.yy.pattern.factory.domain.wheel.Wheels;

/**
 * @description:
 * @author: yy
 * @date: 2020/7/16 17:49
 */
public interface AbstractFactory {

    Car getCar();
    Wheels getWheels();
}
