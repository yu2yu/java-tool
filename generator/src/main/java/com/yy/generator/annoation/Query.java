package com.yy.generator.annoation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @description:
 * @author: yy
 * @date: 2020/6/4 13:27
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Query {

    String tableColumn() default "";

    Type type() default Type.EQ;

    enum Type {
        //相等 queryWrapper.eq
        EQ
        //不等
        , NE
        //小于
        , LT
        //小于等于
        , LE
        //小于
        , GT
        //小于等于
        , GE
        //中模糊查询
        , LIKE
        //左模糊查询
        , LIKELEFT
        //右模糊查询
        , LIKERIGHT
        //包含
        , IN
        // between
        , BETWEEN
        // 不为空
        , ISNOTNULL
        // 为空
        , ISNULL
    }


}
