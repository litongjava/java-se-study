package com.litongjava.crypto;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Administrator
 * @date 2019年1月4日_下午7:56:35 
 * @version 1.0 
 */
public class SHA1Util {
  public String digest(String pathname) {
    MessageDigest instance = null;
    try {
      instance = MessageDigest.getInstance("SHA-1");
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }
    FileInputStream fileInputStream = null;
    try {
      fileInputStream = new FileInputStream(pathname);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    byte[] buffers = new byte[1024 * 1024 * 2];
    int len = 0;
    try {
      while ((len = fileInputStream.read(buffers)) > 0) {
        instance.update(buffers, 0, len);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    byte[] digest = instance.digest();
    BigInteger bigInteger = new BigInteger(1, digest);
    String string = bigInteger.toString(16);// 转换成16进制
    int length = 40 - string.length();
    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < length; i++) {
      sb.append("0");
    }
    sb.append(string);
    return sb.toString();
  }
}
