package com.litongjava.json;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.litongjava.bean.User;

/**
 * @author Administrator
 * @date 2019年1月25日_下午1:32:58 
 * @version 1.0 
 */
public class JSONSerializer {

  public static void main(String[] args) {
    String s = "{\"user1\":{\"name\":\"user1\",\"pswd\":\"123456\"},\"user2\":{\"name\":\"user2\",\"pswd\":\"123456\"}}";
    Map<String, User> deserilizableForMapFromFile = deserilizableForMapFromFile(s, String.class, User.class);
    Set<Entry<String, User>> entrySet = deserilizableForMapFromFile.entrySet();
    for (Entry<String, User> e : entrySet) {
      System.out.println(e.getKey() + ":" + e.getValue());
    }
  }

  /* 将json文件中的内容读取出来，反序列化为HashMap */
  public static <K, V> Map<K, V> deserilizableForMapFromFile(String jsonString, Class<K> k, Class<V> v) {
    TypeReference<Map<K, V>> typeReference = new TypeReference<Map<K, V>>(k, v) {
    };
    Map<K, V> map = JSON.parseObject(jsonString, typeReference);
    return map;
  }

  public void study02() {
    String str = "{\"user1\":{\"name\":\"user1\",\"pswd\":\"123456\"},\"user2\":{\"name\":\"user2\",\"pswd\":\"123456\"}}";
    TypeReference<Map<String, User>> typeReference = new TypeReference<Map<String, User>>() {
    };
    Map<String, User> map = JSON.parseObject(str, typeReference);
    for (Map.Entry<String, User> e : map.entrySet()) {
      System.out.println(e.getKey() + ":" + e.getValue());
    }
  }

  public void study01() {
    Map<String, User> map = new HashMap<>();
    User user1 = new User("user1", "123456");
    User user2 = new User("user2", "123456");
    map.put("user1", user1);
    map.put("user2", user2);
    String jsonString = JSON.toJSONString(map);
    System.out.println(jsonString);
  }
}
