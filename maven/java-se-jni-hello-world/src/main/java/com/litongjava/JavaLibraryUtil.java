package com.litongjava;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;

public class JavaLibraryUtil {
  public static void init() {
    initLibary();
  }

  private static void initLibary() {
    File file = new File("lib");
    String absolutePath = file.getAbsolutePath();
    if (!file.exists()) {
      file.mkdirs();
      System.out.println("mkdirs:" + absolutePath);
    }
    addLibDir(absolutePath);
  }

  public static void addLibDir(String s) {
    try {
      Field field = java.lang.ClassLoader.class.getDeclaredField("usr_paths");
      field.setAccessible(true);
      String[] paths = (String[]) field.get(null);
      for (int i = 0; i < paths.length; i++) {
        if (s.equals(paths[i])) {
          return;
        }
      }
      String[] tmp = new String[paths.length + 1];
      System.arraycopy(paths, 0, tmp, 0, paths.length);
      tmp[paths.length] = s;
      field.set(null, tmp);
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (NoSuchFieldException e) {
      e.printStackTrace();
    }
  }
}
