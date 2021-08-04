package com.thread.threadlocal;

import java.util.Random;

public class ThreadLocalStudy {
  public static void main(String[] args) throws InterruptedException {
    final Person p = new Person();
    final ThreadLocal<Person> t = new ThreadLocal<Person>() {
      public Person initialValue() {
        return p;
      }
    };

    p.setName("小明");
    for (int i = 0; i < 3; i++) {
      new Thread(new Runnable() {
        @Override
        public void run() {
          t.set(p);
          t.get().setName(new Random().nextInt(100) + "");
          System.out.println(t.get().getName() + "==" + t.get());
        }
      }).start();
    }
    Thread.sleep(1000);
    System.out.println(p.getName());
  }
}
