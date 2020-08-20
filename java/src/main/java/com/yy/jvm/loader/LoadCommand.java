package com.yy.jvm.loader;

/**
 * @description: 类初始化顺序
 *
 *          1. 父类静态成员和静态代码块
 *          2. 子类静态成员和静态代码块
 *          3， 父类普通成员和非静态代码块
 *          4. 父类构造器函数
 *          5. 子类普通成员和非静态代码块
 *          6. 子类构造器函数
 * @author: yy
 * @date: 2020/8/19 13:59
 */
public class LoadCommand {

    public static void main(String[] args) {
        Son son = new Son();
        System.out.println("----------end----------");
    }

}

class Son extends Father{

    // 常量
    private int s1 = 1;
    private static int s2 = 12;

    {
        System.out.println("1 son init block");
    }

    static{
        System.out.println("2 son static block");
    }

    Son(){
        s1 = 8;
        System.out.println("3 son constructor");
    }
}

class Father{
    int fi = 4;
    static int fsi = 5;
    static Son son = new Son();

    {
        System.out.println("4 Father init block");
    }

    static{
        System.out.println("5 Father static block");
    }

    Father(){
        fi = 8;
        System.out.println("6 Father constructor");
    }
}
