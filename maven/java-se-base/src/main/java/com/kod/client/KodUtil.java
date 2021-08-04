package com.kod.client;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.file.FileUploadUtil;
import com.httpclient.HttpClientUtil;
import com.kod.bean.AccessTokenCache;

/**
 * @author litong
 * @date 2019年2月16日_下午6:17:03 
 * @version 1.0
 * @see 02.可道云API.docx 
 * kod工具类
 */
public class KodUtil {

  /* 保存以获取的accessToken */
  private static Map<String, AccessTokenCache> accessTokenMap = new HashMap<>();

  /**
   * 获取 access_token
   * @return
   */
  public static String getAccessToken(String serverURL, String username, String apiLoginTonken) {
    String retval = null;
    AccessTokenCache cache = accessTokenMap.get(serverURL);
    if (cache == null || cache.isExpire()) { // 如果accessToken已经过期,重新请求
      // 1.请求 获取accessToekn
      String loginToken = getLoginToken(username, apiLoginTonken);
      StringBuffer link = URLUtil.append(serverURL, "?user/accessToken");
      Map<String, String> params = new HashMap<>();
      params.put("link", link.toString());
      params.put("login_token", loginToken);
      serverURL = URLUtil.append(serverURL, "?user/loginSubmit").toString();
      String jsonString = HttpClientUtil.get(serverURL, params);
      // 2.解析返回的JSON
      JSONObject jsonObject = JSON.parseObject(jsonString);
      Boolean code = jsonObject.getBoolean("code");
      if (code) {
        retval = jsonObject.getString("data");
      } else {
        retval = jsonString;
      }
      // 3.将获取到的accessToken存入缓存
      cache = new AccessTokenCache();
      cache.setAccessToken(retval);
      cache.setExpireTime(System.currentTimeMillis() + 86400000); // 默认24小时后过期
    } else { // 如果accessToke没有过期
      retval = cache.getAccessToken();
    }
    return retval;
  }

  /**
   * 获取loginToken
   * @param username
   * @param apiLoginTonken
   * @return
   */
  public static String getLoginToken(String username, String apiLoginTonken) {
    byte[] userBytes = username.getBytes();
    String encodeBase64String = Base64.encodeBase64String(userBytes);
    String md5Hex = DigestUtils.md5Hex(username + apiLoginTonken);
    String retval = encodeBase64String + '|' + md5Hex;
    return retval;
  }

  /**
   * 获取文件列表
   */
  public static String pathList(String serverURL, String username, String apiLoginTonken, String path) {
    String retval = null;
    String accessToken = getAccessToken(serverURL, username, apiLoginTonken);
    StringBuffer append = URLUtil.append(serverURL, "?explorer/pathList");
    Map<String, String> params = new HashMap<>();
    params.put("accessToken", accessToken);
    params.put("path", path);
    retval = HttpClientUtil.get(append.toString(), params);
    return retval;
  }

  /**
   * 上传文件
   */
  public static String upload(String serverURL, String username, String apiLoginTonken, String uploadTo,
      String localFilepath) {
    String accessToken = getAccessToken(serverURL, username, apiLoginTonken);
    StringBuffer append = URLUtil.append(serverURL, "?explorer/fileUpload");
    Map<String, String> params = new HashMap<>();
    params.put("accessToken", accessToken);
    params.put("upload_to", uploadTo);
    String url = HttpClientUtil.appendURL(append.toString(), params);
    StringBuilder stringBuilder = FileUploadUtil.uploadFile(localFilepath, url);
    return stringBuilder.toString();
  }

  /**
   * 设置分享文件
   */
  public static String setUserShare(String serverURL, String username, String apiLoginToken, String fileType,
      String path, String filename) {
    String accessToken = getAccessToken(serverURL, username, apiLoginToken);
    Map<String, String> params = new HashMap<>();
    StringBuffer append = URLUtil.append(serverURL, "?userShare/set");
    params.put("accessToken", accessToken);
    params.put("type", fileType);
    params.put("path", path);
    params.put("name", filename);
    String retval = HttpClientUtil.post(append.toString(), null, params);
    return retval;
  }

  /**
   * 获取分享文件列表
   * 正常的文件分享链接如下
   * http://zhishi.uairobot.com/index.php?share/file&user=1&sid=TpGnCQ9X
   */
  public static String getUserShare(String serverURL, String username, String apiLoginTonken) {
    String retval = null;
    StringBuffer append = URLUtil.append(serverURL, "?userShare/get");
    String accessToken = getAccessToken(serverURL, username, apiLoginTonken);
    Map<String, String> params = new HashMap<>();
    params.put("accessToken", accessToken);
    retval = HttpClientUtil.get(append.toString(), params);
    return retval;
  }
}
