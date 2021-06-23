package com.crypto;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * @author litong
 * @date 2018年11月9日_下午5:49:37 
 * @version 1.0 
 */
public class HMACUtil {

  /**
   * 初始化 HMAC key
   */
  public static byte[] initMacKey() {
    KeyGenerator keyGenenrator = null;
    try {
      keyGenenrator = KeyGenerator.getInstance("HmacMD5");
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }
    SecretKey secretKey = keyGenenrator.generateKey();
    byte[] encoded = secretKey.getEncoded();
    return encoded;
  }

  /**
   * 使用 HMAC 加密 
   */
  public static byte[] encryptHMAC(byte[] data,byte[] key) {
    // 通过指定字符,和算法构建秘钥
    SecretKey secretKey = new SecretKeySpec(key, "HmacMD5");
    Mac mac = null;
    try {
      // 返回指定mac算法的mac对象
      mac = Mac.getInstance(secretKey.getAlgorithm());
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }
    try {
      // 通过指定的秘钥初始化此mac对象
      mac.init(secretKey);
    } catch (InvalidKeyException e) {
      e.printStackTrace();
    }
    byte[] doFinal = mac.doFinal(data);
    return doFinal;
  }
}
