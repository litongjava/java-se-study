package com.kod;

import org.apache.commons.codec.digest.Md5Crypt;
import org.junit.Before;
import org.junit.Test;

import com.httpclient.HttpClientUtil;
import com.kod.client.KodUtil;

import lombok.extern.log4j.Log4j;

/**
 * @author litong
 * @date 2019年2月16日_下午6:48:23 
 * @version 1.0 
 */
@Log4j
public class KodUtilTest {
  String serverURL = "http://zhishi.uairobot.com";
  String username = "admin";
  String apiLoginTonken = "litong";

  @Before
  public void setUp() throws Exception {
  }

  /**
   * getLoginToken
   */
  @Test
  public void testgetLoginToken() {
    String loginToken = KodUtil.getLoginToken(username, apiLoginTonken);
    log.info("loginToken : " + loginToken);
  }

  /**
   * 上传文件
   */
  @Test
  public void uploadToKod() {
    String accessToken = KodUtil.getAccessToken(serverURL, username, apiLoginTonken);

  }

  /*
   * getAccessToken
   */
  @Test
  public void testgetAccessToken() {
    String accessToken = KodUtil.getAccessToken(serverURL, username, apiLoginTonken);
    HttpClientUtil.debug = true;
    log.info("accessToken : " + accessToken);
  }

  /**
   * pathList
   */
  @Test
  public void pathList() {
    String pathList = KodUtil.pathList(serverURL, username, apiLoginTonken, "/var/www/html/data/User/admin/home/");
    log.info("pathList : " + pathList);
  }

  /*
   * getUserShare
   */
  @Test
  public void getUserShare() {
    String userShare = KodUtil.getUserShare(serverURL, username, apiLoginTonken);
    log.info("userShare : " + userShare);
  }

  /**
   * setUserShare
   */
  @Test
  public void setUserShare() {
    String type = "file";
    String path = "/var/www/html/data/User/admin/home/广西电网/04.ibot知识建设注意事项.docx";
    String filename = "04.ibot知识建设注意事项.docx";
    String setUserShare = KodUtil.setUserShare(serverURL, username, apiLoginTonken, type, path, filename);
    log.info("setUserShare : " + setUserShare);
  }

  /**
   * upload
   */
  @Test
  public void upload() {
    String uploadTo = "/var/www/html/data/User/admin/home/广西电网/";
    String localFilepath = "C:\\Users\\Administrator\\Desktop\\robot20181112pom.xml";
    String upload = KodUtil.upload(serverURL, username, apiLoginTonken, uploadTo, localFilepath);
    log.info("upload : " + upload);
  }

  /**
   * md5加密
   */
  @Test
  public void md5Crypt() {
    String string = "adminlitong";
    String md5Crypt = Md5Crypt.md5Crypt(string.getBytes());
    System.out.println(md5Crypt);
  }
}
