package com.litongjava.crypto;

import java.util.Base64;

/**
 * @author litong
 * @date 2018年11月9日_下午3:57:57 
 * @version 1.0
 * JDK1.8 使用 base64 编码和解密 
 */
public class Base64Util {
  public static String encrypt(byte[] key) {
    return Base64.getEncoder().encodeToString(key);
  }

  public static byte[] decrypt(String key) {
    return Base64.getDecoder().decode(key);
  }
}
