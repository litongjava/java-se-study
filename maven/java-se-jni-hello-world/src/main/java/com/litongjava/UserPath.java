package com.litongjava;

import java.lang.reflect.Field;

/**
 * Created by litonglinux@qq.com on 10/21/2023_1:38 AM
 */
public class UserPath {
  public static void main(String[] args) throws Exception {
    Field field = java.lang.ClassLoader.class.getDeclaredField("usr_paths");
    field.setAccessible(true);
    String[] paths = (String[]) field.get(null);
    for (int i = 0; i < paths.length; i++) {
      System.out.println(paths[i]);
    }
  }
}
