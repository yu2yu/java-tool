package com.yy.jvm.loader;

import sun.security.ec.SunEC;

import javax.swing.*;

/**
 * @description:
 * @author: yy
 * @date: 2020/7/10 9:25
 */
public class ClassLoaderDemo {

    public static void main(String[] args) {

        // sun.misc.Launcher$AppClassLoader@18b4aac2
        ClassLoader loader = ClassLoaderDemo.class.getClassLoader();
        while (loader != null) {
            System.out.println(loader.toString());
            loader = loader.getParent();
        }
        // sun.misc.Launcher$ExtClassLoader@723279cf
        ClassLoader loader1 = SunEC.class.getClassLoader();
        System.out.println(loader1);
        // null
        ClassLoader loader2 = String.class.getClassLoader();
        System.out.println(loader2);
    }
}
