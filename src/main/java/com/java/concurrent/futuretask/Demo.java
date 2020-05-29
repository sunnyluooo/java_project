package com.java.concurrent.futuretask;

import java.util.concurrent.*;

/**
 * @author: 吴邪
 * @date: 2020/5/29 11:24
 */
public class Demo {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        Future<Integer> result = executor.submit(() -> {
            System.out.println("子线程在进行计算");
            Thread.sleep(3000);
            int sum = 0;
            for (int i = 0; i < 100; i++)
                sum += i;
            return sum;
        });

    }
}

class Task implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println("子线程在进行计算");
        Thread.sleep(3000);
        int sum = 0;
        for (int i = 0; i < 100; i++)
            sum += i;
        return sum;
    }

}
