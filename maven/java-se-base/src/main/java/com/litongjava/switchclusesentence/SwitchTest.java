package com.litongjava.switchclusesentence;

/**
 * @author litong
 * @date 2018年7月31日_下午7:41:00 
 * @version 1.0 
 */
public class SwitchTest {
  public static void main(String[] args) {
    String season = "summer";
    switch (season) {
    case "spring":
      System.out.println("春天");
      break;
    case "summer":
      System.out.println("夏天");
      break;
    case "autumn":
      System.out.println("秋天");
      break;
    case "winter":
      System.out.println("冬天");
      break;
    default:
      System.out.println("不知道是什么天气");
      break;
    }
  }
}
