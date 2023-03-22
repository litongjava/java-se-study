package com.litongjava.httpclient;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.ByteArrayPartSource;
import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.commons.httpclient.methods.multipart.PartSource;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.io.IOUtils;

public class UploadBytesExample {
  public static void main(String[] args) {
    String filePath = "E:\\FaceOpenCVData\\002.jpg";
    String url = "http://127.0.0.1:8080/api/upload";
    FileInputStream fis = null;
    byte[] buf = null;
    try {
      fis = new FileInputStream(filePath);
      int available = fis.available();
      buf = new byte[available];
      fis.read(buf, 0, available);
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      IOUtils.closeQuietly(fis);
    }
    PartSource partSource = new ByteArrayPartSource(filePath, buf);
    FilePart filePart = new FilePart("photo", partSource);
    Part[] parts = new Part[1];
    parts[0] = filePart;

    HttpClient client = new HttpClient();
    PostMethod postMethod = new PostMethod(url);
    HttpMethodParams params = postMethod.getParams();
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
