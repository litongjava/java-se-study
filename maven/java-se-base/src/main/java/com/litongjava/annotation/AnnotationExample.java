package com.litongjava.annotation;

/**
 * @author litong
 * @date 2018年7月21日_下午9:02:07
 * @version 1.0
 */
public class AnnotationExample {
  @NullValueValidate(paramName = "yes")
  private String testVar1;
  @NullValueValidate(paramName = "no")
  private String testVar2;

  public AnnotationExample() {
    testVar2 = "不是空";
    NullProcessor.processAnnotations(this);
  }

  public static void main(String[] args) {
    AnnotationExample ae = new AnnotationExample();
  }
}
