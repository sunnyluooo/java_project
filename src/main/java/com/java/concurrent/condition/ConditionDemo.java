package com.java.concurrent.condition;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 吴邪
 * @date 2020/10/26 10:19
 */
public class ConditionDemo {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(()->{
            lock.lock();
            System.out.println(Thread.currentThread().getId()+" - 启动...");
            try {
                System.out.println(Thread.currentThread().getId()+" - 睡眠...");
                condition.await();
                System.out.println(Thread.currentThread().getId()+" - 被唤醒...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        });

        executorService.submit(()->{
            lock.lock();
            System.out.println(Thread.currentThread().getId()+" - 唤醒线程 启动...");
            try {
                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getId()+" - 唤醒线程 唤醒...");
                condition.signal();
                System.out.println(Thread.currentThread().getId()+" - 唤醒线程 唤醒完毕...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                //如果此处注释，则不会真正的唤醒
                lock.unlock();
            }
        });
    }
}
