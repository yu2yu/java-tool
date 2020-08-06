package com.yy.spring.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @description: spring Bean的生命周期
 * @author: yy
 * @date: 2020/8/6 16:03
 */
public class Person implements BeanFactoryAware, BeanNameAware,InitializingBean, DisposableBean {

    private String name;
    private String adress;
    private String phone;

    private BeanFactory beanFactory;

    private String beanName;

    Person(){
        System.out.println("【构造器】 调用person的构造实例化");
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("【属性注入】 注入属性name");
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
        System.out.println("【属性注入】 注入属性adress");
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
        System.out.println("【属性注入】 注入属性phone");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", adress='" + adress + '\'' +
                ", phone=" + phone +
                '}';
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("【BeanFactoryAware接口】调用BeanFactoryAware.setBeanFactory()");
        this.beanFactory = beanFactory;
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("【BeanNameAware接口】调用BeanNameAware.setBeanName()");
        this.beanName = s;
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("【DiposibleBean接口】调用DiposibleBean.destory()");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("【InitializingBean接口】调用InitializingBean.afterPropertiesSet()");
    }

    public void myInit(){
        System.out.println("【init-method】调用<bean>的init-method属性指定的初始化方法");
    }

    public void myDestory(){
        System.out.println("【destroy-method】调用<bean>的destroy-method属性指定的初始化方法");
    }
}
