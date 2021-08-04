package com.litongjava.study.classloader.demo01;

import java.net.URL;
import java.net.URLClassLoader;

/**
 * HotSwapClassLoader
 */
public class HotSwapClassLoader extends URLClassLoader {

  final ClassLoader parent;

  static {
    registerAsParallelCapable();
  }

  public HotSwapClassLoader(URL[] urls, ClassLoader parent) {
    super(urls, parent);
    this.parent = parent;
  }

  protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
    synchronized (getClassLoadingLock(name)) {
      // First, check if the class has already been loaded
      Class<?> c = findLoadedClass(name);
      if (c != null) {
        return c;
      }

      return parent.loadClass(name);
    }
  }
}
