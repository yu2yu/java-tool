package com.yy.pattern.proxy.dynamic.jdk;

import com.yy.pattern.proxy.statics.IRentHouse;
import com.yy.pattern.proxy.statics.RentHouse;

import java.lang.reflect.Proxy;

/**
 * @description:
 * @author: yy
 * @date: 2020/7/14 15:58
 */
public class JDKDynamicTest {

    public static void main(String[] args) {
        IRentHouse rentHouse = new RentHouse();
        InterMidProxy interMidProxy = new InterMidProxy(rentHouse);
        // 获取一个代理对象
        IRentHouse proxy = (IRentHouse) Proxy.newProxyInstance(rentHouse.getClass().getClassLoader(),
                rentHouse.getClass().getInterfaces(),interMidProxy);
        proxy.rent();
    }
}
