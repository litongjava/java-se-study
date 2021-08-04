package com.oop;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2019/8/13.
 */
public class UserTest {

  @Test
  public void getName() throws Exception {
    String name = new User().getName();
    System.out.println(name);
  }
}