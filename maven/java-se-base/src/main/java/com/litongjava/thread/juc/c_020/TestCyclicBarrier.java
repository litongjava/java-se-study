package com.litongjava.thread.juc.c_020;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class TestCyclicBarrier {
  public static void main(String[] args) {
    CyclicBarrier barrier = new CyclicBarrier(20,()->System.out.println("output"));
//    for(int i=0;i<100;i++){
//      new Thread(()->{
//        try {
//          barrier.await();
//        } catch (Exception e) {
//          e.printStackTrace();
//        }
//      }).start();
//    }
    for(int i=0;i<100;i++){
      try {
        barrier.await();
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      } catch (BrokenBarrierException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }
}
