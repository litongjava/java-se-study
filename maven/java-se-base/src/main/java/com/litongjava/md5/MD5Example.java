package com.litongjava.md5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author litong
 * @date 2018年12月12日_下午5:22:32 
 * @version 1.0 
 */
public class MD5Example {
  public static void main(String[] args) {
    MD5Example md5Example = new MD5Example();
    // md5Example.testFileIsExists();
    String filePath = "D:\\我的文档\\WeChat Files\\jdk131219\\Files\\接口对接(1).zip";
    File file = new File(filePath);
    String md5Code = md5Example.getMD5Code(file);
    System.out.println(md5Code);
  }

  public boolean testFileIsExists() {
    String filePath = "D:\\我的文档\\WeChat Files\\jdk131219\\Files\\接口对接(1).zip";
    File file = new File(filePath);
    boolean exists = file.exists();
    System.out.println(exists);
    return exists;
  }

  /**
   * 
   * @return
   */
  protected static char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e',
      'f' };

  /**
   * 消息签名类 
   */
  private MessageDigest messagedigest = null;

  public String getMD5Code(File file) {
    try {
      messagedigest = MessageDigest.getInstance("MD5");
    } catch (NoSuchAlgorithmException e1) {
      e1.printStackTrace();
    }
    FileInputStream fileInputStream = null;
    try {
      fileInputStream = new FileInputStream(file);
    } catch (FileNotFoundException e1) {
      e1.printStackTrace();
    }
    FileChannel fileChannel = fileInputStream.getChannel();
    MappedByteBuffer byteBuffer = null;
    try {
      byteBuffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, file.length());
    } catch (IOException e) {
      e.printStackTrace();
    }
    messagedigest.update(byteBuffer);
    byte[] digest = messagedigest.digest();
    // digest是签名后的内容,16字节
    System.out.println(digest.length);

    return null;
  }
 
}
