package com.litongjava.httpclient;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author litong
 * @date 2019年2月18日_下午2:38:20 
 * @version 1.0 
 */

public class HTTP {

  /**
   * 向指定URL发送post方法的请求，字符串
   * @param urlString 地址
   * @param reqString 请求参数 name1=value1&name2=value2 的形式。
   * @return String 返回内容
   */
  public static String postString(String urlString, String reqString) {
    StringBuffer sb = new StringBuffer("");
    try {
      // 创建连接
      URL url = new URL(urlString);
      HttpURLConnection connection = (HttpURLConnection) url.openConnection();
      connection.setRequestMethod("POST");
      connection.setDoOutput(true);
      connection.setDoInput(true);
      connection.setUseCaches(false);
      connection.setInstanceFollowRedirects(true);
      // 下边这行注释掉
      // connection.setRequestProperty("Content-Type","application/json;charset=UTF-8");
      connection.connect();
      DataOutputStream out = new DataOutputStream(connection.getOutputStream());
      out.write(reqString.getBytes("UTF-8"));
      out.flush();
      out.close();
      // 读取响应
      BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
      String lines;

      while ((lines = reader.readLine()) != null) {
        sb.append(lines);
      }
      reader.close();
      connection.disconnect();// 断开连接
    } catch (MalformedURLException e) {
      e.printStackTrace();
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    if (sb.toString().length() == 0 | sb.toString().trim().length() == 0) {
      return "";
    }
    return sb.toString();
  }
}
