package com.yy.jvm.stack;

/**
 * @description: 栈中的方法调用
 * @author: yy
 * @date: 2020/7/14 14:15
 */
public class MethodInvoke {

    class People{
        private String name;
        private String age;

        People(String age){
            this.age = age;
        }

        public void eat(){
            System.out.println("父类eat......");
        }

        public void work(){
            System.out.println("父类work......");
        }

        public void walk(){
            System.out.println("父类walk......");
        }
    }

    class Son extends People{

        int weight;

        Son(){
            super("0");
        }
        Son(int weight){
            super("0");
            super.work();
            this.weight = weight;
        }

        public void cute(){
            System.out.println("子类cute......");
        }

        @Override
        public void eat() {
            System.out.println("子类work......");
        }

        @Override
        public void walk() {
            System.out.println("子类walk......");
        }

    }

    public static void staticMethod() {
        System.out.println("static");
    }

    public void test(){

        MethodInvoke.staticMethod();
        Son son = new Son(78);
        son.walk();
        son.cute();
        son.eat();
        son.work();
    }

}
