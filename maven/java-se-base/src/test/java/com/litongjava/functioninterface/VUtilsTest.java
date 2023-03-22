package com.litongjava.functioninterface;

import org.junit.Test;

public class VUtilsTest {

  @Test
  public void testIsTure() {
    VUtils.isTure(false).throwMessage("抛出异常");
  }

  @Test
  public void testIsTure2() {
    VUtils.isTure(true).throwMessage("抛出异常");
  }

  @Test
  public void testIsTure3() {
    ThrowExceptionFunction ture2 = VUtils.isTure2(true);
    ture2.throwMessage("新的异常");
  }

  @Test
  public void testIsTureOrFalse() {
    VUtils.isTureOrFalse(true).trueOrFalseHandle(() -> {
      System.out.println("True时执行方法");
    }, () -> {
      System.out.println("False时执行方法");
    });
  }
  
  @Test
  public void testPresentOrElseHandler() {
    VUtils.isBlankOrNoBlank("Hello").presentOrElseHandle(System.out::println, ()->{
      System.out.println("空字符串");
    });
  }
}
