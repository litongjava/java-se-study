package com.joadtime;

import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;

/**
 * @author litong
 * @date 2018年9月13日_下午2:01:57 
 * @version 1.0 
 */
public class JoadDays {
  public static void main(String[] args) {
    DateTime d1 = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss").parseDateTime("2018-09-12 14:00:00");
    DateTime d2 = new DateTime(new Date());
    LocalDate l1 = new LocalDate(d1);
    LocalDate l2 = new LocalDate(d2);
    Days daysBetween = Days.daysBetween(l1, l2);
    System.out.println("相差天数:"+daysBetween.getDays());
    //今天已经经过的小时数
    int hourOfDay = d1.getHourOfDay();
    System.out.println("d1 hourOfDay:"+hourOfDay);
    int d2hourOfDay = d2.getHourOfDay();
    System.out.println("d2 hourOfDay"+d2hourOfDay);
  }
}
