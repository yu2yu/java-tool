package com.yy.spring.ioc.load;

import com.yy.spring.ioc.entity.Book;
import com.yy.spring.ioc.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description:
 * @author: yy
 * @date: 2020/7/7 11:00
 */
public class ApplicationContextLoader {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "classpath:spring-bean.xml");
        Book book = applicationContext.getBean("book", Book.class);
        book.testBook();

        User user = applicationContext.getBean("user", User.class);
        user.testUser();
    }
}
