package com.java.concurrent.jdk8Lock;

import java.util.concurrent.locks.StampedLock;

/**
 * @author 吴邪
 * @date 2020/8/20 15:51
 */
public class StampedLockDemo extends ReentrantLockDemo {
    private static StampedLock stampedLock = new StampedLock();

    public static void main(String[] args) {
        long write = stampedLock.writeLock();
        long read = stampedLock.tryOptimisticRead();
        try {
            read();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        stampedLock.writeLock();

    }

}
