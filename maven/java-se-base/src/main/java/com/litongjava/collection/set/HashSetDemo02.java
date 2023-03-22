package com.litongjava.collection.set;

import java.util.HashSet;
import java.util.Set;
public class HashSetDemo02 {

  public static void main(String[] args) {
    AnyModel anyModel01 = new AnyModel();
    anyModel01.setId(10);
    
    AnyModel anyModel02 = new AnyModel();
    anyModel02.setId(10);
    
    System.out.println(anyModel01.equals(anyModel02));
    
    Set<AnyModel> hashSet = new HashSet<>();
    hashSet.add(anyModel01);
    hashSet.add(anyModel02);
    
    System.out.println(hashSet.size());
    
  }
}
