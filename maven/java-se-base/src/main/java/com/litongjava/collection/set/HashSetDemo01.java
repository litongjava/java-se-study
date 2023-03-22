package com.litongjava.collection.set;

import java.util.HashSet;
import java.util.Set;

public class HashSetDemo01 {
  public static void main(String[] args) {
    // 创建一个Set集合
    Set<String> set = new HashSet<>();
    // 添加元素
    set.add("hello1");
    set.add("hello2");
    set.add("hello3");
    set.add("hello4");
    set.add("hello5");
    // 遍历
    for (String string : set) {
      System.out.println(string);
    }
  }
}
