package com.yy.thread.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @description: future接口
 * @author: yy
 * @date: 2020/7/27 15:44
 */
public class FutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        long startTime = System.currentTimeMillis();

        FutureTask<Integer> task1 = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Thread.sleep(3000);
                return 5;
            }
        });
        new Thread(task1).start();

        FutureTask<Integer> task2 = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Thread.sleep(1000);
                return 3;
            }
        });
        new Thread(task2).start();

        Integer result1 = task1.get();
        Integer result2 = task2.get();

        System.out.println(result1+result2);
        System.out.println("用时："+(System.currentTimeMillis()-startTime));


        Callable<Long> callable = new Callable<Long>() {
            @Override
            public Long call() throws Exception {

                long start = System.currentTimeMillis();
                Thread.sleep(100);
                long end = System.currentTimeMillis();

                long seed = end - start;
                System.out.println("seed=" + seed);

                return seed;
            }
        };

    }
}
