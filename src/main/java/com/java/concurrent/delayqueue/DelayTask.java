package com.java.concurrent.delayqueue;

import lombok.Data;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * 延时任务对象
 */
@Data
public class DelayTask<T> implements Delayed {

    private T data;
    private long tti; //定时过期时间

    public DelayTask(T data){
        this.data = data;
    }

    /**
     * 设置存活时间
     */
    public DelayTask<T> setTTL(long ttl){
        this.tti = System.currentTimeMillis()+ttl;
        return this;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        long diffTime = tti - System.currentTimeMillis();
        return unit.convert(diffTime,TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        return (int) (this.tti-((DelayTask) o).getTti());
    }
}
