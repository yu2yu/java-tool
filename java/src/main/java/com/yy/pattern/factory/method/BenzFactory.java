package com.yy.pattern.factory.method;

import com.yy.pattern.factory.domain.car.Benz;
import com.yy.pattern.factory.domain.car.Car;

/**
 * @description:
 * @author: yy
 * @date: 2020/7/16 13:48
 */
public class BenzFactory implements CarFactory {

    @Override
    public Car getCar() {
        return new Benz();
    }
}
