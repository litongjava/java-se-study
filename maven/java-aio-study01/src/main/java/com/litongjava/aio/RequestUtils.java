package com.litongjava.aio;

import java.util.HashMap;
import java.util.Map;

public class RequestUtils {

  // 从请求中提取请求路径
  public static String getRequestPath(String request) {
    String[] lines = request.split("\r\n");
    for (String line : lines) {
      if (line.startsWith("GET") || line.startsWith("POST")) {
        String[] parts = line.split(" ");
        if (parts.length > 1) {
          String query = parts[1];
          return query.split("\\?")[0]; // 提取请求路径
        }
      }
    }
    return "/";
  }

  // 从请求中提取参数并封装为Map的方法
  public static Map<String, String> getRequestMap(String request) {
    Map<String, String> paramMap = new HashMap<>();
    String[] lines = request.split("\r\n");
    for (String line : lines) {
      if (line.startsWith("GET") || line.startsWith("POST")) {
        String[] parts = line.split(" ");
        if (parts.length > 1) {
          String query = parts[1];
          if (query.contains("?")) {
            String[] queryParams = query.substring(query.indexOf("?") + 1).split("&");
            for (String param : queryParams) {
              String[] keyValue = param.split("=");
              if (keyValue.length > 1) {
                paramMap.put(keyValue[0], keyValue[1]);
              } else {
                paramMap.put(keyValue[0], ""); // 如果没有值，则设为空字符串
              }
            }
          }
        }
      }
    }
    return paramMap;
  }

}
