package com.litongjava.httpclient;
//package com.httpclient;
//
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//
//import org.apache.http.client.ClientProtocolException;
//import org.apache.http.client.methods.CloseableHttpResponse;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.entity.StringEntity;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClients;
//
//import com.alibaba.fastjson.JSON;
//
///**
// * @author litong
// * @date 2018年8月28日_下午8:43:57 
// * @version 1.0 
// */
//public class PostJson {
//  public static void main(String[] args) throws ClientProtocolException, IOException {
//    // 1.创建httpClient和post请求
//    String url = "http://www.baidu.com";
//    CloseableHttpClient httpClient = HttpClients.createDefault();
//    HttpPost httpPost = new HttpPost(url);
//    // 2.准备请求数据
//    Map<String, String> data = new HashMap<>();
//    data.put("name", "litong");
//    data.put("sex", "male");
//    String string = JSON.toJSONString(data);
//    // 3.封装成entity
//    StringEntity entity = new StringEntity(string, "UTF-8");
//    // 4.将entity放到请求是
//    httpPost.setEntity(entity);
//    // 5.设置请求头
//    httpPost.setHeader("Content-Type", "application/json");
//    // 6.执行请求
//    CloseableHttpResponse response = httpClient.execute(httpPost);
//  }
//}
