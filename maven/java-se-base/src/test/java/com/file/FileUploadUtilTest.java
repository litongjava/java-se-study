package com.file;

import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.Md5Crypt;
import org.apache.commons.codec.net.URLCodec;
import org.apache.commons.lang.CharEncoding;
import org.junit.Before;
import org.junit.Test;

import com.litongjava.file.FileUploadUtil;

/**
 * @author litong
 * @date 2019年2月16日_下午4:48:23 
 * @version 1.0 
 * @See 04.commons-codec.docx
 */
public class FileUploadUtilTest {

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void test() {
    // http://zhishi.uairobot.com/?explorer/fileUpload
    String localFilePath = "D:\\k.开发资料总结\\01.JAVA_SE\\21.java-String相关类.docx";
    // 在url后面拼接参数
    String uploadURL = "http://zhishi.uairobot.com/?explorer/fileUpload?upload_to=/home";
    StringBuilder stringBuilder = FileUploadUtil.uploadFile(localFilePath, uploadURL);
    System.out.println(stringBuilder);
    // Base64
  }

  /**
   * base64加密和解密
   */
  @Test
  public void base64() {
    String user = "admin";
    byte[] encodeBase64 = Base64.encodeBase64(user.getBytes());
    byte[] decodeBase64 = Base64.decodeBase64(encodeBase64);
    String string = new String(decodeBase64);
    System.out.println(string);
  }

  /**
   * md5签名
   */
  @Test
  public void md5() {
    String password = "admin";
    String md5Crypt = Md5Crypt.md5Crypt(password.getBytes());
    System.out.println(md5Crypt);
  }

  /**
   * md5加密
   */
  @Test
  public void md5Hex() {
    String string = "admin";
    String md5Hex = DigestUtils.md5Hex(string);
    String sha1Hex = DigestUtils.sha1Hex(string);
    System.out.println(md5Hex);
    System.out.println(sha1Hex);
  }

  /**
   * url加密和解密
   */
  @Test
  public void urlCodec() {
    // 普通字符串URL加密
    String url = "http://zhishi.uairobot.com/?user/accessToken";
    URLCodec urlCodec = new URLCodec();
    try {
      String encode = urlCodec.encode(url, CharEncoding.UTF_8);
      String decode = urlCodec.decode(encode, CharEncoding.UTF_8);
      System.out.println(decode);
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    } catch (DecoderException e) {
      e.printStackTrace();
    }
  }

  /**
   * 进行url编码
   */
  @Test
  public void encodeURL() {
    // String string =
    // "?user/loginSubmit&login_token=YWRtaW4=$1$nJOolpsv$hswUZJAwvKkVjtj.4CqoI/&link=http://zhishi.uairobot.com/?user/accessToken";
    // String string =
    // "login_token=YWRtaW4=$1$nJOolpsv$hswUZJAwvKkVjtj.4CqoI/&link=http://zhishi.uairobot.com/?user/accessToken";
    String string = "http://zhishi.uairobot.com/?user/accessToken";
    URLCodec urlCodec = new URLCodec();
    String encode = null;
    try {
      encode = urlCodec.encode(string);
    } catch (EncoderException e) {
      e.printStackTrace();
    }
    System.out.println(encode);
  }
}
