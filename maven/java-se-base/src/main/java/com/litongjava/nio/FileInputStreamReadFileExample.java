package com.litongjava.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author litong
 * @date 2018年12月11日_上午9:06:53 
 * @version 1.0 
 */
public class FileInputStreamReadFileExample {
  public static void main(String[] args) {
    String filepath = "src\\main\\java\\com\\nio\\file.txt";
    File file = new File(filepath);
    byte[] buffer = new byte[(int) file.length()];
    FileInputStream fileInputStream = null;
    try {
      fileInputStream = new FileInputStream(file);
      fileInputStream.read(buffer);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
