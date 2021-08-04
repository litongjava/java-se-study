package com.httpclient;

import static org.junit.Assert.fail;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Administrator
 * @date 2019年2月18日_上午10:56:30 
 * @version 1.0 
 */
public class HttpClientUtilTest {

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void test() {
    fail("Not yet implemented");
  }

  /**
   * 发送json数据方式1
   * @see 02.commons-httpclient.docx
   */
  @Test
  public void sendJSON1() {
    String url = "http://";
    String jsonString = "";
    HttpClient httpClient = new HttpClient();
    PostMethod method = new PostMethod(url);
    // 1.发送请求,将返回保存到InputStream中
    InputStream in = null;
    try {
      RequestEntity entity = new StringRequestEntity(jsonString, "application/json", "UTF-8");
      method.setRequestEntity(entity);
      httpClient.executeMethod(method);
      in = method.getResponseBodyAsStream();
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    } catch (HttpException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      method.releaseConnection();
    }
    // 2.将InputStream转为StringBuffer
    StringBuffer stringBuffer = new StringBuffer();
    char[] buffer = new char[1024 * 1024]; // 1M
    InputStreamReader reader = null;
    try {
      reader = new InputStreamReader(in, "UTF-8");
      for (int n; (n = reader.read(buffer)) != -1;) {
        stringBuffer.append(new String(buffer, 0, n));
      }
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      IOUtils.closeQuietly(reader);
    }
  }

  /**
   * 发送json数据方式2
   */

}
