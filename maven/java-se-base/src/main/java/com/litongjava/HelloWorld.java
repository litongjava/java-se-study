package com.litongjava;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author litong
 * @date 2018年6月15日_上午12:02:31
 * @version 1.0
 */
public class HelloWorld {
  private static final Logger log = LoggerFactory.getLogger(HelloWorld.class);
  
  public static void main(String[] args) {
    System.out.println("Hello,World");
    String msg="litong";
    log.debug("msg:{}", msg);
    log.info("msg:{}", msg);
  }
}
