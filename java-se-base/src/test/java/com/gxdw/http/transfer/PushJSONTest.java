//package com.gxdw.http.transfer;
//
//import java.io.IOException;
//import java.io.UnsupportedEncodingException;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.apache.commons.httpclient.NameValuePair;
//import org.apache.http.client.entity.UrlEncodedFormEntity;
//import org.apache.http.entity.StringEntity;
//import org.apache.http.message.BasicNameValuePair;
//import org.junit.Test;
//
///**
// * @author litong
// * @date 2018年6月14日_下午4:56:34 
// * @version 1.0 
// */
//public class PushJSONTest {
//  String url = "http://111.202.106.148:12011/api/IVRService/putDialogData.do";
//
//  @Test
//  public void test1() {
//    String json = "{\"call_id\":\"null\",\"session_id\":\"null\",\"call_end_time\":\"20180614164001\",,\"call_start_time\":\"null\",\"seat_no\":\"43033\",\"tel_no\":\"undefined\"}";
//    String sendJson = HTTPClient.sendJson(url, json);
//    System.out.println(sendJson);
//  }
//
//  @Test
//  public void test2() {
//    String json = "{\"call_id\":\"null\",\"session_id\":\"null\",\"call_end_time\":\"20180614164001\",,\"call_start_time\":\"null\",\"seat_no\":\"43033\",\"tel_no\":\"undefined\"}";
//    StringEntity reqJson = null;
//    try {
//      reqJson = new StringEntity(json);
//    } catch (UnsupportedEncodingException e) {
//      e.printStackTrace();
//    }
//    String retval = null;
//    try {
//      retval = HTTPClient.post(url, reqJson);
//    } catch (IOException e) {
//      e.printStackTrace();
//    }
//    System.out.println(retval);
//  }
//
//  @Test
//  public void test3() {
//    String json = "{\"call_id\":\"litong0001\",\"session_id\":\"litong001\",\"call_end_time\":\"20180614164001\",\"call_start_time\":\"null\",\"seat_no\":\"43033\",\"tel_no\":\"undefined\"}";
//    List<NameValuePair> httpValue = new ArrayList<>();
//    httpValue.add(new BasicNameValuePair("json", json));
//    UrlEncodedFormEntity entity = null;
//    try {
//      entity = new UrlEncodedFormEntity(httpValue);
//    } catch (UnsupportedEncodingException e) {
//      e.printStackTrace();
//    }
//
//    String post = null;
//    try {
//      post = HTTPClient.post(url, entity);
//    } catch (IOException e) {
//      e.printStackTrace();
//    }
//    System.out.println(post);
//  }
//
//  @Test
//  public void test4() throws IOException {
//    String json = " \"call_id\":\"abc1236\", \"session_id\":\"123456710\", \"tel_no\":\"135xxxxxxxxx\", \"call_start_time\":\"20180322163601\", \"call_end_time\":\"20180322163901\", \"seat_no\":\"12345\" }";
//    List<NameValuePair> httpValue = new ArrayList<>();
//    httpValue.add(new BasicNameValuePair("json", json));
//    UrlEncodedFormEntity entity = new UrlEncodedFormEntity(httpValue);
//    String post = HTTPClient.post(url, entity);
//    System.out.println(post);
//  }
//}
