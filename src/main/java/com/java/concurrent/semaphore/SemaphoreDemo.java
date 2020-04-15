package com.java.concurrent.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class SemaphoreDemo   {
    private final Semaphore semaphore;
    private boolean[] resourceArray;
    private final ReentrantLock lock;
    private final int size = 1;

    public SemaphoreDemo() {
        semaphore = new Semaphore(size,true);
        resourceArray = new boolean[size];
        lock = new ReentrantLock(true);
    }

    public void use(){
        try {
            semaphore.acquire();
            int index = get();
            if(index!=-1){
                System.out.println("index : "+index+",in...");
                Thread.sleep(1000);
                resourceArray[index]=false;
                System.out.println("index : "+index+",out.");
            }else{
                System.out.println("index : "+index);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
    }

    public int get(){
        int index = -1;
        lock.lock();
        try{
            for(int i=0;i<size;i++){
                if(!resourceArray[i]){
                    resourceArray[i] = true;
                    index = i;
                    break;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        return index;
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        SemaphoreDemo semaphoreDemo = new SemaphoreDemo();
        for(int i=0;i<3;i++){
            executorService.submit(()->{
                semaphoreDemo.use();
            });
        }
    }
}
