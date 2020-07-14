package com.yy.pattern.proxy.statics;

/**
 * @description:
 * @author: yy
 * @date: 2020/7/14 15:44
 */
public class RentHouseProxy implements IRentHouse{

    IRentHouse rentHouse;

    RentHouseProxy(IRentHouse rentHouse){
        this.rentHouse = rentHouse;
    }

    @Override
    public void rent() {
        System.out.println("交中介费");
        rentHouse.rent();
        System.out.println("后期维护修理");
    }
}
