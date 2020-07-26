package com.yy.jvm.heap;

/**
 * @description:
 * @author: yy
 * @date: 2020/7/21 17:47
 */
public class SimpleHeap {

    private int num = 5;

    public static void main(String[] args) {

        SimpleHeap heap1 = new SimpleHeap();
        SimpleHeap heap2 = new SimpleHeap();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
