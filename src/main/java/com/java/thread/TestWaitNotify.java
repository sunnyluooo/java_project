package com.java.thread;

/**
 * @author 吴邪
 * @date 2020/10/12 20:33
 */
public class TestWaitNotify {

    static class ThreadA extends Thread{

        private Object lock;

        public ThreadA(Object lock){
            this.lock = lock;
        }

        @Override
        public void run() {
            synchronized (lock){
                try {
                    System.out.println("wait之前的代码");
                    lock.wait();
                    System.out.println("wait之后的代码");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class ThreadB extends Thread{
        private Object lock;

        public ThreadB(Object lock){
            this.lock = lock;
        }

        @Override
        public void run() {
            synchronized (lock){
                System.out.println("notify之前的代码");
                lock.notify();
                System.out.println("notify之后的代码");
            }
        }
    }

    public static void main(String[] args) {
        Object lock = new Object();
        ThreadA threadA = new ThreadA(lock);
        ThreadB threadB = new ThreadB(lock);
        threadA.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadB.start();
    }
}
