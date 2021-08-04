package com.interfaces;

/**
 * @author litong
 * @date 2018年10月5日_下午10:30:24 
 * @version 1.0 
 */
public class Print implements Output {
  // 记录当前正在打印的记录数
  private int dataNum = 0;
  private String[] printData = new String[MAX_CACHE_LINE];

  /**
   * 设置打印数据
   */
  @Override
  public void getData(String msg) {
    if (dataNum >= MAX_CACHE_LINE) {
      System.out.println("队列已满" + dataNum + ":" + dataNum);
    } else {
      // 把打印数据,添加到队列中,已保存的数量加1
      printData[dataNum++] = msg;
    }
  }

  /**
   * 输出数据
   */
  @Override
  public void out() {
    // 只要还有作业,就继续打印
    while (dataNum > 0) {
      System.out.println("打印机打印" + printData[0]);
      // 把作业队列整体前移一位,并将剩下的作业数减一
      System.arraycopy(printData, 1, printData, 0, --dataNum);
    }
  }
}
