package com.yy.thread.common.lock;

import com.yy.thread.common.base.ThreadLocalDemo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description:
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
