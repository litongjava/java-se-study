package com.litongjava.collection.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

public class TestComputeIfAbsent {
  static HashMap<String, Set<String>> hashMap = new HashMap<>();

  public static void main(String[] args) {
    Set<String> set = new HashSet<>();
    set.add("zhangSan");
    hashMap.put("china", set);

    hashMap.computeIfAbsent("china", new Function<String, Set<String>>() {
      @Override
      public Set<String> apply(String key) {
        System.out.println(key);
        return null;
      }
    });
    System.out.println(hashMap.toString());
  }
}