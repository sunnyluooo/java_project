package com.java.thread;

/**
 * @author 吴邪
 * @date 2020/10/12 17:02
 */
public class TestThread {
    static class MyThread extends Thread{

        private String name;
        public MyThread(String name){
            this.name = name;
        }

        @Override
        public void run() {
            for(int i=0;i<50;i++){
                if(i == 30){
                    //让出资源，共同竞争
                    Thread.yield();
                }else{
                    System.out.println("当前"+name+"："+i);
                }
            }
        }
    }

    public static void main(String[] args) {
        MyThread myThread1 = new MyThread("myThread1");
        MyThread myThread2 = new MyThread("myThread2");
        myThread1.start();
        myThread2.start();
    }
}
