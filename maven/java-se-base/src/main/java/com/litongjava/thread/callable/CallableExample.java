package com.litongjava.thread.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableExample {
  public static void main(String[] args) {
    ExecutorService executorService = Executors.newSingleThreadExecutor();

    Callable<Integer> task = () -> {
      int result = 0;
      for (int i = 1; i <= 5; i++) {
        result += i;
      }
      return result;
    };

    Future<Integer> future = executorService.submit(task);

    try {
      Integer result = future.get();
      System.out.println("Result: " + result);
    } catch (InterruptedException | ExecutionException e) {
      e.printStackTrace();
    }

    executorService.shutdown();
  }
}
