package com.yy.fast.lambda;

import java.util.List;

/**
 * @description:
 * @author: yy
 * @date: 2020/11/4 16:17
 */
public interface ProductFilter {

    List<Product> filter(List<Product> products);
}
