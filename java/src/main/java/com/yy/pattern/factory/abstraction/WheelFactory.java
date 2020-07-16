package com.yy.pattern.factory.abstraction;

import com.yy.pattern.factory.domain.wheel.Wheels;

/**
 * @description:
 * @author: yy
 * @date: 2020/7/16 17:48
 */
public interface WheelFactory {

    Wheels getWheels(String wheels);
}
