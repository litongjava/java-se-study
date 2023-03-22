package com.litongjava.loop;
/**
 * @author litong
 * @date 2018年10月2日_下午3:06:17 
 * @version 1.0
 * 我国最高山峰是珠穆朗玛峰：8848m，我现在有一张足够大的纸张，厚度为：0.01m。请问，我折叠多少次，就可以保证厚度不低于珠穆朗玛峰的高度? 
 */
public class Example1 {
  public static void main(String[] args) {
    int base=1; // 0.01*100
    int max=884800; //8848*100
    int count=0;
    while(base<max) {
      base=base*2;
      count++;
    }
    System.out.println(count);
  }
}
