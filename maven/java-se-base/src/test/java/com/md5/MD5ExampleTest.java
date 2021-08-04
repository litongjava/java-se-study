package com.md5;

import org.junit.Test;

/**
 * @author litong
 * @date 2018年12月21日_下午4:30:34 
 * @version 1.0 
 */
public class MD5ExampleTest {

  @Test
  public void test() {
    byte b = 127;
    // & 与运行 0xf0
    System.out.println(b & 0xf0);
  }
}
