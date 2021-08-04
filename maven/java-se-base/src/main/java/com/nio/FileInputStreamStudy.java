package com.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;


/**
 * @author Administrator
 * @date 2019年1月14日_上午9:09:18 
 * @version 1.0 
 */
public class FileInputStreamStudy {
  public static void main(String[] args) throws FileNotFoundException, IOException {
    try (FileInputStream fileInputStream = new FileInputStream("ReadFile.java");
        // 创建一个FileChannel
        FileChannel inputFileChannel = fileInputStream.getChannel()) {
      // 定义一个ByteBuffer对象,用于重复取水,250B
      ByteBuffer buffer = ByteBuffer.allocate(256);
      // 将FileChannel中的数据读入到ByteBuffer中
      while (inputFileChannel.read(buffer) != -1) {
        // 锁定Buffer空白区,主要是防止最后一处读不满
        buffer.flip();
        // 创建Charset对象
        Charset charset = Charset.forName("GBK");
        // 创建解码器对象
        CharsetDecoder decoder = charset.newDecoder();
        // 将ByteBuffer内容转码
        CharBuffer charBuffer = decoder.decode(buffer);
        // 将bufer初始化,为下一次读取数据做准备
        buffer.clear();
      }
    }
  }

  public void study01() {
    FileInputStream fis = null;
    try {
      fis = new FileInputStream("c://testJavaIO/aaa.java");
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    // 创建字节输入流
    byte[] bbuf = new byte[1024]; // 创建一个字节长度为1024的缓存，即"竹筒"
    int hasRead = 0; // 用于保存每次实际读取的字节数
    int i = 0;
    try {
      while ((hasRead = fis.read(bbuf)) > 0) { // 如果取得数据为-1或0，说明上一次已经取完所有数据
        System.out.println(new String(bbuf, 0, hasRead));
        System.out.println("i------" + i);
        i++;
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (fis != null) {
        try {
          fis.close();// 关闭文件输入流
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }

  public void study02() throws FileNotFoundException {
    FileReader fileReader = null;
    char[] cbuf = new char[1024]; // 创建一个字符长度为32的缓存，即"竹筒"
    int hasRead = 0; // 用于保存实际读取的字符数
    int i = 0;
    try {
      fileReader = new FileReader("c://temp/litong.java");
      while ((hasRead = fileReader.read(cbuf)) > 0) {
        System.out.println(new String(cbuf, 0, hasRead)); // 每次取得缓存中的字符数组cbuf，将字符数组转化成字符串输出
        System.out.println("i------" + i);
        i++;
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (fileReader != null) {
        try {
          fileReader.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }

  public void fileReaderTest() throws IOException {
    try (FileReader fileReader = new FileReader("D:/test/test.txt")) {
      // 创建一个长度为1024的竹筒
      char[] b = new char[1024];
      // 用于保存的实际字节数
      int hasRead = 0;
      // 使用循环来重复取水的过程
      while ((hasRead = fileReader.read(b)) > 0) {
        // 取出竹筒中的水滴（字节），将字节数组转换成字符串进行输出
        System.out.print(new String(b, 0, hasRead));
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}