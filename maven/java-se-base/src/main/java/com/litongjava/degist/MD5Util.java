package com.litongjava.degist;

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
 * @date 2018年12月21日_下午6:10:28 
 * @version 1.0 
 */
public class MD5Util {
  // 消息签名类
  private static MessageDigest messageDigest = null;
  // 16进制字符
  private static char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

  /**
  * 获取文件的md5 code
  * @param file
  * @return
  * @throws NoSuchAlgorithmException
  */
  public static String getMD5Code(File file) throws NoSuchAlgorithmException {
    String retval = null;
    if (messageDigest == null)
      messageDigest = messageDigest.getInstance("md5");

    try {
      FileInputStream fileInputStream = new FileInputStream(file);
      FileChannel channel = fileInputStream.getChannel();
      MappedByteBuffer byteBuffer = channel.map(FileChannel.MapMode.READ_ONLY, 0, file.length());
      messageDigest.update(byteBuffer);
      byte[] digest = messageDigest.digest();
      StringBuffer stringBuffer = new StringBuffer(digest.length * 2);
      for (int i = 0; i < digest.length; i++) {
        // 将字节转为16进制
        char c1 = hexDigits[(digest[i] & 0xf0) >> 4];
        char c2 = hexDigits[(digest[i] & 0xf)];
        stringBuffer.append(c1).append(c2);
      }
      retval = stringBuffer.toString();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return retval;
  }
}
