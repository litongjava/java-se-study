package com.litongjava.matcher;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Ping E Lee
 *
 */
public class MatcherDemo01 {
  public static void main(String[] args) {
    // 需要处理的文本
    String string = "<content>内容1</content> <content>内容2</content>";
    // 正则表达式
    String regex = "<content>(.*?)</content>";
    // 将正则式编译成模板
    Pattern pattern = Pattern.compile(regex);
    // 将模板和字符串匹配返回匹配器
    Matcher matcher = pattern.matcher(string);
    // 判断是否有下索引,并且下向下移动索引
    while (matcher.find()) {
      // 取出goup中的内容
      String group = matcher.group();
      System.out.println(group);
      // groupCount
      int groupCount = matcher.groupCount();
      System.out.println("groupCount:" + groupCount);
      for (int i = 0; i < groupCount + 1; i++) {
        // 获取group片段
        String content = matcher.group(i);
        System.out.println(i + ":" + content);
      }

    }
  }
}
