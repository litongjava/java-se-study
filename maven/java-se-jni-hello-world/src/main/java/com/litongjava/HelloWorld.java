package com.litongjava;

public class HelloWorld {

  public native void print();

  public static void main(String[] args) {
    JavaLibraryUtil.init();
    System.loadLibrary("libhelloworld");
    new HelloWorld().print();
  }
}