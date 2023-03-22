package com.litongjava.kod.client;

/**
 * Created by litong on 2019/1/21 0021.
 */
public class URLUtil {
  /**
   * 拼接2个url
   * @param url1
   * @param url2
   * @return
   */
  public static StringBuffer append(String url1, String url2) {
    StringBuffer stringBuffer = new StringBuffer();
    if (url1.endsWith("/") && url2.startsWith("/")) {
      // http://www.baidu.com/ /query
      stringBuffer.append(url1);
      // 删除url1最后一个字符
      stringBuffer.deleteCharAt(stringBuffer.length() - 1);
      stringBuffer.append(url2);
      return stringBuffer;
    } else if (url1.endsWith("/") && !url2.startsWith("/")) {
      // http://www.baidu.com/ query
      stringBuffer.append(url1).append(url2);
      return stringBuffer;
    } else if (!url1.endsWith("/") && url2.startsWith("/")) {
      // http://www.baidu.com /query
      stringBuffer.append(url1).append(url2);
      return stringBuffer;
    } else if (!url1.endsWith("/") && !url2.startsWith("/")) {
      stringBuffer.append(url1).append("/").append(url2);
      return stringBuffer;
    } else {
      // log.info("你输入的url可能存在问题" + "url1:" + url1.toString() + ",url2:" +
      // url2.toString());
      System.out.println("你输入的url可能存在问题" + "url1:" + url1.toString() + ",url2:" + url2.toString());
    }
    return stringBuffer;
  }
}
