package com.yy.fast.lambda;

import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.extension.api.R;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description:
 *
 *      从上面可知，没添加一种条件都需要新建一个方法
 *
 *
 * @author: yy
 * @date: 2020/11/4 16:00
 */
public class ProductService {

    private static List<Product> products = new ArrayList<Product>(){{
        add(new Product("Phone",2034.9,"elect"));
        add(new Product("bentIdea",34.9,"clothes"));
        add(new Product("wassup",30.9,"clothes"));
        add(new Product("thinking in java",4.9,"book"));
        add(new Product("围城",8.94,"book"));
    }};


    public List<Product> getAllProducts(){
        return products;
    }

    public List<Product> getProductsByCategory(String categoryName){
        return products.stream()
                .filter(k -> categoryName.equals(k.getCategory()))
                .collect(Collectors.toList());
    }

    public List<Product> getProductsByPrice(Double price){
        return products.stream()
                .filter(k -> price<k.getPrice())
                .collect(Collectors.toList());
    }

    public List<Product> getProductsByPriceAndCategoryName(Double price,String categoryName){
        return products.stream()
                .filter(k -> categoryName.equals(k.getCategory()))
                .filter(k -> price<k.getPrice())
                .collect(Collectors.toList());
    }


    public List<Product> getProductsByFilter(ProductFilter productFilter){
        return productFilter.filter(products);
    }

    public static void main(String[] args) {



//        System.out.println(JSONUtil.toJsonPrettyStr(new ProductService().getProductsByCategory("clothes")));

        System.out.println(JSONUtil.toJsonPrettyStr(
                new ProductService().getProductsByFilter(new ProductFilter() {
                    @Override
                    public List<Product> filter(List<Product> products) {
                        return products.stream()
                                .filter(k -> "book".equals(k.getCategory()))
                                .collect(Collectors.toList());
                    }
                })));


        // lambda表达式 也就是将行为当做参数传递，简化编写
        System.out.println(JSONUtil.toJsonPrettyStr(
            new ProductService().getProductsByFilter(v->{
                    return products.stream()
                            .filter(k -> "book".equals(k.getCategory()))
                            .collect(Collectors.toList());
                })
        ));
    }

}
