package com.litongjava.interfaces;

/**
 * @author litong
 * @date 2018年10月6日_上午10:54:19 
 * @version 1.0 
 */
public class BetterPrint implements Output {

  private int dataNum = 0;
  private String[] printData = new String[MAX_CACHE_LINE * 2];

  @Override
  public void getData(String msg) {
    if (dataNum >= MAX_CACHE_LINE * 2) {
      System.out.println("队列已满,添加失败");
    } else {
      printData[dataNum++] = msg;
    }
  }

  @Override
  public void out() {
    while (dataNum > 0) {
      System.out.println("打印机正在打印:" + printData[0]);
      System.arraycopy(printData, 1, printData, 0, --dataNum);
    }
  }
}
