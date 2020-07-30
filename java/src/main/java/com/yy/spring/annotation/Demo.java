package com.yy.spring.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @description:
 * @author: yy
 * @date: 2020/7/22 14:20
 */
public class Demo {

    public static void main(String[] args) throws NoSuchMethodException, NoSuchFieldException {
        Class<AnnationTest> annationTestClass = AnnationTest.class;
        MyAnnoation annotation = annationTestClass.getAnnotation(MyAnnoation.class);
        System.out.println(annotation.getValue());

        Method hello = annationTestClass.getMethod("hello");
        System.out.println(hello.getAnnotation(MyAnnoation.class).getValue());

        Field name = annationTestClass.getDeclaredField("name");
        System.out.println(name.getAnnotation(MyAnnoation.class).getValue());
    }
}
