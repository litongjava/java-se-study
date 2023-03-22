package com.litongjava.httpclient;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.commons.httpclient.params.HttpMethodParams;

public class UploadFileExample {
  public static void main(String[] args) {
    HttpClient client = new HttpClient();
    String localFile = "E:\\FaceOpenCVData\\002.jpg";
    String url = "http://127.0.0.1:8080/api/upload";
    String user = "litong";
    String pswd = "pswd";

    File file = new File(localFile);
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
