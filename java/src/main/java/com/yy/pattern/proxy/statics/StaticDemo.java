package com.yy.pattern.proxy.statics;

/**
 * @description: 静态代理工厂
 * @author: yy
 * @date: 2020/7/14 15:46
 */
public class StaticDemo {

    public static void main(String[] args) {
        IRentHouse rentHouse = new RentHouse();
        new RentHouseProxy(rentHouse).rent();
    }
}
