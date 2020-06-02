package com.java.concurrent.futuretask;

import java.util.concurrent.Callable;

/**
 * @author: 吴邪
 * @date: 2020/6/2 15:05
 */
public class Task implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("子线程在进行计算");
        Thread.sleep(3000);
        System.out.println("子线程等待3s完毕");
        int i;
        i = 0;
        while (i < 100) {
            i++;
        }
        return i;
    }

}
