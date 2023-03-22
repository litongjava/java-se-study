package com.litongjava.string;

import lombok.extern.java.Log;

/**
 * @author litong
 * @date 2018年7月25日_下午4:10:02 
 * @version 1.0 
 */
@Log
public class StringObj {
  public static void main(String[] args) {
    StringObj stringObject = new StringObj();
    stringObject.test1();
  }
  
  public void test1() {
    String userID="13121933622";
    if (!userID.startsWith("tel_")) {
      userID = "tel_" + userID;
    }
    log.info("userID is : " + userID);
    
  }
}
