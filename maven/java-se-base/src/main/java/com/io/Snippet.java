package com.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.IOException;

public class Snippet {
  public static void main(String[] args) throws IOException {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();// 不需要路径，写入内存，跟磁盘无需关联
    baos.write("这是要写入内存流的数据".getBytes());// 将字符串变成字节数组，写入内存
    baos.close();// 此处关闭内存流无效 下面的数据也可写入
    baos.write("helloworld".getBytes());// 注意：之前的IO流都是跟磁盘文件建立了连接，需要关闭连接即关闭流！ 而关闭内存流跟连接无关

    byte[] byteArray = baos.toByteArray();// 获取内存中存数据的数组
    // 使用内存输入流 读取获得内存中的保存数据的数组
    ByteArrayInputStream bais = new ByteArrayInputStream(byteArray);// ByteArrayInputStream(byte[] buf):创建一个

    // 读
    int len;
    byte[] b = new byte[1024];
    while ((len = bais.read(b)) != -1) {
      System.out.println(new String(b, 0, len));
    }

    CharArrayWriter caw = new CharArrayWriter();
    caw.write("这是内存字符流写入的内容");

    char[] ch = caw.toCharArray();
    CharArrayReader car = new CharArrayReader(ch);

    // 读
    int len2;
    char[] c = new char[10];
    while ((len2 = car.read(c)) != -1) {
      System.out.print(new String(c, 0, len2));
    }
  }
}
