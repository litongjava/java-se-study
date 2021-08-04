package com.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * @author litong
 * @date 2018年7月21日_下午8:16:53 
 * @version 1.0 
 */
public class NullProcessor {
  /**
   * 
   * @param obj 要处理的包含的注解对象
   */
  public static void processAnnotations(Object obj) {
    Class c1 = obj.getClass();
    // 检查所有属性
    for (Field f : c1.getDeclaredFields()) {
      // 处理一个属性上的所有注解
      for (Annotation a : f.getAnnotations()) {
        // 检查是否包含NullValueValidate
        if (a.annotationType() == NullValueValidate.class) {
          NullValueValidate nullVal = (NullValueValidate) a;
          // 访问注解methond,paramName,将获取的paramName的值
          System.out.println("Procesing the field:" + nullVal.paramName());
          // 如果这个属性是private,设置可以被访问
          f.setAccessible(true);
          // 检查如果为空,则抛出空指正异常
          try {
            if (f.get(obj) == null) {
              throw new NullPointerException("The value of the field" + f.toString() + " can't be NULL");
            } else {
              System.out.println("Value of thie Objext:" + f.get(obj));
            }
          } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
          }
        }
      }
    }
  }
}