package com.date;

import static org.junit.Assert.fail;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

/**
 * @author litong
 * @date 2018年9月13日_下午5:54:48 
 * @version 1.0 
 */
public class SDFTest {

  @Test
  public void test() {
    fail("Not yet implemented");
  }
  
  @Test
  public void test1() {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    try {
      Date parse = sdf.parse("2018-10-10 08:00:00");
    } catch (ParseException e) {
      e.printStackTrace();
    }
  }

}
