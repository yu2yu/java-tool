package com.yy.spring.ioc.entity;

/**
 * @description:
 * @author: yy
 * @date: 2020/7/7 10:58
 */
public class Book {

    private String bName;
    private String author;

    public Book(String bName, String author) {
        this.bName = bName;
        this.author = author;
    }

    public void testBook(){
        System.out.println(bName+":"+author);
    }

}
