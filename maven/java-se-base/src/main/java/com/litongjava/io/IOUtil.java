package com.litongjava.io;

import java.io.*;

public class IOUtil {
  private InputStream input;
  private OutputStream output;
  private static int length;

  /**
   * 文件复制
   * @param beginFilename
   * @param endFilename
   */
  public void fileCopy(String beginFilename, String endFilename) {
    // 创建输入输出流对象
    try {
      input = new FileInputStream(beginFilename);
      output = new FileOutputStream(endFilename);

      // 获取文件长度
      try {
        length = input.available();
        // 创建缓存区域
        byte[] buffer = new byte[length];
        // 将文件中的数据写入缓存数组
        input.read(buffer);
        // 将缓存数组中的数据输出到文件
        output.write(buffer);
      } catch (IOException e) {
        e.printStackTrace();
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } finally {
      if (input != null && output != null) {
        try {
          input.close(); // 关闭流
          output.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }

  public static void main(String[] args) {
    IOUtil man = new IOUtil();
    // 第一个参数是将要复制的文件，第二个参数是输出的目标文件（如果没有，则新建一个，实现文件的复制）
    man.fileCopy("F:\\CodeWorkSpace\\java\\FileCopy\\src\\test0713\\Manage.java", "C:\\Users\\yuxiu\\Desktop\\123.txt");
  }
}