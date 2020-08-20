package com.java.concurrent.jdk8Lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author 吴邪
 * @date 2020/8/18 13:48
 */
public class ReentrantLockDemo {

    protected static int value = 1;

    private static Lock lock = new ReentrantLock(true);

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
//        for(int i=0;i<2;i++){
            executorService.submit(()->{
                try {
//                    if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
//                        write();
//                    }else {
//                        System.out.println("trylock time out...");
//                    }
                    lock.lock();
                    read();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            });
//        }
        executorService.submit(()->{
            try {
//                    if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
//                        write();
//                    }else {
//                        System.out.println("trylock time out...");
//                    }
                lock.lock();
                read();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        });
    }

    protected static int read() throws InterruptedException {
        System.out.println(String.format("当前线程:{%s}，read操作",Thread.currentThread().getId()));
        System.out.println(String.format("当前线程:{%s}，readValue:{%s}",Thread.currentThread().getId(),value));
        // sleep 5s
        System.out.println("sleep 5s ing....");
        Thread.sleep(5000);
        return value;
    }

    protected static int write() throws InterruptedException {
        System.out.println(String.format("当前线程:{%s}，write操作",Thread.currentThread().getId()));
        value+=1;
        System.out.println(String.format("当前线程:{%s}，writeValue:{%s}",Thread.currentThread().getId(),value));
        // sleep 5s
        System.out.println("sleep 5s ing....");
        Thread.sleep(5000);
        return value;
    }
}
