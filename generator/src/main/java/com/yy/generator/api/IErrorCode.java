package com.yy.generator.api;

/**
 * @description: 封装API的错误码
 * @author: yy
 * @date: 2020/3/27 10:11
 */
public interface IErrorCode {

    long getCode();

    String getMessage();
}
