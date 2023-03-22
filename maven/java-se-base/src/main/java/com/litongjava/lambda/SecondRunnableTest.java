package com.litongjava.lambda;

/**
 * @author create by ping-e-lee on 2021年7月11日 上午4:33:05 
 * @version 1.0 
 * @desc
 */
public class SecondRunnableTest implements Runnable {

  @Override
  public void run() {
    for (int i = 0; i < 5; i++) {
      System.out.println(Thread.currentThread().getName() + " " + i);
    }
  }
}
