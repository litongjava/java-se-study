package com.joadtime;

import static org.junit.Assert.fail;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.joda.time.DateTime;
import org.joda.time.DateTime.Property;
import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Test;

/**
 * @author litong
 * @date 2018年9月3日_上午9:29:43 
 * @version 1.0 
 */
public class JoadTimeTest {

  @Test
  public void test() {
    fail("Not yet implemented");
  }

  /**
   * 使用jdk设置日期
   */
  @Test
  public void test1() {
    Calendar instance = Calendar.getInstance();
    // 设置日期 2018-09-03 10:15:00
    instance.set(2018, Calendar.SEPTEMBER, 3, 10, 15, 00);
    Date time = instance.getTime();
    System.out.println(time);
  }

  /**
   * 使用joda-time设置时间
   */
  @Test
  public void test2() {
    // 设置日期 2018-09-03 10:15:00
    DateTime dateTime = new DateTime(2018, 9, 03, 10, 15, 00);
    System.out.println(dateTime);
  }

  /**
   * jdk 得到90天后日期
   */
  @Test
  public void get90Ago() {
    Calendar instance = Calendar.getInstance();
    instance.add(Calendar.DAY_OF_MONTH, 90);
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String format = sdf.format(instance.getTime());
    System.out.println(format);
  }

  /**
   * joda 得到90天后的日期
   */
  @Test
  public void joda2() {
    DateTime dateTime = new DateTime();
    // 返回值是修改后的时间,之前的没有返回
    DateTime plusDays = dateTime.plusDays(90);
    String string = plusDays.toString("yyyy-MM-dd HH:mm:ss");
    System.out.println(string);
    // jdk和joad的互操作性
    Date date = plusDays.toDate();
    Calendar instance = Calendar.getInstance();
    instance.setTime(date);

  }

  /**
   * 解析时间
   */
  @Test
  public void joad4() {
    // 定义pattern
    DateTimeFormatter pattern = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
    // 解析时间
    DateTime datetime = DateTime.parse("2018-9-12 8:22:22", pattern);
    // 格式化输入时间
    String string = datetime.toString("yyyy/MM/dd HH:mm:ss EE");
    System.out.println(string); // =>2018/09/12 08:22:22 星期三
  }

  /**
   * 解析时间
   */
  public void joad4_1() {
    DateTime datetime = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss").parseDateTime("2018-10-10 10:10:10");
  }

  /**
   * 格式化输出时间
   */
  @Test
  public void joad5() {
    DateTimeFormatter pattern = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
    DateTime time = DateTime.parse("2018-09-12 10:00:00", pattern);
    String chineseTime = time.toString("yyyy-MM-dd HH:mm:ss EE", Locale.CHINESE);// ==>018-09-12 10:00:00 星期三
    String chinaTime = time.toString("yyyy-MM-dd HH:mm:ss EE,", Locale.CHINA); // ==>2018-09-12 10:00:00 星期三,
    System.out.println(chinaTime);
  }

  /**
   * 计算两个日期间隔天数
   */
  @Test
  public void joad6() {
    LocalDate start = new LocalDate(2018, 12, 10);
    LocalDate end = new LocalDate(2018, 12, 12);
    Days daysBetween = Days.daysBetween(start, end);
    System.out.println(daysBetween); // ==>P2D
    int days = daysBetween.getDays();
    System.out.println(days);// ==>2
  }

  /**
   * 增加日期
   */
  @Test
  public void joad7() {
    DateTime dateTime = DateTime.parse("2018-10-10");
    DateTime addTime = dateTime.plusYears(1) // 增加年
        .plusMonths(1) // 增加月
        .plusDays(1) // 增加日
        .plusHours(1) // 增加小时
        .plusMinutes(1) // 增加分钟
        .plusSeconds(1); // 增加秒
  }

  /**
   * 减少日期
   */
  @Test
  public void joad8() {
    DateTime dt1 = DateTime.parse("2018-10-10");
    DateTime minusSeconds = dt1.minusYears(1) // 减少年
        .minusMonths(1) // 减少月
        .minusDays(1) // 减少天
        .minusHours(1) // 减少小时
        .minusMinutes(1) // 减少分钟
        .minusSeconds(1); // 减少秒
  }
  
  /**
   * 判断是否是闰月
   */
  @Test
  public void joad9() {
    DateTime dt1 = new DateTime();
    Property month = dt1.monthOfYear(); // 取出月份属性
    System.out.println("是否是闰月:"+month.isLeap());
  }
  
