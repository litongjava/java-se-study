package com.litongjava.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolStudy {
  public static void main(String[] args) {
    // 创建固定数量的线程池
    int nThreads = Runtime.getRuntime().availableProcessors() * 2;
    ExecutorService executorService = Executors.newFixedThreadPool(nThreads);
    Runnable target = () -> {
      for (int i = 0; i < 100; i++) {
        System.out.println(Thread.currentThread().getName() + i);
      }
    };
    // 向线程池中添加2个线程
    executorService.submit(target);
    executorService.submit(target);
    // 关闭线程池
    executorService.shutdown();
  }
}
