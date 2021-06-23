package com.thread.juc.C_018_00_AtomicXXX;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

public class T02_AutomicVsSyncVsLongAdder {
  static long count2=0L;
  static AtomicLong count1=new AtomicLong(0L);
  static LongAdder count3=new LongAdder();
  
  public static void main(String[] args) throws InterruptedException {
    Thread[] threads=new Thread[1000];
    for(int i=0;i<threads.length;i++){
      threads[i]=new Thread(()->{
        for(int k=0;k<1000;k++) count1.incrementAndGet();
      });
    }
    long start = System.currentTimeMillis();
    for(Thread t:threads) t.start();
    for(Thread t:threads) t.join();
    long end = System.currentTimeMillis();
    System.out.println("Atomic"+count1.get()+"time"+(end-start));
  }
}
