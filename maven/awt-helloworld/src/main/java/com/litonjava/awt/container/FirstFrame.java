package com.litonjava.awt.container;

import java.awt.Color;
import java.awt.Frame;

@SuppressWarnings("serial")
public class FirstFrame extends Frame {

  public static void main(String[] args) {
    // 实例化frame并设置名字
    FirstFrame fr = new FirstFrame("First contianer!!");
    // 设置Frame的大小
    fr.setSize(240, 240);
    // 设置Frame的背景色
    fr.setBackground(Color.yellow);
    // 设置Frame为可见
    fr.setVisible(true);
  }

  public FirstFrame(String str) {
    // 调用父类的构造方法
    super(str);
  }

}