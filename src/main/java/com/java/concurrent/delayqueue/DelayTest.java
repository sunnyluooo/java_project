package com.java.concurrent.delayqueue;

import java.util.concurrent.DelayQueue;

/**
 * @author 吴邪
 * @date 2020/10/23 16:54
 */
public class DelayTest {
    static DelayQueue<DelayTask<String>> delayQueue = new DelayQueue<>();
    public static void main(String[] args) throws InterruptedException {
        DelayTask<String> task1 = new DelayTask<>("task1");
        delayQueue.put(task1.setTTL(10000));
        System.out.println("task1 进去延时队列...");
//        Thread.sleep(5000);
        System.out.println("主线程 sleep 5s完毕...");
        DelayTask<String> take = delayQueue.take();
        System.out.println(take.getData());
    }
}
