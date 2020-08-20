package com.java.concurrent.jdk8Lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author 吴邪
 * @date 2020/8/18 17:01
 */
public class ReentrantReadWriteLockDemo extends ReentrantLockDemo {

    private static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock(true);

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(()->{
            try {
                readWriteLock.writeLock().lock();
                readWriteLock.readLock().lock();
                read();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                readWriteLock.readLock().unlock();
            }
        });

//
//        executorService.submit(()->{
//            try {
//                readWriteLock.writeLock().lock();
//                write();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } finally {
//                readWriteLock.writeLock().unlock();
//            }
//        });

    }
}
