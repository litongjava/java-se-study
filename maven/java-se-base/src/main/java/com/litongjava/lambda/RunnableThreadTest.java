package com.litongjava.lambda;

public class RunnableThreadTest {

  public static void main(String[] args) {
//    new FirstThreadTest().start();
    SecondRunnableTest secondRunnableTest = new SecondRunnableTest();
    new Thread(secondRunnableTest, "新线程2").start();
    
    new Thread(() -> {
      for (int b = 0; b < 5; b++) {
        System.out.println(Thread.currentThread().getName() + " " + b);
      }
    }, "线程1").start();
  }


}