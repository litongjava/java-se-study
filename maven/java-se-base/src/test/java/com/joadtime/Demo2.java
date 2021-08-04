package com.joadtime;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Test;

/**
 * @author litong
 * @date 2018年9月13日_上午11:44:31 
 * @version 1.0 
 */
public class Demo2 {
  @Test
  public void test2() {
    Scanner scanner = new Scanner(System.in);
    DateTimeFormatter pattern = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
    while (true) {
      System.out.println("请输入宝宝的出现时间,格式 yyyy-MM-dd HH:mm:ss");
      String birthday = scanner.nextLine();
      DateTime start = null;
      start = pattern.parseDateTime(birthday);
      DateTime end = new DateTime(new Date());
      LocalDate l1 = new LocalDate(start);
      LocalDate l2 = new LocalDate(end);
      Days day = Days.daysBetween(l1, l2);
      Days days = Days.daysBetween(start, end);
      // 相差天数
      int intervalDays = days.getDays();
      // 相差小时数
      int intervalHours = start.getHourOfDay() - end.getHourOfDay();
      // 相差分钟
      int intervalMinutes = start.getMinuteOfHour() - end.getMinuteOfHour();
      // 相差秒数
      int intervalSeconds = start.getSecondOfMinute() - start.getSecondOfMinute();

      if (intervalSeconds < 0) {
        intervalMinutes = intervalMinutes - 1;
        intervalSeconds = 60 + intervalSeconds;
      }

      if (intervalMinutes < 0) {
        intervalHours = intervalHours - 1;
        intervalMinutes = 60 + intervalMinutes;
      }

      if (intervalHours < 0) {
        intervalDays = intervalDays - 1;
        intervalHours = 24 + intervalHours;
      }
      System.out.println("已经经过了:" + intervalDays + "天" + intervalHours + "时" + intervalMinutes + "分钟");
    }
  }
}