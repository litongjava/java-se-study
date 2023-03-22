package com.litongjava.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

public class ListStreamTest {

  @Test
  public void test() {
    List<KvObject> list = getList();
    Object[] array = list.stream().map(it -> it.getV()).toArray();
    for (Object object : array) {
      System.out.println(object);
    }
  }

  @Test
  public void test02() {
    //List<KvObject> list = getList();
    List<KvObject> list=new ArrayList<>();
    //list.stream().map(BiddingPlanDetail::getInvesmentCode).collect(Collectors.joining(";"));
    String collect = list.stream().map(KvObject::getV).collect(Collectors.joining(";"));
    System.out.println(collect);
  }
  private List<KvObject> getList() {
    KvObject kv1 = new KvObject("name", "船舶识别");
    KvObject kv2 = new KvObject("name", "人脸识别");
    KvObject kv3 = new KvObject("name", "车牌识别");
    KvObject kv4 = new KvObject("name", "人员姿态识别");
    List<KvObject> list = Arrays.asList(kv1, kv2, kv3, kv4);
    return list;
  }

}
