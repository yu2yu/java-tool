package com.yy.thread.common.lock;

import com.yy.thread.common.base.ThreadLocalDemo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: AQS AbstractQueuedSynchronizer，抽象队列同步器
 *      这个AQS对象就是ReentrantLock可以实现加锁和释放锁的关键性的核心组件
 *
 * @author: yy
 * @date: 2020/8/5 15:13
 */
public class LockDemo {
    Lock lock = new ReentrantLock();

    public void lock(String name){
        // 获取锁
        lock.lock();
        try {
            System.out.println(name+" get the lock");
            // 访问共享资源
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
            System.out.println(name + " release the lock");
        }

    }

    public static void main(String[] args) {
        LockDemo lockDemo = new LockDemo();
        new Thread(() -> lockDemo.lock("A")).start();
        new Thread(() -> lockDemo.lock("B")).start();
    }
}
