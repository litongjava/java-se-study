package com.litongjava.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserInfoDistinct {

  public static void main(String[] args) {
    List<UserInfo> list = new ArrayList<>();
    list.add(new UserInfo(1, "小明", 1));
    list.add(new UserInfo(2, "小s", 2));
    list.add(new UserInfo(1, "小明", 2));

    Map<Integer, UserInfo> map = list.stream().distinct().collect(Collectors.toMap(UserInfo::getId, u -> u));
    log.info("map:{}", map);
  }

}
