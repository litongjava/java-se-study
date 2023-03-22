package com.litongjava.annotation;
/**
 * @author litong
 * @date 2018年7月24日_下午8:20:18 
 * @version 1.0 
 */
public class Example {
  @NullValueValidate(paramName = "1234")
  private String name;
  
  public static void main(String[] args) {
    Example e=new Example();
    System.out.println(e.name);
  }
}
