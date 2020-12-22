package com.java.concurrent.volatiled;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author trayvonn
 * @since 2020/12/22 18:31
 */
public class CASTest {
    private static AtomicInteger atomicInteger = new AtomicInteger(0);
    private static int count = 0;

    public static void main(String[] args) {
        for (int i =0; i<1000;i++){
            Thread thread = new Thread(()->{
//                System.out.println(atomicInteger.incrementAndGet());
                System.out.println(count++);
            });
            thread.start();
        }

    }
}
