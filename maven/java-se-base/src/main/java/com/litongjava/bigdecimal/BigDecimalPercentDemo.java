package com.litongjava.bigdecimal;

import java.math.BigDecimal;
import java.text.NumberFormat;

public class BigDecimalPercentDemo {

  public static void main(String[] args) {

    BigDecimal total = BigDecimal.valueOf(10000);
    BigDecimal tradingAmount = BigDecimal.valueOf(7272);
    BigDecimal divide = tradingAmount.divide(total);

    // 下面将结果转化成百分比
    NumberFormat percentFormat = NumberFormat.getPercentInstance();
    percentFormat.setMaximumFractionDigits(2);
    String perent = percentFormat.format(divide.doubleValue());
    System.out.println(perent);

  }
}
