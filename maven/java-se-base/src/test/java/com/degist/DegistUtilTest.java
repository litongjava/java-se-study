package com.degist;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import org.junit.Test;

import com.litongjava.degist.DegistUtil;

/**
 * @author litong
 * @date 2018年12月11日_上午8:51:42 
 * @version 1.0 
 */
public class DegistUtilTest {

  @Test
  public void test() {
    fail("Not yet implemented");
  }

  @Test
  public void getSha1() {
    String filePath="D:\\我的文档\\Tencent Files\\2410438230\\Image\\C2C\\$%SC93]M3O]G8R5O(3EFEU7.png";
    try {
      String sha1 = DegistUtil.getSha1(new File(filePath));
      System.out.println(sha1);
      //0066abd0db1e1e0ba53ec5f2cd7bd8fe4bfd3084
      //0066abd0db1e1e0ba53ec5f2cd7bd8fe4bfd3084
    } catch (OutOfMemoryError | NoSuchAlgorithmException | IOException e) {
      e.printStackTrace();
    }
  }
}
