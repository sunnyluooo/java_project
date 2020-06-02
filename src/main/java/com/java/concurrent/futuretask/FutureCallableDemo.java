package com.java.concurrent.futuretask;

import sun.java2d.pipe.SpanIterator;

import java.util.concurrent.*;

/**
 * @author: 吴邪
 * @date: 2020/5/29 11:24
 */
public class FutureCallableDemo {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        Future<Integer> result = executor.submit(new Task());
        executor.shutdown();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程在执行任务");
        try {
            System.out.println("task运行结果："+result.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("所有任务执行完毕");
    }
}


