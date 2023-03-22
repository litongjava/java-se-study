package com.crypto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.management.InstanceAlreadyExistsException;

import org.junit.Test;

import com.litongjava.crypto.SHA1Util;
import com.litongjava.crypto.SHAUtil;

/**
 * @author Administrator
 * @date 2019年1月4日_下午7:12:35 
 * @version 1.0 
 */
public class SHAUtilTest {

  @Test
  public void test() {
    SHAUtil shaUtil = new SHAUtil();
    String pathname = "D:\\dev_mavenRepository\\com\\alibaba\\fastjson\\1.2.47\\fastjson-1.2.47.jar";
    File file = new File(pathname);
    FileInputStream fileInputStream = null;
    try {
      fileInputStream = new FileInputStream(file);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    FileChannel channel = fileInputStream.getChannel();
    MappedByteBuffer buffer = null;
    try {
      buffer = channel.map(FileChannel.MapMode.READ_ONLY, 0, file.length());
    } catch (IOException e) {
      e.printStackTrace();
    }

    MessageDigest instance = null;
    try {
      instance = MessageDigest.getInstance("sha1");
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }
    instance.update(buffer);
    byte[] digest = instance.digest();
  }

  @Test
  public void getSha1() {
    String pathname = "D:\\dev_mavenRepository\\com\\alibaba\\fastjson\\1.2.47\\fastjson-1.2.47.jar";
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
    System.out.println(sb);
  }
  
  @Test
  public void getSHA1() {
    String pathname="D:\\dev_mavenRepository\\antlr\\antlr\\2.7.2\\antlr-2.7.2.jar";
    SHA1Util sha1Util = new SHA1Util();
    String digest = sha1Util.digest(pathname);
    System.out.println(digest);
    
  }
}
