package com.yy.jvm.heap;

import java.util.ArrayList;

/**
 * @description:
 * @author: yy
 * @date: 2020/7/22 15:08
 */
public class HeapCategory {

    public static void main(String[] args) throws InterruptedException {
        ArrayList<HeapCategory> heapCategories = new ArrayList<>();
        while(true){
            HeapCategory heapCategory = new HeapCategory();
            heapCategories.add(heapCategory);
            Thread.sleep(10000);
        }
    }
}
