package com.litongjava.bigdecimal;

import java.math.BigDecimal;

/**
 * @author litongjava <litongjava@qq.com>
 *
 */
public class BitDecimalDemo01 {
  public static void main(String[] args) {
//    demo01();
    demo02();
  }

  private static void demo02() {
    String pi="3.1415926";
    BigDecimal bigDecimal = new BigDecimal(pi);
    System.out.println(bigDecimal);
  }

  private static void demo01() {
    BigDecimal bigDecimal = new BigDecimal(0);
    for (int i=0;i<10;i++) {
      bigDecimal=bigDecimal.add(new BigDecimal(i));
      
    }
    System.out.println(bigDecimal);
  }
}
