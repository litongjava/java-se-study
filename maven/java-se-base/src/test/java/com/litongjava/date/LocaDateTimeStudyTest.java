package com.litongjava.date;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import org.junit.Test;

public class LocaDateTimeStudyTest {

  @Test
  public void test() {
    long currentTimeMillis = System.currentTimeMillis();
    currentTimeMillis = currentTimeMillis + 6 * 60 * 60 * 1000;
    Instant instant = Instant.ofEpochMilli(currentTimeMillis);
    ZoneId zone = ZoneId.systemDefault();
    LocalDateTime localDateTimeLongTime = LocalDateTime.ofInstant(instant, zone);
    System.out.println(localDateTimeLongTime);
  }

}
