package com.aes;

import java.security.NoSuchAlgorithmException;
import java.security.Provider;

import javax.crypto.KeyGenerator;

public class KeyGeneratorStudy {
  public static void main(String[] args) throws NoSuchAlgorithmException {
    KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
    System.out.println(keyGenerator);
    String algorithm = keyGenerator.getAlgorithm();
    System.out.println(algorithm);
    Provider provider = keyGenerator.getProvider();
    System.out.println(provider);
    // 初始化 KeyGenerator对象,通过随机源的方式
    // 初始化 KeyGenarator对象,指定密码生成的大小
  }
}