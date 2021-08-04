package com.thread.runable;

public class TestLamba {
  public synchronized void m1() {
    System.out.println("m1");
  }

  public static void main(String[] args) {
    TestLamba l = new TestLamba();
    // new Runnable(()->l.m1());
    //Thread thread = new Thread(l::m1,"51").start();
  }
}
