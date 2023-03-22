package com.litongjava.reflection;

public class ReflectionStudy {
  public static void main(String[] args) {
    // 1.通过类名
    @SuppressWarnings("rawtypes")
    Class clazz = Person.class;
    System.out.println(clazz);
    // 2.通过对象名
    // 这种方式是用在传进来一个对象，却不知道对象类型的时候使用
    Person person = new Person();
    clazz = person.getClass();
    System.out.println(clazz);
    // 如果传进来是一个Object类，这种做法就是应该的
    Object obj = new Person();
    clazz = obj.getClass();
    System.out.println(clazz);
    // 3.通过全类名(会抛出异常)
    // 一般框架开发中这种用的比较多，因为配置文件中一般配的都是全类名，通过这种方式可以得到Class实例
    String className = "com.litongjava.reflection.Person";
    try {
      clazz = Class.forName(className);
      System.out.println(clazz);
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }

    // 字符串的例子
    clazz = String.class;
    System.out.println(clazz);
    clazz = "javaTest".getClass();
    System.out.println(clazz);
    try {
      clazz = Class.forName("java.lang.String");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    System.out.println(clazz);
    System.out.println();
  }
}