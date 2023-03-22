package com.litongjava.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author litong
 * @date 2018年11月10日_上午9:15:28 
 * @version 1.0 
 */
public class StringFormatStudy {
  public static void main(String[] args) {
    StringFormatStudy study = new StringFormatStudy();
    // study.replace();
    study.regex();

  }

  public void regex() {
    String str = "[6] 转人工";
    String pattern = "[0-9]+";
    Pattern r = Pattern.compile(pattern);
    Matcher m = r.matcher(str);
    System.out.println(m.matches());
  }
  
  

  public void replace() {
    String a = "[1,2,3]";
    String b = a.replaceAll("[\\[\\]]", "");
    System.out.println(b);// b=1,2,3
    System.out.println(a);
  }

  public void format() {
    String user = "litong";
    String pswd = "passwd";
    String format = String.format("the user is %s and password is %s", user, pswd);
    System.out.println(format);
  }
}
