package com.yy.spring.bean;

import com.yy.spring.ioc.entity.Book;
import com.yy.spring.ioc.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description:
 * @author: yy
 * @date: 2020/7/7 11:00
 */
public class BeanCycleApplicationContextLoader {
    public static void main(String[] args) {
        System.out.println("现在开始初始化容器");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "classpath:spring-bean2.xml");
        System.out.println("容器初始化成功");
        Person person = applicationContext.getBean(Person.class);
        System.out.println(person);

        System.out.println("现在开始关闭容器");
        ((ClassPathXmlApplicationContext)applicationContext).registerShutdownHook();

    }
}
