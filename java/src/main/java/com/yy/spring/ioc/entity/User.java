package com.yy.spring.ioc.entity;

/**
 * @description:
 * @author: yy
 * @date: 2020/7/7 10:58
 */
public class User {

    private String name;
    private String age;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void testUser(){
        System.out.println(name+":"+age);
    }
}
