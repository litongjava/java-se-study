package com.string;

import static org.junit.Assert.fail;
import java.util.Arrays;
import org.junit.Test;

/**
 * @author litong
 * @date 2018年7月25日_下午4:10:16 
 * @version 1.0 
 */
public class StringObjTest {

  @Test
  public void test() {
    fail("Not yet implemented");
  }

  @Test
  public void test1() {
    String q = "[李通][计算机][笔记本]";
    // 删除第一个字符
    if (q.startsWith("[")) {
      q = q.substring(1, q.length());
    }
    // 最后一个字符
    if (q.endsWith("]")) {
      q = q.substring(0, q.length() - 1);
    }
    // 按照 ][ 进行拆分
    String[] words = q.split("\\]\\[");
  }

  @Test
  public void subString() {
    String str = "litong";
    // substring 左开右闭
    String substring = str.substring(0, str.length());
    System.out.println(substring);
  }

  @Test
  public void split() {
    String words = "[成功]|[失败]";
    String[] split = words.split("\\|");
    System.out.println(Arrays.toString(split));
  }

  /**
   * 方式1 统计字符串中,子字符串的个数
   */
  @Test
  public void test3() {
    String string = "javajava_eclipse_class_jajavavajavajdjdj";
    String str = "java";
    int i = string.length() - string.replace(str, "").length();
    System.out.println(i / str.length());
  }

  /**
   * 统计字符串在字符中出现的次数
   * @param str
   * @param substr
   * @return
   */
  public int countSubstring(String str, String substr) {
    int subLength = str.replace(substr, "").length();
    int i = (str.length() - subLength) / (substr.length());
    return i;
  }
}
