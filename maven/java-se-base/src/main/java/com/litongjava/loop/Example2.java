package com.litongjava.loop;
/**
 * @author litong
 * @date 2018年10月2日_下午3:19:47 
 * @version 1.0
 * 99乘法口诀表 
 */
public class Example2 {
  public static void main(String[] args) {
    for(int i=1;i<10;i++) {
      for(int j=1;j<i+1;j++) {
        System.out.print(j+"C"+i+"="+j*i+"\t");
      }
      System.out.println();
    }
  }
}
