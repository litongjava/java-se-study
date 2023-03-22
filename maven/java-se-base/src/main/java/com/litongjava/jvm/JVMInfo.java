package com.litongjava.jvm;
public class JVMInfo {
  public static void main(String[] args) {
    Runtime runtime = Runtime.getRuntime();
    long maxMemory = runtime.maxMemory();
    System.out.println(maxMemory / 1024 / 1024);
    long freeMemory = runtime.freeMemory();
    System.out.println(freeMemory / 1024 / 1024);
    long totalMemory = runtime.totalMemory();
    System.out.println(totalMemory / 1024 / 1024);
  }
}
