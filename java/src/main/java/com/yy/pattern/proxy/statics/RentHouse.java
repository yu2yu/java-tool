package com.yy.pattern.proxy.statics;

/**
 * @description:
 * @author: yy
 * @date: 2020/7/14 15:44
 */
public class RentHouse implements IRentHouse {

    @Override
    public void rent() {
        System.out.println("租到房子了");
    }
}
