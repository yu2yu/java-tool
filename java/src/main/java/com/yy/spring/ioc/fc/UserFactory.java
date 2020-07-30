package com.yy.spring.ioc.fc;

import com.yy.spring.ioc.entity.User;

/**
 * @description:
 * @author: yy
 * @date: 2020/7/23 18:15
 */
public class UserFactory {

    public User getUser(String name){
        return new User();
    }
}
