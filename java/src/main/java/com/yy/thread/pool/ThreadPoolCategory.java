package com.yy.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @description: 多线程分类
 * @author: yy
 * @date: 2020/8/10 9:49
 */
public class ThreadPoolCategory {

    /**
     * 第0个线程pool-1-thread-1
     * 第1个线程pool-1-thread-1
     * 第2个线程pool-1-thread-1
     * 第3个线程pool-1-thread-1
     * 第4个线程pool-1-thread-1
     * 第5个线程pool-1-thread-1
     */
    public void testNewCachedThreadPool(){
        ExecutorService cacheThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 6; i++) {
            final int index = i;
            try{
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
            cacheThreadPool.execute(() -> {
                System.out.println("第" +index +"个线程" +Thread.currentThread().getName());
            });
        }
        cacheThreadPool.shutdown();

    }

    /**
     * 第0个线程pool-1-thread-1
     * 第1个线程pool-1-thread-2
     * 第2个线程pool-1-thread-3
     * 第3个线程pool-1-thread-3
     * 第4个线程pool-1-thread-2
     * 第5个线程pool-1-thread-1
     */
    public void testFixThreadPool(){
        ExecutorService fixThreadPool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 6; i++) {
            final int index = i;
            fixThreadPool.execute(() -> {
                try{
                    System.out.println("第" +index +"个线程" +Thread.currentThread().getName());
                    Thread.sleep(1000);
                }catch (Exception e){
                    e.printStackTrace();
                }
            });
        }
        fixThreadPool.shutdown();
    }

    public void testScheduleThread(){
        ScheduledExecutorService scheduledThread = Executors.newScheduledThreadPool(3);
//        scheduledThread.schedule(() -> {
//            System.out.println("延迟三秒");
//        },3, TimeUnit.SECONDS);

        scheduledThread.scheduleAtFixedRate(() -> {
            System.out.println("延迟1秒后每三秒执行一次");
        },1,3,TimeUnit.SECONDS);

//        scheduledThread.shutdown();
    }

    public void testSinglePool(){
        ExecutorService singlePool = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 6; i++) {
            int index = i;
            singlePool.execute(() -> {
                try{
                    System.out.println("第"+index+"个线程");
                    Thread.sleep(2000);
                }catch(InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        singlePool.shutdown();
    }


    public static void main(String[]  args ) {
        // new ThreadPoolCategory().testNewCachedThreadPool();
        // new ThreadPoolCategory().testFixThreadPool();
        // new ThreadPoolCategory().testScheduleThread();
        new ThreadPoolCategory().testSinglePool();
    }

}
