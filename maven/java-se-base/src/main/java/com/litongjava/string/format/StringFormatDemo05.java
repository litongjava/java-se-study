package com.litongjava.string.format;

import java.util.Date;
import java.util.Locale;

public class StringFormatDemo05 {
  public static void main(String[] args) {
    Date date = new Date();
    // H的使用
    System.out.printf("2位数字24时制的小时（不足2位前面补0）:%tH%n", date);
    // I的使用
    System.out.printf("2位数字12时制的小时（不足2位前面补0）:%tI%n", date);
    // k的使用
    System.out.printf("2位数字24时制的小时（前面不补0）:%tk%n", date);
    // l的使用
    System.out.printf("2位数字12时制的小时（前面不补0）:%tl%n", date);
    // M的使用
    System.out.printf("2位数字的分钟（不足2位前面补0）:%tM%n", date);
    // S的使用
    System.out.printf("2位数字的秒（不足2位前面补0）:%tS%n", date);
    // L的使用
    System.out.printf("3位数字的毫秒（不足3位前面补0）:%tL%n", date);
    // N的使用
    System.out.printf("9位数字的毫秒数（不足9位前面补0）:%tN%n", date);
    // p的使用
    String str = String.format(Locale.US, "小写字母的上午或下午标记(英)：%tp", date);
    System.out.println(str);
    System.out.printf("小写字母的上午或下午标记（中）：%tp%n", date);
    // z的使用
    System.out.printf("相对于GMT的RFC822时区的偏移量:%tz%n", date);
    // Z的使用
    System.out.printf("时区缩写字符串:%tZ%n", date);
    // s的使用
    System.out.printf("1970-1-1 00:00:00 到现在所经过的秒数：%ts%n", date);
    // Q的使用
    System.out.printf("1970-1-1 00:00:00 到现在所经过的毫秒数：%tQ%n", date);
  }
}
