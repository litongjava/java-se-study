package com.joadtime;
/**
 * @author litong
 * @date 2018年9月13日_上午10:18:52 
 * @version 1.0
 * 使用jdk提供的类,计算宝宝出生到现在经过天数,小时,秒数 
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.junit.Test;

public class Demo1 {

  @Test
  public void test2() {
    long currentTimeMillis = System.currentTimeMillis();
    System.out.println(currentTimeMillis);
    Date date = new Date();
    Calendar instance = Calendar.getInstance();
    instance.setTime(date);
    System.out.println(instance.getTimeInMillis());
  }

  @Test
  public void test1() {
    Scanner scanner = new Scanner(System.in);
    while (true) {
      System.out.println("请输入宝宝的出现时间,格式 yyyy-MM-dd HH:mm:ss");
      String birthday = scanner.nextLine();
      Date start = null;
      try {
        start = toDate(birthday, "yyyy-MM-dd HH:mm:ss");
      } catch (ParseException e) {
        e.printStackTrace();
        System.out.println("输入格式有误,请重新输入,格式 yyyy-MM-dd HH:mm:ss");
      }
      Date end = new Date();
      long millis = getMillis(start, end);
      // 天数
      long days = millis / (24 * 60 * 60 * 1000);
      // 小时
      long hours = (millis - days * 24 * 60 * 60 * 1000) / (60 * 60 * 1000);
      // 分钟
      long minutes = (millis - days * 24 * 60 * 60 * 1000 - hours * 60 * 60 * 1000) / (60 * 1000);
      System.out.println("已经经过了:" + days + "天" + hours + "时" + minutes + "分钟");
    }
  }

  /**
   * 获取两个时间之间间隔的毫秒数
   * @param start
   * @param end
   * @return
   */
  private long getMillis(Date start, Date end) {
    Calendar c1 = Calendar.getInstance();
    c1.setTime(start);
    Calendar c2 = Calendar.getInstance();
    c2.setTime(end);
    long t2 = c2.getTimeInMillis();
    long t1 = c1.getTimeInMillis();
    return t2 - t1;
  }

  /**
   * 存储 SimpleDateForamt的格式
   */
  Map<String, SimpleDateFormat> sdfMaps = new HashMap<>();

  /**
   * java.lang.String ==> java.util.Date
   * @throws ParseException 
   */
  public Date toDate(String str, String format) throws ParseException {
    SimpleDateFormat sdf = getSimpleDateFormat(format);
    Date parse = sdf.parse(str);
    return parse;
  }

  /**
   * java.util.Date==>java.lang.String
   */
  public String toString(Date date, String format) {
    SimpleDateFormat sdf = getSimpleDateFormat(format);
    String string = sdf.format(date);
    return string;
  }

  /**
   * 如果有sdf从map中取,如果没有sdf,new后,放到map中
   * @param format
   * @return
   */
  private SimpleDateFormat getSimpleDateFormat(String format) {
    SimpleDateFormat sdf = sdfMaps.get(format);
    if (sdf == null) {
      sdf = new SimpleDateFormat(format);
      sdfMaps.put(format, sdf);
    }
    return sdf;
  }

}
