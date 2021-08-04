package com.interfaces;
/**
 * @author litong
 * @date 2018年10月5日_下午6:34:53 
 * @version 1.0 
 */
public class Computer {
  private Output out;
  public Computer(Output out) {
    this.out=out;
  }
  //定义一个模拟获取字符串输入的方法
  public void keyIn(String msg) {
    out.getData(msg);
  }
  //定义一个模拟打印的方法
  public void print() {
    out.out();
  }
}
