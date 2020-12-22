package com.java.concurrent.volatiled;

/**
 * @author trayvonn
 * @since 2020/12/22 17:44
 */
public class Test {

//    private static int count = 0;

    private static volatile boolean flag = false;

    public static void print(){
        while (!flag){
        }
        System.out.println("ok");
    }

    public static void main(String[] args) {

        Thread thread1 = new Thread(Test::print);
        Thread thread2 = new Thread(()->{
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            flag = true;
            System.out.println("修改完成");
        } );

        System.out.println("线程开始");
        thread1.start();
        thread2.start();

    }

}
