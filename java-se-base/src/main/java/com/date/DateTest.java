package com.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author litong
 * @date 2018年8月24日_上午9:45:54 
 * @version 1.0 
 */
public class DateTest {
  public static void main(String[] args) {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    // 1.设置日历类
    Calendar calendar = Calendar.getInstance();
    // 2.设置时间
    Date date = new Date();
    calendar.setTime(date);
    // 3.增减时间
    calendar.add(Calendar.YEAR, -1);// 减1年
    calendar.add(Calendar.MONTH, 3);// 加3个月
    calendar.add(Calendar.DAY_OF_YEAR, 10);// 加10天
    // 4.获取操作后的日期
    date = calendar.getTime();
    String dateStr = sdf.format(date);
    System.out.println(dateStr);
  }
}
