package com.yy.spring.annotation;

/**
 * @description:
 * @author: yy
 * @date: 2020/7/22 14:15
 */
@MyAnnoation(getValue = "dhaudhauw")
public class AnnationTest {

    @MyAnnoation(getValue = "filed")
    private String name;

    @MyAnnoation(getValue = "method")
    public void hello(){}
}
