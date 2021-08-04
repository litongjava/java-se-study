package com.nio;

import java.nio.CharBuffer;

/**
 * @author Administrator
 * @date 2019年1月15日_下午4:30:28 
 * @version 1.0 
 */
public class CharBufferStudy {
  public static void main(String[] args) {
    CharBufferStudy study = new CharBufferStudy();
    study.study01();
  }

  public void study01() {
    CharBuffer charBuffer1 = CharBuffer.allocate(10);
    CharBuffer charBuffer2 = charBuffer1.duplicate();
    charBuffer1.put('a').put('b').put('c');
    charBuffer1.flip();
    System.out.println(charBuffer1);
    System.out.println(charBuffer2);
  }
}
