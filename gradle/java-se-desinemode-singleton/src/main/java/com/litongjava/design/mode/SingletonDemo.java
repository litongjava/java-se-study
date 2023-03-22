package com.litongjava.design.mode;

import java.lang.reflect.Constructor;

public class SingletonDemo {
  public static void main(String[] args) throws Exception {
    System.out.println("===========================");
    Singleton s = Singleton.getInstance();
    Singleton sUsual = Singleton.getInstance();
    Constructor<Singleton> constructor = Singleton.class.getDeclaredConstructor();
    constructor.setAccessible(true);
    Singleton sReflection = constructor.newInstance();
    System.out.println(s + "\n" + sUsual + "\n" + sReflection);
    System.out.println("正常情况下，实例化两个实例是否相同：" + (s == sUsual));
    System.out.println("通过反射攻击单例模式情况下，实例化两个实例是否相同：" + (s == sReflection));
    System.out.println("===========================");
  }
}
