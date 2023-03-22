package com.litongjava.file;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author Administrator
 * @date 2019年1月8日_下午2:36:54 
 * @version 1.0 
 */
public class RandomAccessFileStudy {
  public static void main(String[] args) {
    RandomAccessFile raf = null;
    try {
      raf = new RandomAccessFile("src/main/resources/raf.txt", "rw");
      raf.writeUTF("litong"); // 写入文件,指针到达文件末尾
      raf.seek(0); // 指针放到头部
      String string = raf.readUTF(); // 读出文件,指针到达文件末尾
      System.out.println(string);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
