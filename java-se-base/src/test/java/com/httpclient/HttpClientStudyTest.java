package com.httpclient;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.junit.Test;

public class HttpClientStudyTest {

  @Test
  public void testGet() {
    HttpClient httpClient = new HttpClient();
    String url = "http://ws.webxml.com.cn/WebServices/MobileCodeWS.asmx/getMobileCodeInfo?mobileCode=18373551982&userID=";
    // 创建get对象,类似get请求
    GetMethod getMethod = new GetMethod(url);
    int code = 0;
    try {
      // 发送get请求
      code = httpClient.executeMethod(getMethod);
      System.out.println("返回的消息码为:" + code);
      System.out.println("返回的消息为:" + getMethod.getResponseBodyAsString());
    } catch (HttpException e1) {
      e1.printStackTrace();
    } catch (IOException e1) {
      e1.printStackTrace();
    } finally {
      // 释放连接
      getMethod.releaseConnection();
    }
  }

  @Test
  public void testPost() {
    HttpClient httpClient = new HttpClient();
    // 创建post请求,类似Post请求
    PostMethod postMethod = new PostMethod("http://.../WebServices/MobileCodeWS.asmx/getMobileCodeInfo");
    // 设置请求的正文内容
    postMethod.setRequestBody("mobileCode=18373551982&userID=");
    // 设置传送信息的格式
    postMethod.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    // 发送post请求
    int code = 0;
    try {
      code = httpClient.executeMethod(postMethod);
      System.out.println("返回消息码为:" + code);
      System.out.println("返回的消息为:" + postMethod.getResponseBodyAsString());
    } catch (HttpException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      postMethod.releaseConnection();
    }

  }

  @Test
  public void uploadFile(String url, File file, String key) {
    HttpClient client = new HttpClient();
    String user = "litong";
    String pswd = "pswd";

    PostMethod postMethod = new PostMethod(url);

    // 通过以下方法可以模拟页面参数提交
    postMethod.setParameter("user", user);
    postMethod.setParameter("pswd", pswd);
    HttpMethodParams params = postMethod.getParams();

    Part[] parts = new Part[1];

    try {
      FilePart filePart = new FilePart("photo", file.getName(), file);
      parts[0] = filePart;
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    MultipartRequestEntity entity = new MultipartRequestEntity(parts, params);
    postMethod.setRequestEntity(entity);
    client.getHttpConnectionManager().getParams().setConnectionTimeout(5000);

    int status = 0;
    StringBuffer stringBuffer = new StringBuffer();
    try {
      status = client.executeMethod(postMethod);
      InputStream inputStream = postMethod.getResponseBodyAsStream();
      BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

      String str = null;
      while ((str = br.readLine()) != null) {
        stringBuffer.append(str);
        stringBuffer.append(System.getProperty("line.separator"));
      }
    } catch (HttpException e) {
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      postMethod.releaseConnection();
    }
    if (status == HttpStatus.SC_OK) {
      System.out.println("上传成功");
      System.out.println(stringBuffer.toString());
    } else {
      System.out.println("上传失败");
      System.out.println(stringBuffer.toString());
    }

  }
}
