package com.yy.fast.lambda;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @description: 商品类
 * @author: yy
 * @date: 2020/11/4 15:58
 */

@Data
@AllArgsConstructor
public class Product {

    private String name;
    private Double price;
    private String category;

}
