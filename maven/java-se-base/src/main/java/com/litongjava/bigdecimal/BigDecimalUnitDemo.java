package com.litongjava.bigdecimal;

import java.math.BigDecimal;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BigDecimalUnitDemo {

  public static void main(String[] args) {
    BigDecimal value = BigDecimal.valueOf(35500L);
    BigDecimal result = value.divide(BigDecimal.valueOf(1e4), 2, BigDecimal.ROUND_HALF_UP);
    log.info(result.toString());
    
    value = BigDecimal.valueOf(5500L);
    result= value.divide(BigDecimal.valueOf(1e4), 2, BigDecimal.ROUND_HALF_UP);
    log.info(result.toString());
  }
}
