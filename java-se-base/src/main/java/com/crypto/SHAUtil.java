package com.crypto;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author litong
 * @date 2018年11月9日_下午5:39:08 
 * @version 1.0 
 */
public class SHAUtil {
  public static byte[] encryptSHA(byte[] data) {
    MessageDigest messageDigest = null;
    try {
      messageDigest = MessageDigest.getInstance("sha");
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }
    messageDigest.update(data);
    byte[] digest = messageDigest.digest();
    return digest;
  }
}
