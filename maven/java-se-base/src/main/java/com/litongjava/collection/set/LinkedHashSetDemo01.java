package com.litongjava.collection.set;

import java.util.LinkedHashSet;

public class LinkedHashSetDemo01 {

  public static void main(String[] args) {
    // 创建并添加元素
    LinkedHashSet<String> hs = new LinkedHashSet<String>();
    // 创建并添加元素
    hs.add("hello");
    hs.add("world");
    hs.add("java");
    hs.add("world");
    hs.add("java");
    // 遍历
    for (String s : hs) {
      System.out.println(s);
    }
  }
}
