package com.litongjava.xml;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author litong
 * @date 2018年12月4日_下午6:55:55 
 * @version 1.0 
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@XStreamAlias("user")
public class User {
  @XStreamAlias("username1")
  private String username;
  @XStreamAlias("password1")
  private String password;
}
