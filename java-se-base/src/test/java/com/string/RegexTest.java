package com.string;

import static org.junit.Assert.fail;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Administrator
 * @date 2019年1月30日_下午8:24:03 
 * @version 1.0 
 */
public class RegexTest {

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void test() {
    fail("Not yet implemented");
  }

  @Test
  public void test1() {
    String str = "[6]内资";
    Pattern p = Pattern.compile("[0-9]+");
    Matcher m = p.matcher(str);
    System.out.println(m.matches());
    while (m.find()) {
      System.out.println(m.group());
    }
  }

}
