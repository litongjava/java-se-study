package com.litongjava.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author litong
 * @date 2018年8月15日_下午1:38:26 
 * @version 1.0 
 */
public class ReadFile {
  public static void main(String[] args) {
    readToNull();
  }

  /**
   * 测试测试读取到最后时,长度是不是0
   */
  public static void readToNull() {
    String txtFile = "D:\\dev_workspace\\java\\study\\se-base\\src\\main\\java\\com\\io\\三字经.txt";
    InputStream in = ReadFile.class.getClassLoader().getResourceAsStream("com\\io\\三字经.txt");
    InputStreamReader inReader = new InputStreamReader(in);
    BufferedReader bufReader = new BufferedReader(inReader);
    String line = null;

    try {
      for (;;) {
        line = bufReader.readLine();
        if(line!=null) {
          System.out.println(line);
        }
        System.out.println(line.length());
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (bufReader != null) {
        try {
          bufReader.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
