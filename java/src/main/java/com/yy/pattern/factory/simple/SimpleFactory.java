package com.yy.pattern.factory.simple;

import com.yy.pattern.factory.domain.car.Audi;
import com.yy.pattern.factory.domain.car.Benz;
import com.yy.pattern.factory.domain.car.Bmw;
import com.yy.pattern.factory.domain.car.Car;

/**
 * @description:
 * @author: yy
 * @date: 2020/7/16 13:41
 */
public class SimpleFactory {

    public Car getCar(String name){
        if("Benz".equals(name)){
            return new Benz();
        } else if("BMW".equals(name)){
            return new Bmw();
        } else if("audi".equals(name)){
            return new Audi();
        }else{
            System.out.println("你要的车工厂没造……");
            return null;
        }
    }

}
