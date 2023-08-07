package com.litongjava.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

public class ListStreamTest {

  @Test
  public void test() {
    List<KvString> list = getList();
    Object[] array = list.stream().map(it -> it.getV()).toArray();
    for (Object object : array) {
      System.out.println(object);
    }
  }

  @Test
  public void test02() {
    //List<KvObject> list = getList();
    List<KvString> list=new ArrayList<>();
    //list.stream().map(BiddingPlanDetail::getInvesmentCode).collect(Collectors.joining(";"));
    String collect = list.stream().map(KvString::getV).collect(Collectors.joining(";"));
    System.out.println(collect);
  }
  private List<KvString> getList() {
    KvString kv1 = new KvString("name", "船舶识别");
    KvString kv2 = new KvString("name", "人脸识别");
    KvString kv3 = new KvString("name", "车牌识别");
    KvString kv4 = new KvString("name", "人员姿态识别");
    List<KvString> list = Arrays.asList(kv1, kv2, kv3, kv4);
    return list;
  }
  //fasle --> 否
  @Test
  public void testFalseToNO(){
    KvObject<String> kv1 = new KvObject("switch","false");
    List<KvObject<String>> list = Arrays.asList(kv1);
    list.forEach(it->{
      it.setV(it.getV()=="false"?"否":"是");
    });
    System.out.println(list);
  }




}
