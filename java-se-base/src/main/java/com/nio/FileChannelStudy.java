package com.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/**
 * @author Administrator
 * @date 2019年1月15日_下午5:01:20 
 * @version 1.0 
 */
public class FileChannelStudy {

  public static void main(String[] args) throws FileNotFoundException, IOException {
    Charset charset = Charset.forName("GBK");
    CharsetDecoder docoder = charset.newDecoder();
    String jsonFile = "D:\\dev_workspace\\java\\study\\ee-mybatis-base\\Ds001Ycjbxx.json";
    try (FileInputStream fileInputStream = new FileInputStream(jsonFile);
        FileChannel fileInputChannel = fileInputStream.getChannel()) {
      ByteBuffer buffer = ByteBuffer.allocate(16 * 1024 * 1024);
      int i = 0;
      while (fileInputChannel.read(buffer) != -1) {
        buffer.flip();
        CharBuffer charBuffer = docoder.decode(buffer);
        buffer.clear();
        System.out.println(charBuffer);
        System.out.println(++i);
      }
    }
  }
}
