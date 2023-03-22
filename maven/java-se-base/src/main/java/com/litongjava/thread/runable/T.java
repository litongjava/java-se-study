package com.litongjava.thread.runable;

import java.util.concurrent.TimeUnit;

public class T {
  final Object o=new Object();
  void m(){
    synchronized(o){
      while(true){
        try{
          TimeUnit.SECONDS.sleep(1);
        }catch(InterruptedException e){
          e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
      }
    }
  }
  public static void main(String[] args) {
    T t = new T();
    //public Thread(Runnable target, String name)
    new Thread(t::m,"t1").start();
    //public Thread(Runnable target, String name) 
    new Thread(()->t.m(),"t2");
  }
}
