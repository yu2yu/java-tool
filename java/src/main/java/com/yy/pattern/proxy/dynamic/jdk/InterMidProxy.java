package com.yy.pattern.proxy.dynamic.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @description: 动态代理
 * @author: yy
 * @date: 2020/7/14 15:55
 */
public class InterMidProxy implements InvocationHandler {

    Object object;

    InterMidProxy(Object o){
        this.object = o;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = method.invoke(this.object,args);
        return result;
    }
}
