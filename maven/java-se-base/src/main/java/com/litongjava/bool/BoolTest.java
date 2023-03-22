package com.litongjava.bool;

public class BoolTest {
  public static void main(String[] args) {
    test1();
  }
  
  public static void test1() {
    String originalFilename="数据结构于算法.PDF";
    String suffix="pdf";
    if (!(originalFilename.endsWith("." + suffix) || originalFilename.endsWith("." + suffix.toUpperCase())) ) {
      System.out.println("文件格式不正确");
    }
  }
}
