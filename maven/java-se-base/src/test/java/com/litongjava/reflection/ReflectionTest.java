package com.litongjava.reflection;


import java.lang.reflect.Method;

import org.junit.Test;

/**
 * @author Ping E Lee
 *
 */
public class ReflectionTest {

  @Test
  public void testMethod() throws Exception {
    String classFullName = "com.litongjava.reflection.Person";
    Class<?> clazz = Class.forName(classFullName);
    // 1.获取方法
    // 1.1 获取取clazz对应类中的所有方法--方法数组（一）
    // 不能获取private方法,且获取从父类继承来的所有方法
    Method[] methods = clazz.getMethods();
    for (Method method : methods) {
      System.out.print(method.getName());
    }
    System.out.println();

    // 1.2.获取所有方法，包括私有方法 --方法数组（二）
    // 所有声明的方法，都可以获取到，且只获取当前类的方法
    methods = clazz.getDeclaredMethods();
    for (Method method : methods) {
      System.out.print(method.getName());
    }
    System.out.println();

    // 1.3.获取指定的方法
    // 需要参数名称和参数列表，无参则不需要写
    // 对于方法public void setName(String name) { }
    Method method = clazz.getDeclaredMethod("setName", String.class);
    System.out.println(method);

    // 而对于方法public void setAge(int age) { }
    // method = clazz.getDeclaredMethod("setAge", Integer.class);
    // 出现下面的异常
    // java.lang.NoSuchMethodException:
    // com.litongjava.reflection.Person.setAge(java.lang.Integer)
    // 如果方法用于反射，要么方法签名int类型写成Integer： public void setAge(Integer age) { }
    // 要么获取方法的参数写成int.class
    method = clazz.getDeclaredMethod("setAge", int.class);
    System.out.println(method);

    // 2.执行方法
    // invoke第一个参数表示执行哪个对象的方法，剩下的参数是执行方法时需要传入的参数
    Object obje = clazz.newInstance();
    method.invoke(obje, 2);
    // 如果一个方法是私有方法，第三步是可以获取到的，但是这一步却不能执行
    // 私有方法的执行，必须在调用invoke之前加上一句method.setAccessible（true）;
    int parameterCount = method.getParameterCount();
    System.out.println(parameterCount);
  }
}