  /**
   * 取得3秒钟前的时间
   */
  @Test
  public void joad10() {
    DateTime dt1 = new DateTime();
    //方式1,使用DateTime的minusSeconds方法
    DateTime dt2 = dt1.minusSeconds(3);
    System.out.println(dt2.toString("yyyy-MM-dd HH:mm:ss"));
    //方式2,使用Property的addToCopy方法
    DateTime dt3 = dt1.secondOfMinute().addToCopy(-3);
    System.out.println(dt3.toString("yyyy-MM-dd HH:mm:ss"));
  }
  /**
   * 获取剩余时间
   */
  @Test
  public void joad11() {
    DateTime dt1 = new DateTime();
    int minute = dt1.getSecondOfMinute();//得到整分钟后,过得秒数
    int secondOfDay = dt1.getSecondOfDay(); //得到整天后,过得秒数
    System.out.println(minute);
    System.out.println(secondOfDay);
  }
  
  /**
   * DateTime构造参数
   */
  @Test
  public void joad12() {
    DateTime dt1 = new DateTime(new Date());
    System.out.println(dt1.toString("yyyy-MM-dd HH:mm:ss"));
    System.out.println(dt1.getMillis());
    DateTime dt2 = new DateTime(System.currentTimeMillis());
    System.out.println(dt2.toString("yyyy-MM-dd HH:mm:ss"));
    System.out.println(dt2.getMillis());
    DateTime dt3 = new DateTime(Calendar.getInstance());
    System.out.println(dt3.toString("yyyy-MM-dd HH:mm:ss"));
    System.out.println(dt3.getMillis());
  }

  @Test
  public void joda3() {
    // 初始化时间
    DateTime dateTime = new DateTime(2012, 12, 13, 18, 23, 55);

    // 年,月,日,时,分,秒,毫秒
    DateTime dt3 = new DateTime(2011, 2, 13, 10, 30, 50, 333);// 2010年2月13日10点30分50秒333毫秒

    // 下面就是按照一点的格式输出时间
    String str2 = dateTime.toString("MM/dd/yyyy hh:mm:ss.SSSa");
    String str3 = dateTime.toString("dd-MM-yyyy HH:mm:ss");
    String str4 = dateTime.toString("EEEE dd MMMM, yyyy HH:mm:ssa");
    String str5 = dateTime.toString("MM/dd/yyyy HH:mm ZZZZ");
    String str6 = dateTime.toString("MM/dd/yyyy HH:mm Z");

    DateTimeFormatter format = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
    // 时间解析
    DateTime dateTime2 = DateTime.parse("2012-12-21 23:22:45", format);

    // 时间格式化，输出==> 2012/12/21 23:22:45 Fri
    String string_u = dateTime2.toString("yyyy/MM/dd HH:mm:ss EE");
    System.out.println(string_u);

    // 格式化带Locale，输出==> 2012年12月21日 23:22:45 星期五
    String string_c = dateTime2.toString("yyyy年MM月dd日 HH:mm:ss EE", Locale.CHINESE);
    System.out.println(string_c);

    DateTime dt1 = new DateTime();// 取得当前时间

    // 根据指定格式,将时间字符串转换成DateTime对象,这里的格式和上面的输出格式是一样的
    DateTime dt2 = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss").parseDateTime("2012-12-26 03:27:39");

    // 计算两个日期间隔的天数
    LocalDate start = new LocalDate(2012, 12, 14);
    LocalDate end = new LocalDate(2013, 01, 15);
    int days = Days.daysBetween(start, end).getDays();

    // 计算两个日期间隔的小时数,分钟数,秒数

    // 增加日期
    DateTime dateTime1 = DateTime.parse("2012-12-03");
    dateTime1 = dateTime1.plusDays(30);
    dateTime1 = dateTime1.plusHours(3);
    dateTime1 = dateTime1.plusMinutes(3);
    dateTime1 = dateTime1.plusMonths(2);
    dateTime1 = dateTime1.plusSeconds(4);
    dateTime1 = dateTime1.plusWeeks(5);
    dateTime1 = dateTime1.plusYears(3);

    // Joda-time 各种操作.....
    dateTime = dateTime.plusDays(1) // 增加天
        .plusYears(1)// 增加年
        .plusMonths(1)// 增加月
        .plusWeeks(1)// 增加星期
        .minusMillis(1)// 减分钟
        .minusHours(1)// 减小时
        .minusSeconds(1);// 减秒数

    // 判断是否闰月
    DateTime dt4 = new DateTime();
    org.joda.time.DateTime.Property month = dt4.monthOfYear();
    System.out.println("是否闰月:" + month.isLeap());

    // 取得 3秒前的时间
    DateTime dt5 = dateTime1.secondOfMinute().addToCopy(-3);
    dateTime1.getSecondOfMinute();// 得到整分钟后，过的秒钟数
    dateTime1.getSecondOfDay();// 得到整天后，过的秒钟数
    dateTime1.secondOfMinute();// 得到分钟对象,例如做闰年判断等使用

    // DateTime与java.util.Date对象,当前系统TimeMillis转换
    DateTime dt6 = new DateTime(new Date());
    Date date = dateTime1.toDate();
    DateTime dt7 = new DateTime(System.currentTimeMillis());
    dateTime1.getMillis();

    Calendar calendar = Calendar.getInstance();
    dateTime = new DateTime(calendar);
  }
}
