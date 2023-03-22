package com.litongjava.localdate;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LocalDateDemo01 {

  public static void main(String[] args) {
    LocalDate localDate = LocalDate.parse("2022-10-01");
    LocalDate lastDayOfYear = localDate.with(TemporalAdjusters.lastDayOfYear());
    // lastDayOfYear:2022-12-31
    log.info("lastDayOfYear:{}",lastDayOfYear);
  }
}
