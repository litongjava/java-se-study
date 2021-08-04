package com.bitoperator;

/**
 * @author litong
 * @date 2018年8月7日_上午9:01:22 
 * @version 1.0 
 */
public class AndOperator {
  public static void main(String[] args) {
    int i=1024;
    String binaryString = Integer.toBinaryString(i);
    System.out.println(binaryString);
    int i1=i & 0xff;
    System.out.println(i1);
    int i2=i>>8 & 0xff;
    System.out.println(i2);
    
  }
}
