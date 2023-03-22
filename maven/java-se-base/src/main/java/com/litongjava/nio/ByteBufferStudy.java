package com.litongjava.nio;

import java.nio.ByteBuffer;

/**
 * @author Ping E Lee
 * @date 2019年1月15日_下午3:18:49 
 * @version 1.0 
 */
public class ByteBufferStudy {
  public static void main(String[] args) {
    ByteBuffer byteBuffer = ByteBuffer.allocate(10);

    byteBuffer.put((byte) 3);

    byteBuffer.position(0);// 设置Position到0的位置,读取数据时从0考试读取
    byteBuffer.limit(1);// 设置Limit为1,表示当前ByteBuffer的有效数据长度是1

    byte data = byteBuffer.get();
    System.out.println(data);
    System.out.println(byteBuffer);
  }
}
