package com.litongjava.string;

import java.io.File;

public class StringSplit {
  public static void main(String[] args) {
    //getDependency();
    outFileSeparator();
  }

  public static void outFileSeparator(){
    System.out.println(File.separatorChar);
    System.out.println(File.separatorChar==92);
  }
  private static void getDependency() {
    String str="\\com\\alibaba\\csp\\sentinel-parameter-flow-control\\1.7.1\\";
    String[] split = str.split("\\\\");
    for (String s : split) {
      System.out.println(s);
    }
  }
}
