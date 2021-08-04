package com.urlencodec;

import static org.junit.Assert.fail;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import org.junit.Test;

/**
 * @author litong
 * @date 2018年9月5日_下午4:23:38 
 * @version 1.0 
 */
public class URLEncodecTest {

  @Test
  public void test() {
    fail("Not yet implemented");
  }

  /**
   * 测试URL解码
   * @throws UnsupportedEncodingException
   */
  @Test
  public void test1() throws UnsupportedEncodingException {
    String decode = URLDecoder.decode("%E6%96%87%E6%A1%A3", "utf8");
    System.out.println(decode);
  }

  /**
   * 测试URL编码
   * @throws UnsupportedEncodingException 
   */
  @Test
  public void test2() throws UnsupportedEncodingException {
    String encode = URLEncoder.encode("文档", "utf-8");
    System.out.println(encode);
  }
  
  /**
   * 使用URL解码
   * @throws UnsupportedEncodingException 
   */
  @Test
  public void test3() throws UnsupportedEncodingException {
    String URLStr="http://nlp.xiaoi.com/robot/ask.action?ver=200&userId=api-rsfktgho&platform=web&format=json&question=%E4%BB%8A%E5%A4%A9%E5%8C%97%E4%BA%AC%E5%A4%A9%E6%B0%94&user_drcmd_conf=&user_ask_ex=ceshi11&from3rd=true";
    String decode = URLDecoder.decode(URLStr,"utf-8");
    System.out.println(decode);
  }
}
