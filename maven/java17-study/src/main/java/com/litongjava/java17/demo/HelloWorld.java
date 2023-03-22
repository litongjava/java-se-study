package com.litongjava.java17.demo;

/**
 * @author create by Ping E Lee on 2022年8月24日 下午9:39:44 
 *
 */
public class HelloWorld {
  public static void main(String[] args) {
    var x = "Hello world";
	System.out.println(x);
    // get java version
	var key="java.version";
    String javaVersion = System.getProperty(key);
    System.out.println(javaVersion);
  }
}
