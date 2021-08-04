package com.exception;

import java.io.File;
import java.util.Arrays;

/**
 * @author litong
 * @date 2018年9月26日_下午7:42:32 
 * @version 1.0 
 */
public class ThrowException {
  public static void main(String[] args) {
    m3();
  }

  /**
   * win平台路径
   */
  public static void m1() {
    String all = "com\\oracle\\ojdbc14\\10.2.0.4.0\\ojdbc14-10.2.0.4.0.jar";
    String[] splits = all.split(File.separator);//=> \
    System.out.println(splits);
  }

  /**
   * linux 平台路径
   */
  public static void m2() {
    String all = "com/oracle/ojdbc14/10.2.0.4.0/ojdbc14-10.2.0.4.0.jar";
    String[] splits = all.split(File.separator);
    System.out.println(Arrays.toString(splits));
  }

  /**
   * resolution
   */
  public static void m3() {
    String all = "com\\oracle\\ojdbc14\\10.2.0.4.0\\ojdbc14-10.2.0.4.0.jar";
    all=all.replace(File.separator,"/");
    String[] splits = all.split("/");
    System.out.println(Arrays.toString(splits));
  }
}
