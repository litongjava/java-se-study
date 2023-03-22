package com.litongjava.string;

public class StringCompareDemo01 {
  public static void main(String[] args) {
    int compare = String.CASE_INSENSITIVE_ORDER.compare("zhangsan", "lisi");
    System.out.println(compare);
  }
}
