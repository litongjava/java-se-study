package com.date;

import java.time.ZoneId;

/**
 * @author litong
 * @date 2018年9月25日_上午8:20:49
 * @version 1.0
 * 获取时区的N中方法 
 */
public class Zone {
  public static void main(String[] args) {
    test1();
  }

  /**
   * jdk 1.8 通过当前位置,所有城市,获取时区
   */
  public static void test1() {
    ZoneId systemDefault = ZoneId.systemDefault();
    System.out.println(systemDefault); //==>GMT+08:00
    ZoneId of = ZoneId.of("GMT");
    System.out.println(of);
  }

}
