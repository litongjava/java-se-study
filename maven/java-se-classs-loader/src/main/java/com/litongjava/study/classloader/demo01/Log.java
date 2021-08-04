package com.litongjava.study.classloader.demo01;

public class Log {
  public static void main(String[] args) {
    ClassLoader classLoader = Log.class.getClassLoader();
    System.out.println(classLoader);
    System.out.println("load Log class successfully");

  }
}