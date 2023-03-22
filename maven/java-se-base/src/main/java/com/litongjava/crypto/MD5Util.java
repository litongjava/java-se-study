package com.litongjava.crypto;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author litong
 * @date 2018年11月9日_下午4:41:26 
 * @version 1.0 
 */
public class MD5Util {
  public static byte[] encryptMD5(byte[] bytes) {
    // 使用md5算法,初始信息摘要算法
    MessageDigest messageDigest=null;;
    try {
      messageDigest = MessageDigest.getInstance("md5");
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }
    messageDigest.update(bytes);
    byte[] digest = messageDigest.digest();
    return digest;
  }
}
