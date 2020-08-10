package com.yy.thread.common.lock;

import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @description: AQS
 * @author: yy
 * @date: 2020/8/5 15:41
 */
public class ReadWriteLockDemo {

    private int data;

    ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void read(){
        readWriteLock.readLock().lock();
        try{
            System.out.println(Thread.currentThread().getName() + " be ready to read data!");
            Thread.sleep((long) (5000));
            System.out.println(Thread.currentThread().getName() + " read data: "+ data);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    public void put(int data){
        readWriteLock.writeLock().lock();
        try{
            System.out.println(Thread.currentThread().getName() + " be ready to write data!");
            Thread.sleep((long) (Math.random() * 1000));
            this.data = data;
            System.out.println(Thread.currentThread().getName() + " write data: "+ data);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public static void main(String[] args) {
        ReadWriteLockDemo readWriteLockDemo = new ReadWriteLockDemo();
        for (int i = 0; i < 3; i++) {
            new Thread(){
                @Override
                public void run(){
                    while (true){
                        readWriteLockDemo.read();
                    }
                }}.start();

            new Thread(){
                @Override
                public void run(){
                    while (true){
                        readWriteLockDemo.put(new Random().nextInt(10000));
                    }
                }}.start();
        }
    }
}
