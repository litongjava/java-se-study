package com.litongjava.reflection;

import org.junit.Test;

/**
 * @author Ping E Lee
 *
 */
public class NewInstanceTest {

  @Test
  public void testNewInstance() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
    // 1.获取Class对象
    String className = "com.litongjava.reflection.Person";
    Class clazz = Class.forName(className);

    // 利用Class对象的newInstance方法创建一个类的实例
    Object obj = clazz.newInstance();
    System.out.println(obj);
  }

}
