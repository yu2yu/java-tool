package com.yy.fast.lambda;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @description: 但是
 * @author: yy
 * @date: 2020/11/4 16:19
 */
public class ProductPriceFilter implements ProductFilter {

    @Override
    public List<Product> filter(List<Product> products) {
        return products.stream()
                .filter(k -> 20<k.getPrice())
                .collect(Collectors.toList());
    }
}
