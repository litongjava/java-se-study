package com.annotation.通过反射获取注解中的值;

/**
 * @author litong
 * @date 2018年7月24日_下午9:03:19 
 * @version 1.0 
 */
public class AnnoClient {
  public static void main(String[] args) {
    Fruit fruit = new Fruit();
    // 获取class对象
    Class<? extends Fruit> clazz = fruit.getClass();

    if (clazz.isAnnotationPresent(IName.class)) {
      // 如果clazz中包含IName注解,获取INanme注解
      IName annotation = clazz.getAnnotation(IName.class);
      // 调用value方法,获取方法的值
      String value = annotation.value();
      System.out.println(value);
    }
  }
}
