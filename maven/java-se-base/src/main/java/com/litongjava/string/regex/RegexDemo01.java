package com.litongjava.string.regex;

/**
 * @author Ping E Lee
 *
 */
public class RegexDemo01 {
  public static void main(String[] args) {
    //demo2();
//    demo1();
    demo3();
  }

  public static void demo1() {
    String content = "免费试学7850人学过6分14秒";
    String regex = "(?:免费试学).*";
    boolean matches = content.matches(regex);
    System.out.println(matches);
  }
  public static void demo2() {
    String str = "正则匹配测试";
    // 以正开头试结尾匹配
    if (str.matches("(?:正).*") && str.matches(".*(?:试)")) {
      System.out.println(str);
    }
    // 或者
    if (str.matches("(?:正).*(?:试)")) {
      System.out.println(str);
    }
  }
  public static void demo3() {
    String content="9282人学过5分33秒";
    String regex="(?:[0-9]{4}).*";
    boolean matches = content.matches(regex);
    System.out.println(matches);
    
  }
}
