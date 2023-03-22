package com.litongjava.collection.collections;
/**
 * @author litongjava <litongjava@qq.com>
 *
 */

import java.util.Collections;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SingleListDemo01 {

  public static void main(String[] args) {
    List<String> singletonList = Collections.singletonList("Ping");
    log.info("size:{}",singletonList.size());
    System.out.println(singletonList);
  }
}
