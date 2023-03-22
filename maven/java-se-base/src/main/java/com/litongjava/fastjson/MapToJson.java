package com.litongjava.fastjson;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;

/**
 * @author litong
 * @date 2018年8月28日_下午8:41:57 
 * @version 1.0 
 */
public class MapToJson {
  public static void main(String[] args) {
    Map<String, String> data=new HashMap<>();
    data.put("name","litong");
    data.put("sex", "male");
    String jsonString = JSON.toJSONString(data);
    System.out.println(jsonString);
  }
}
