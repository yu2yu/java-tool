package com.yy.thread.common.sychronized;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: synchronized锁机制
 * @author: yy
 * @date: 2020/7/31 15:51
 */
public class SynchronizedDemo {

    private List<String> product = new ArrayList<>();
    private static int MAX_SIZE = 10;
    

    //可重入锁
    public synchronized void d(){

    }

    public synchronized void a(){
        d();
    }


    public synchronized void produce(){
        if(product.size() >= MAX_SIZE){
            try {
                wait();
                System.out.println("存仓已满");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return;
        }

        product.add("手机");
        notifyAll();
    }

    public synchronized void consume(){
        if(product.size() == 0){
            try {
                wait();
                System.out.println("无商品");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return;
        }
        product.remove(0);
        notifyAll();
    }



}
