package com.lambda;
public class FirstThreadTest extends Thread {
  int i = 0;
  // 重写run方法，run方法的方法体就是现场执行体
  public void run() {
    for (; i < 5; i++) {
      System.out.println(getName() + "  " + i);
    }
  }
}